package ru.dressyourkid.kidshop.configuration.security;

import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Token services for oauth.vk.com OAuth2 Authorization.
 */
public class VkUserInfoTokenServices extends UserInfoTokenServices {

    public VkUserInfoTokenServices(String userInfoEndpointUrl, String clientId) {
        super(userInfoEndpointUrl, clientId);
    }

    @Override
    public OAuth2Authentication loadAuthentication(String accessToken) throws AuthenticationException, InvalidTokenException {
        OAuth2Authentication authentication = super.loadAuthentication(accessToken);
        List<GrantedAuthority> authorities = extractAuthorities(authentication.getPrincipal());

        Map<String, Object> userDetails;
        if (authentication.getUserAuthentication().getDetails() instanceof Map) {
            userDetails = getResponse((Map) authentication.getUserAuthentication().getDetails());
        } else {
            userDetails = (Map<String, Object>) authentication.getUserAuthentication().getDetails();
        }

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                authentication.getPrincipal(), "N/A", authorities);
        token.setDetails(userDetails);
        return new OAuth2Authentication(authentication.getOAuth2Request(), token);
    }

    private List<GrantedAuthority> extractAuthorities(Object principal) {
        return Arrays.asList(new GrantedAuthority[] { new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER") });
    }

    @Override
    protected Object getPrincipal(Map<String, Object> map) {
        Map<String, Object> response = getResponse(map);
        Object id = response.get("id");
        return id;
    }

    private Map<String, Object> getResponse(Map<String, Object> map) {
        return (Map<String, Object>) ((List) map.get("response")).get(0);
    }
}
