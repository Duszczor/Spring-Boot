package com.crud.demo.services;

import com.crud.demo.entities.Person;
import com.crud.demo.repositories.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    Logger logger = LoggerFactory.getLogger(PersonService.class);
    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional
    public List<Person> getPersons() {
        var persons = personRepository.findAll();
        logger.info("Founded {} persons", persons.size());
        return persons;
    }

    @Transactional
    public Person createPerson(Person person) {
        logger.info("Creating {}", person);
        return personRepository.save(person);
    }

    @Transactional
    public Person editPerson(Person person, Integer personId) {
        Optional<Person> personToEditOpt = personRepository.findById(personId);

        Person personToEdit = personToEditOpt.orElseThrow(() -> new RuntimeException());
        personToEdit.setLastName(person.getLastName());
        personToEdit.setFirstName(person.getFirstName());
        personToEdit.setAddress(person.getAddress());
        personToEdit.setCity(person.getCity());

        return personToEdit;
    }
}
