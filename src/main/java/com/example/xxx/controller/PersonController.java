package com.example.xxx.controller;

import com.example.xxx.dto.PersonAgreementDto;
import com.example.xxx.dto.PersonDto;
import com.example.xxx.service.PersonService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public Page<PersonDto> getPersons(@RequestParam int page, @RequestParam int size) {
        return personService.getPersons(page, size);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> getPerson(@PathVariable Long id) {
        Optional<PersonDto> personDtoMaybe = personService.getPerson(id);
        return personDtoMaybe.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Long createPerson(@RequestBody PersonDto personDto) {
        return personService.createPerson(personDto);
    }

    @PostMapping("/{id}/agreement")
    public ResponseEntity<Void> addAgreement(@RequestBody PersonAgreementDto personAgreementDto, @PathVariable Long id) {
        personService.addAgreement(personAgreementDto, id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
