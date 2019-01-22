package ru.dressyourkid.kidshop.controller;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by lconnected on 11/07/2018.
 */
public class ProductControllerTest extends ControllerDocumentedTest {

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
                                fieldWithPath("exists").description("Product exists in the store")
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
                                fieldWithPath("content[].exists").optional().description("Product exists in the store")
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
                                fieldWithPath("content[].exists").optional().description("Product exists in the store")
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

}
