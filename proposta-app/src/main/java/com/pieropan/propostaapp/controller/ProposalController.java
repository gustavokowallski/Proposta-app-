package com.pieropan.propostaapp.controller;


import com.pieropan.propostaapp.dto.ProposalRequestDto;
import com.pieropan.propostaapp.dto.ProposalResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/proposal")
public class ProposalController {

    @PostMapping
    public ResponseEntity<ProposalResponseDto> createProposal(@RequestBody ProposalRequestDto dto ){
        return null;
    }

}
