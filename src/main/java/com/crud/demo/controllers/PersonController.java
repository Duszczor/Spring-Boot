package com.crud.demo.controllers;

import com.crud.demo.entities.Person;
import com.crud.demo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {
    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons")
    public List<Person> getPersons(){
        return personService.getPersons();
    }

    @PostMapping("/persons")
    public Person createPerson(@RequestBody Person person){
        return personService.createPerson(person);
    }
    @PutMapping("/persons/{personId}")
    public Person editPerson(@RequestBody Person person, @PathVariable Integer personId){
        return personService.editPerson(person, personId);
    }
}
