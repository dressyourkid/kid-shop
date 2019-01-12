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
                        responseFields(
                                fieldWithPath("content").description("List of products"),
                                fieldWithPath("content[].id").description("Product id"),
                                fieldWithPath("content[].name").description("Product name"),
                                fieldWithPath("content[].description").description("Product description"),
                                fieldWithPath("content[].price").description("Product price"),
                                fieldWithPath("content[].exists").description("Product exists in the store"),
                                fieldWithPath("pageable").description("Common information about the requested page"),
                                fieldWithPath("pageable.sort").description("see below"),
                                fieldWithPath("pageable.sort.sorted").description("see below"),
                                fieldWithPath("pageable.sort.unsorted").description("see below"),
                                fieldWithPath("pageable.offset").description("The offset"),
                                fieldWithPath("pageable.pageSize").description("Size of page"),
                                fieldWithPath("pageable.pageNumber").description("Number of current page in request"),
                                fieldWithPath("pageable.paged").description("is paged"),
                                fieldWithPath("pageable.unpaged").description("is not paged"),
                                fieldWithPath("first").description("Indicates the page is first"),
                                fieldWithPath("last").description("Indicates the page is last"),
                                fieldWithPath("totalPages").description("Total amount of pages"),
                                fieldWithPath("totalElements").description("Total amount of elements"),
                                fieldWithPath("sort").description("sort params from server"),
                                fieldWithPath("sort.sorted").description("content is sorted"),
                                fieldWithPath("sort.unsorted").description("content is unsorted"),
                                fieldWithPath("numberOfElements").description("Amount of elements in current page"),
                                fieldWithPath("size").description("wtf?"),
                                fieldWithPath("number").description("wtf?")
                        )));
    }

}
