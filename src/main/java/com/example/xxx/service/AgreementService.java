package com.example.xxx.service;

import com.example.xxx.dto.AgreementDto;
import com.example.xxx.entity.Agreement;
import com.example.xxx.repository.AgreementRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgreementService {

    private final AgreementRepository agreementRepository;

    public AgreementService(AgreementRepository agreementRepository) {
        this.agreementRepository = agreementRepository;
    }

    public Long createAgreement(AgreementDto agreementDto) {
        Agreement agreement = new Agreement();
        agreement.setName(agreementDto.getName());
        return agreementRepository.save(agreement).getId();
    }

    public List<AgreementDto> getAgreements() {
        return agreementRepository.findAll().stream().map(agreement -> new AgreementDto(agreement.getId(), agreement.getName())).collect(Collectors.toList());
    }
}
