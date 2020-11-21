package com.example.xxx.dto;

public class AgreementDto {

    private final Long id;
    private final String name;

    public AgreementDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
