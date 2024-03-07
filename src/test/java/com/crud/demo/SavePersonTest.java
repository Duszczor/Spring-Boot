package com.crud.demo;

import com.crud.demo.controllers.PersonController;
import com.crud.demo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@WebMvcTest(controllers = PersonController.class)
public class SavePersonTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;
}
