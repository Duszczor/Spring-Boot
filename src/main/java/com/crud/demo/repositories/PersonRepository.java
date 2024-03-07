package com.crud.demo.repositories;

import com.crud.demo.entities.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

    List<Person> findAll();
    @Query(value = "SELECT * FROM PERSONS WHERE CITY = 'Katowice'", nativeQuery = true)
    List<Person> findAllCustom();
};