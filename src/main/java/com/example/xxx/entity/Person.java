package com.example.xxx.entity;

import com.example.xxx.dto.PersonAgreementDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    @OneToMany(mappedBy = "person")
    private List<Agreement> agreements;

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

    public List<Agreement> getAgreements() {
        return agreements;
    }

    public void addAgreement(PersonAgreementDto personAgreementDto) {
        agreements.add(new Agreement(personAgreementDto.getAgreementId(), personAgreementDto.getDecision()));
    }
}
