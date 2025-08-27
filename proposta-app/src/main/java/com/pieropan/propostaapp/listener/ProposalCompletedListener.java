package com.pieropan.propostaapp.listener;

import com.pieropan.propostaapp.entity.Proposal;
import com.pieropan.propostaapp.repository.ProposalRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProposalCompletedListener {
    @Autowired
    private ProposalRepository proposalRepository;

    @RabbitListener(queues = "{rabbitmq.queue.proposalcompleted}")
    public void proposalCompleted(Proposal proposal){
        proposalRepository.save(proposal);
    }
}
