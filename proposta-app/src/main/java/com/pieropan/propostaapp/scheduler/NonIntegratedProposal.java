package com.pieropan.propostaapp.scheduler;

import com.pieropan.propostaapp.repository.ProposalRepository;
import com.pieropan.propostaapp.service.NotificationRabbitService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NonIntegratedProposal {
    private final ProposalRepository proposalRepository;

    private final NotificationRabbitService notificationRabbitService;

    private final String exchange;

    public NonIntegratedProposal(ProposalRepository proposalRepository,
                                 NotificationRabbitService notificationRabbitService,
                                 @Value("${rabbitmq.pendingproposal.exchange}") String exchange){
        this.proposalRepository = proposalRepository;
        this.notificationRabbitService = notificationRabbitService;
        this.exchange = exchange;
    }

    public void searchNonIntegratedProposal(){
        proposalRepository.findAllByIntegratedIsFalse().forEach(proposal ->{
            try{
                notificationRabbitService.notify(proposal, exchange);
                proposal.setIntegrated(true);
                proposalRepository.save(proposal);
            } catch (RuntimeException ex) {
                    
            }

        });
    }
}
