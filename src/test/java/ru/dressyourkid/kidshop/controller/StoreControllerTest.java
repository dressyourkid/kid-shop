package ru.dressyourkid.kidshop.controller;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.dressyourkid.kidshop.ApplicationTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by lconnected on 11/07/2018.
 */
@AutoConfigureMockMvc(secure = false)
public class StoreControllerTest extends ApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
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
                .andExpect(jsonPath("$", Matchers.notNullValue()));
    }

}
