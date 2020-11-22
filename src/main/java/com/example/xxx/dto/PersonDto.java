package com.example.xxx.dto;

import java.util.List;

public class PersonDto {

    private final Long id;
    private final String firstName;
    private List<PersonAgreementDto> personAgreementDtos;

    public PersonDto(Long id, String firstName, List<PersonAgreementDto> personAgreementDtos) {
        this.id = id;
        this.firstName = firstName;
        this.personAgreementDtos = personAgreementDtos;
    }

    public String getFirstName() {
        return firstName;
    }

    public Long getId() {
        return id;
    }

    public List<PersonAgreementDto> getPersonAgreementDtos() {
        return personAgreementDtos;
    }

}
