package com.example.xxx.controller;

import com.example.xxx.dto.AgreementDto;
import com.example.xxx.service.AgreementService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/agreements")
public class AgreementContoller {

    private final AgreementService agreementService;

    public AgreementContoller(AgreementService agreementService) {
        this.agreementService = agreementService;
    }

    @PostMapping
    public Long createAgreement(@RequestBody AgreementDto agreementDto) {
        return agreementService.createAgreement(agreementDto);
    }

    @GetMapping
    public List<AgreementDto> getAgreements() {
        return agreementService.getAgreements();
    }
}
