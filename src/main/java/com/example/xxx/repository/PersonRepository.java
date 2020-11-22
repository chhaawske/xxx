package com.example.xxx.repository;

import com.example.xxx.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query(value = "SELECT p FROM Person p LEFT JOIN FETCH p.personAgreements", countQuery = "SELECT COUNT(p) FROM Person p")
    Page<Person> findAllWithAgreements(Pageable pageable);

    @Query(value = "SELECT p FROM Person p LEFT JOIN FETCH p.personAgreements LEFT JOIN WHERE p.id = :id")
    Optional<Person> findByIdWithAgreements(@Param(value = "id") Long id);
}
