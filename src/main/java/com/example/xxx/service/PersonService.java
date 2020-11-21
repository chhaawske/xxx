package com.example.xxx.service;

import com.example.xxx.dto.PersonAgreementDto;
import com.example.xxx.entity.Agreement;
import com.example.xxx.repository.AgreementRepository;
import com.example.xxx.repository.PersonRepository;
import com.example.xxx.dto.PersonDto;
import com.example.xxx.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Page<PersonDto> getPersons(int page, int size) {
        return personRepository.findAll(PageRequest.of(page, size)).map(person -> new PersonDto(person.getId(), person.getFirstName()));
    }

    public Optional<PersonDto> getPerson(Long id) {
        Optional<Person> personMaybe = personRepository.findById(id);
        return personMaybe.map(person -> new PersonDto(person.getId(), person.getFirstName()));
    }

    public Long createPerson(PersonDto personDto) {
        Person person = new Person(personDto.getFirstName());
        return personRepository.save(person).getId();
    }

    public void addAgreement(PersonAgreementDto personAgreementDto, Long personId) {
        Optional<Person> personMaybe = personRepository.findById(personId);
        if (personMaybe.isPresent()) {

        } else {

        }
    }
}
