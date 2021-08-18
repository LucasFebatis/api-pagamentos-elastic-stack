package com.febatis.pagamento.service;

import com.febatis.pagamento.model.Person;
import com.febatis.pagamento.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class PersonService {

    private static final Logger LOGGER = Logger.getLogger(PersonService.class.getName());

    @Autowired
    private PersonRepository repository;

    public void findExamples() {

        Person person = new Person("Gaspar Barancelli Junior");

        LOGGER.log(Level.INFO, "Persist");
        repository.save(person);
        LOGGER.log(Level.INFO, person.toString());

        LOGGER.log(Level.INFO, "Find");
        repository.findById(person.getId()).ifPresent(it -> {
            LOGGER.log(Level.INFO, person.toString());
        });

        Person person2 = new Person("Rodrigo Barancelli");

        LOGGER.log(Level.INFO, "Persist");
        repository.save(person2);
        LOGGER.log(Level.INFO, person2.toString());

        person2.setName("Rodrigo Dalla Valle Barancelli");
        LOGGER.log(Level.INFO, "Update");
        repository.save(person2);
        LOGGER.log(Level.INFO, person2.toString());

        LOGGER.log(Level.INFO, "FindAll");
        repository.findAll().forEach(it -> LOGGER.log(Level.INFO, it.toString()));

        LOGGER.log(Level.INFO, "Delete");
        repository.delete(person2);
        LOGGER.log(Level.INFO, person2.toString());
    }

    public List<Person> findAll() {
        LOGGER.log(Level.INFO, "FindAll");
        List<Person> all = repository.findAll();
        all.forEach(it -> LOGGER.log(Level.INFO, it.toString()));
        return all;
    }
}
