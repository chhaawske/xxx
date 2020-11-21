package com.example.xxx.dto;

public class PersonAgreementDto {

    private Long agreementId;
    private Boolean decision;

    public PersonAgreementDto() {
    }

    public Long getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(Long agreementId) {
        this.agreementId = agreementId;
    }

    public Boolean getDecision() {
        return decision;
    }

    public void setDecision(Boolean decision) {
        this.decision = decision;
    }
}
