package com.example.xxx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "person_agreement")
public class PersonAgreement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "agreement_id")
    private Agreement agreement;

    private Boolean decision;

    protected PersonAgreement() {

    }

    public PersonAgreement(Person person, Long agreementId, Boolean decision) {
        this.person = person;
        this.decision = decision;
        this.agreement = new Agreement(agreementId);
    }

    public Long getId() {
        return id;
    }

    public Boolean getDecision() {
        return decision;
    }

    public Agreement getAgreement() {
        return agreement;
    }

    public Person getPerson() {
        return person;
    }
}
