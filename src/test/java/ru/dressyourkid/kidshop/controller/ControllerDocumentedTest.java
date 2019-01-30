package ru.dressyourkid.kidshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.restdocs.payload.ResponseFieldsSnippet;
import org.springframework.test.web.servlet.MockMvc;
import ru.dressyourkid.kidshop.ApplicationTest;

import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;

/**
 * Базовый тест для контроллеров <br>
 * Содержит protected переменную mockMvc для выполнения запросов <br>
 * Описывает правило сохранения сгенерированной документации
 */
@AutoConfigureMockMvc
@AutoConfigureRestDocs
public class ControllerDocumentedTest extends ApplicationTest {

    @Autowired
    protected MockMvc mockMvc;

    protected ResponseFieldsSnippet pageableSnippet = responseFields(
            fieldWithPath("pageable").description("Common information about the requested page"),
            fieldWithPath("pageable.sort").description("see below"),
            fieldWithPath("pageable.sort.sorted").description("see below"),
            fieldWithPath("pageable.sort.empty").description("sort is absent"),
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
            fieldWithPath("sort.empty").description("sort is absent"),
            fieldWithPath("sort.unsorted").description("content is unsorted"),
            fieldWithPath("numberOfElements").description("Amount of elements in current page"),
            fieldWithPath("size").description("wtf?"),
            fieldWithPath("number").description("wtf?"),
            fieldWithPath("empty").description("page has no data")
        );

}
