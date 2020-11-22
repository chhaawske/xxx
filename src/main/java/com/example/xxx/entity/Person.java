package com.example.xxx.entity;

import com.example.xxx.dto.PersonAgreementDto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<PersonAgreement> personAgreements;

    protected Person() {

    }

    public Person(String firstName) {
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void addAgreement(PersonAgreementDto personAgreementDto) {
        PersonAgreement personAgreement = new PersonAgreement(this, personAgreementDto.getAgreementId(), personAgreementDto.getDecision());
        personAgreements.add(personAgreement);
    }

    public List<PersonAgreementDto> getPersonAgreements() {
        return personAgreements.stream()
                               .map(personAgreement -> new PersonAgreementDto(personAgreement.getAgreement().getId(), personAgreement.getDecision()))
                               .collect(Collectors.toList());
    }
}
