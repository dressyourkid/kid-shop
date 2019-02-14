package ru.dressyourkid.kidshop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import ru.dressyourkid.kidshop.model.ProductCreateDto;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by lconnected on 11/07/2018.
 */
public class ProductControllerTest extends ControllerDocumentedTest {


    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getProduct() throws Exception {
        mockMvc.perform(get("/product/100"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.notNullValue()))
                .andExpect(jsonPath("id", Matchers.notNullValue()))
                .andExpect(jsonPath("id", Matchers.equalTo(100)))
                .andExpect(jsonPath("name", Matchers.notNullValue()))
                .andExpect(jsonPath("description", Matchers.notNullValue()))
                .andExpect(jsonPath("price", Matchers.notNullValue()))
                .andExpect(jsonPath("exists", Matchers.notNullValue()))

//                .andDo(document("product-single-snippet"));

                .andDo(document("product-single-snippet",
                        responseFields(
                                fieldWithPath("id").description("Product id"),
                                fieldWithPath("name").description("Product name"),
                                fieldWithPath("description").description("Product description"),
                                fieldWithPath("price").description("Product price"),
                                fieldWithPath("exists").description("Product exists in the store"),
                                fieldWithPath("imageUrlList").description("All product image urls"),
                                fieldWithPath("mainImageUrl").description("Product's main image to display")
                        )));
    }

    @Test
    public void getProductList() throws Exception {
        mockMvc.perform(get("/product"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.notNullValue()))
                .andExpect(jsonPath("content", Matchers.notNullValue()))
                .andExpect(jsonPath("content[0]", Matchers.notNullValue()))
                .andExpect(jsonPath("content[0].id", Matchers.notNullValue()))
                .andDo(document("product-page-snippet",
                        this.pageableSnippet.and(
                                fieldWithPath("content").description("List of products"),
                                fieldWithPath("content[].id").description("Product id"),
                                fieldWithPath("content[].name").description("Product name"),
                                fieldWithPath("content[].description").description("Product description"),
                                fieldWithPath("content[].price").optional().description("Product price"),
                                fieldWithPath("content[].exists").optional().description("Product exists in the store"),
                                fieldWithPath("content[].imageUrlList").description("All product image urls"),
                                fieldWithPath("content[].mainImageUrl").description("Product's main image to display")
                        )));
    }

    @Test
    public void findProductsByCategory() throws Exception {
        mockMvc.perform(get("/category/2000/product"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.notNullValue()))
                .andExpect(jsonPath("content", Matchers.notNullValue()))
                .andExpect(jsonPath("content[0]", Matchers.notNullValue()))
                .andExpect(jsonPath("content[0].id", Matchers.notNullValue()))
                .andDo(document("products-by-category-page-snippet",
                        this.pageableSnippet.and(
                                fieldWithPath("content").description("List of products"),
                                fieldWithPath("content[].id").description("Product id"),
                                fieldWithPath("content[].name").description("Product name"),
                                fieldWithPath("content[].description").description("Product description"),
                                fieldWithPath("content[].price").optional().description("Product price"),
                                fieldWithPath("content[].exists").optional().description("Product exists in the store"),
                                fieldWithPath("content[].imageUrlList").description("All product image urls"),
                                fieldWithPath("content[].mainImageUrl").description("Product's main image to display")
                        )));
    }

    @Test
    public void searchProducts() throws Exception {
        mockMvc.perform(get("/product?search=apple"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.notNullValue()))
                .andExpect(jsonPath("content", Matchers.notNullValue()))
                .andExpect(jsonPath("content[0]", Matchers.notNullValue()))
                .andExpect(jsonPath("content[0].id", Matchers.notNullValue()))
                .andExpect(jsonPath("content[0].name", Matchers.containsString("apple")));
    }

    @Test
    @WithMockUser(username = "test1", roles = { "USER", "ADMIN" })
    public void addProduct() throws Exception {
        ProductCreateDto productCreateDto = new ProductCreateDto();
        productCreateDto.setName("Test");
        productCreateDto.setDescription("Test description");
        productCreateDto.setCategoryId(2002L);
        productCreateDto.setAmount(2L);
        productCreateDto.setPrice(new BigDecimal(24.41));
        productCreateDto.setImageUrlList(Arrays.asList("http://foo.bar/1.png", "http://foo.bar/323.png"));
        // todo add mainImageUrl

        mockMvc.perform(
            post("/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productCreateDto))
        )
            .andDo(print())
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$", Matchers.notNullValue()))
            .andExpect(jsonPath("mainImageUrl", Matchers.notNullValue()))
            .andDo(document("product-create-payload-snippet", requestFields(
                    fieldWithPath("id").ignored(),
                    fieldWithPath("name").description("Product name"),
                    fieldWithPath("description").description("Product description"),
                    fieldWithPath("categoryId").description("Id of product category"),
                    fieldWithPath("amount").description("Product's amount"),
                    fieldWithPath("price").description("Product's price"),
                    fieldWithPath("imageUrlList").description("List of urls with this product images"),
                    fieldWithPath("mainImageUrl").description("Url of main product image")
            )));
//        fieldWithPath("content").description("List of products"),

        // fixme weak checks
    }


}
