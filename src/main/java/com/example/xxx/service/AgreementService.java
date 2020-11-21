package com.example.xxx.service;

import com.example.xxx.repository.AgreementRepository;
import org.springframework.stereotype.Service;

@Service
public class AgreementService {

    private final AgreementRepository agreementRepository;

    public AgreementService(AgreementRepository agreementRepository) {
        this.agreementRepository = agreementRepository;
    }



}
