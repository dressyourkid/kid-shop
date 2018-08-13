package ru.dressyourkid.kidshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import ru.dressyourkid.kidshop.ApplicationTest;

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

}
