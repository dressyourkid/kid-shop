package ru.dressyourkid.kidshop.controller;

import org.hamcrest.Matchers;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by lconnected on 11/07/2018.
 */
public class StoreControllerTest extends ControllerDocumentedTest {

    @Test
    @Ignore
    public void createStore() throws Exception {
        mockMvc.perform(post("/store")
                .content("{" +
                        "\"product\": {\"id\": 3}," +
                        "\"discount\": {\"id\": 2}," +
                        "\"itemPrice\": 5.05" +
                        "}")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void getStore() throws Exception {
        mockMvc.perform(get("/store/1000"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.notNullValue()))
                .andDo(document("store-get-example"));
//                .andDo(document("store-get-example",
//                        responseFields(
//                                fieldWithPath("itemPrice").description("Actual item price in russian rubles"),
//                                fieldWithPath("variants").description("Variations of the good"),
//                        ),
//                        ControllerDocumentedTest.links()));
    }

}
