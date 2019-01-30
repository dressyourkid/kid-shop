package ru.dressyourkid.kidshop.controller;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import ru.dressyourkid.kidshop.model.ImageDto;
import ru.dressyourkid.kidshop.service.ImageService;

import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by lconnected on 11/07/2018.
 */
public class UploadControllerTest extends ControllerDocumentedTest {

    @Mock
    private ImageService imageService;

    @Autowired
    @InjectMocks
    private UploadController uploadController;

    @Test
    public void testUploadSingleImage() throws Exception {

        initMocks(this);

        Mockito.when(imageService.uploadHD(Mockito.any()))
                .thenReturn(new ImageDto("http://insecure.com/1.png", "https://secure.com/1.png"));

        mockMvc.perform(multipart("/upload")
                .file(new MockMultipartFile("file", new byte[]{})))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.notNullValue()))
                .andExpect(jsonPath("url", Matchers.notNullValue()))
                .andExpect(jsonPath("secureUrl", Matchers.notNullValue()))
                .andDo(document("upload-single-snippet",
                        responseFields(
                                fieldWithPath("url").description("Image url"),
                                fieldWithPath("secureUrl").description("Image url with ssl secure path (path)")
                        )));
    }

}
