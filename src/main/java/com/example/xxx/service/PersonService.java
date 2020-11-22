package com.example.xxx.service;

import com.example.xxx.dto.PersonAgreementDto;
import com.example.xxx.dto.PersonDto;
import com.example.xxx.entity.Person;
import com.example.xxx.repository.PersonRepository;
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
        return personRepository.findAllWithAgreements(PageRequest.of(page, size)).map(person -> new PersonDto(person.getId(), person.getFirstName(), person.getPersonAgreements()));
    }

    public Optional<PersonDto> getPerson(Long id) {
        Optional<Person> personMaybe = personRepository.findByIdWithAgreements(id);
        return personMaybe.map(person -> new PersonDto(person.getId(), person.getFirstName(), person.getPersonAgreements()));
    }

    public Long createPerson(PersonDto personDto) {
        Person person = new Person(personDto.getFirstName());
        return personRepository.save(person).getId();
    }

    public void addAgreement(PersonAgreementDto personAgreementDto, Long personId) {
        Optional<Person> personMaybe = personRepository.findById(personId);
        if (personMaybe.isPresent()) {
            Person person = personMaybe.get();
            person.addAgreement(personAgreementDto);
            personRepository.save(person);
        } else {
            throw new RuntimeException("XD");
        }
    }
}
