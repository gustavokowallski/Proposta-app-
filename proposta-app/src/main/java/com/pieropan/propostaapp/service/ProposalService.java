package com.pieropan.propostaapp.service;

import com.pieropan.propostaapp.dto.ProposalRequestDto;
import com.pieropan.propostaapp.dto.ProposalResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProposalService {


    @Transactional
    public ProposalResponseDto createProposal(ProposalRequestDto dto){
        return null;
    }
}
