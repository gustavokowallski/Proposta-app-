package com.pieropan.propostaapp.service;

import com.pieropan.propostaapp.dto.ProposalRequestDto;
import com.pieropan.propostaapp.dto.ProposalResponseDto;
import com.pieropan.propostaapp.entity.Proposal;
import com.pieropan.propostaapp.mapper.ProposalMapper;
import com.pieropan.propostaapp.repository.ProposalRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProposalService {

    private final ProposalRepository proposalRepository;
    private NotificationService notificationService;

    public ProposalService(ProposalRepository proposalRepository, NotificationService notificationService) {
        this.proposalRepository = proposalRepository;
        this.notificationService = notificationService;
    }


    @Transactional
    public ProposalResponseDto createProposal(ProposalRequestDto dto){
        Proposal entity = ProposalMapper.INSTANCE.convertDtoToProprosal(dto);

        ProposalResponseDto response = ProposalMapper.INSTANCE.convertEntityToDto( proposalRepository.save(entity));

        notificationService.notify(response, "proposta-pedente.ex" );

        return response;
    }


    @Transactional(readOnly = true)
    public List<ProposalResponseDto> findAll(){
        List<Proposal> proposalList  = proposalRepository.findAll();
        return proposalList.stream().map(ProposalMapper.INSTANCE::convertEntityToDto).toList();
    }
}
