package ru.dressyourkid.kidshop.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.web.filter.CompositeFilter;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.List;

/**
 * OAuth2 configuration
 */
@Configuration
public class OAuth2Configuration {

    @Qualifier("oauth2ClientContext")
    @Autowired
    private OAuth2ClientContext oauth2ClientContext;

    @Bean
    public Filter ssoCompositeFilter() {
        CompositeFilter filter = new CompositeFilter();
        List<Filter> filters = new ArrayList<>();
        filters.add(createSsoFilter("/connect/facebook", facebookDetails(), facebookResource()));
        filters.add(createSsoFilter("/connect/vk", vkDetails(), vkResource()));
        filter.setFilters(filters);
        return filter;
    }

    @Bean
    @ConfigurationProperties("oauth2.facebook.client")
    public AuthorizationCodeResourceDetails facebookDetails() {
        return new AuthorizationCodeResourceDetails();
    }

    @Bean
    @ConfigurationProperties("oauth2.facebook.resource")
    public ResourceServerProperties facebookResource() {
        return new ResourceServerProperties();
    }

    @Bean
    @ConfigurationProperties("oauth2.vk.client")
    public AuthorizationCodeResourceDetails vkDetails() {
        return new AuthorizationCodeResourceDetails();
    }

    @Bean
    @ConfigurationProperties("oauth2.vk.resource")
    public ResourceServerProperties vkResource() {
        return new ResourceServerProperties();
    }

    @Bean
    public FilterRegistrationBean oauth2ClientFilterRegistration(
            OAuth2ClientContextFilter filter) {
        FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<>();
        registration.setFilter(filter);
        registration.setOrder(-100);
        return registration;
    }

    private Filter createSsoFilter(String filterUrl, AuthorizationCodeResourceDetails resourceDetails, ResourceServerProperties serverProperties) {
        OAuth2ClientAuthenticationProcessingFilter facebookOAuthFilter = new OAuth2ClientAuthenticationProcessingFilter(filterUrl);
        OAuth2RestTemplate auth2RestTemplate = new OAuth2RestTemplate(resourceDetails, oauth2ClientContext);
        facebookOAuthFilter.setRestTemplate(auth2RestTemplate);
        UserInfoTokenServices tokenServices = new UserInfoTokenServices(serverProperties.getUserInfoUri(), resourceDetails.getClientId());
        tokenServices.setRestTemplate(auth2RestTemplate);
        facebookOAuthFilter.setTokenServices(tokenServices);
        return facebookOAuthFilter;
    }

}
