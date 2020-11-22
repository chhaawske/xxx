package com.example.xxx.dto;

public class PersonAgreementDto {

    private Long agreementId;
    private Boolean decision;

    public PersonAgreementDto() {
    }

    public PersonAgreementDto(Long agreementId, Boolean decision) {
        this.agreementId = agreementId;
        this.decision = decision;
    }

    public Long getAgreementId() {
        return agreementId;
    }

    public Boolean getDecision() {
        return decision;
    }

}
