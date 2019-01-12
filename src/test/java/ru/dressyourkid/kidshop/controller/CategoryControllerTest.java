package ru.dressyourkid.kidshop.controller;

import org.hamcrest.Matchers;
import org.junit.Ignore;
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
public class CategoryControllerTest extends ControllerDocumentedTest {

    @Test
    public void getCategoryList() throws Exception {
        mockMvc.perform(get("/category"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.notNullValue()))
                .andExpect(jsonPath("content", Matchers.notNullValue()))
                .andExpect(jsonPath("content[0]", Matchers.notNullValue()))
                .andExpect(jsonPath("content[0].id", Matchers.notNullValue()))
                .andExpect(jsonPath("content[0].name", Matchers.notNullValue()))
                .andDo(document("category-all-page-snippet",
                        this.pageableSnippet.and(
                                fieldWithPath("content").description("List of categories"),
                                fieldWithPath("content[].id").description("Category id"),
                                fieldWithPath("content[].name").description("Category name")
                        )));
    }

}
