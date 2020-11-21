package com.example.xxx.dto;

public class PersonDto {

    private final Long id;
    private final String firstName;

    public PersonDto(Long id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Long getId() {
        return id;
    }
}
