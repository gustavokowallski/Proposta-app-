package com.pieropan.propostaapp.service;

import com.pieropan.propostaapp.dto.ProposalRequestDto;
import com.pieropan.propostaapp.dto.ProposalResponseDto;
import com.pieropan.propostaapp.entity.Proposal;
import com.pieropan.propostaapp.repository.ProposalRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProposalService {

    private final ProposalRepository proposalRepository;

    public ProposalService(ProposalRepository proposalRepository) {
        this.proposalRepository = proposalRepository;
    }


    @Transactional
    public ProposalResponseDto createProposal(ProposalRequestDto dto){
        Proposal entity = new Proposal();
         entity = proposalRepository.save(entity);
        return null;
    }
}
