package com.crud.demo;

import com.crud.demo.services.PersonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;

//@AutoConfigureMockMvc
//@WebMvcTest(controllers = PersonController.class)
@SpringBootTest
@Testcontainers
@Sql({"/schema.sql" ,"/data.sql"})
public class SavePersonTest {

    @Autowired
    private PersonService personService;

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> neo4j = new PostgreSQLContainer<>("postgres:11.1");

    @Test
    void checkLoadData() {
        var persons = personService.getPersons();

        Assertions.assertFalse(persons.isEmpty());
    }

}
