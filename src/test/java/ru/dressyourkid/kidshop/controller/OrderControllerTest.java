package ru.dressyourkid.kidshop.controller;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import ru.dressyourkid.kidshop.model.ImageDto;
import ru.dressyourkid.kidshop.service.ImageService;
import ru.dressyourkid.kidshop.service.NotificationService;

import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by lconnected on 11/07/2018.
 */
public class OrderControllerTest extends ControllerDocumentedTest {

    @Mock
    private NotificationService emailNotificationService;

    @Autowired
    @InjectMocks
    private OrderController orderController;

    @Test
    public void testCreateOrder() throws Exception {

        initMocks(this);

        mockMvc.perform(post("/order")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{" +
                        "\"name\": \"Петрович Гусь\"," +
                        "\"phone\": \"+79788050211\"," +
                        "\"email\": \"levas1992@gmail.com\"," +
                        "\"shoppingCartProducts\": [" +
                        "{ \"productId\": 1764, \"amount\": 1 }" +
                        "]" +
                        "}"))
                .andDo(print())
                .andExpect(status().isCreated());
    }

}
