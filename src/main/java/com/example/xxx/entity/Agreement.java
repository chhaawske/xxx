package com.example.xxx.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Agreement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Boolean decision;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    protected Agreement() {

    }

    public Agreement(Long id, Boolean decision) {
        this.id = id;
        this.decision = decision;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Person getPerson() {
        return person;
    }

    public Boolean getDecision() {
        return decision;
    }
}
