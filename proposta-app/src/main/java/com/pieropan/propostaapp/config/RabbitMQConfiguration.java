package com.pieropan.propostaapp.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {


    @Bean
    public Queue pendingProposalAnalysisQueue(){
        return QueueBuilder.durable("proposta-pendente.ms-analise-credito").build();
    }

    @Bean
    public Queue pendingProposalNotificationQueue(){
        return QueueBuilder.durable("proposta-pendente.ms-notificacao").build();
    }

    @Bean
    public Queue completedProposalAnalysisQueue(){
        return QueueBuilder.durable("proposta-concluida.ms-analise-credito").build();
    }

    @Bean
    public Queue completedProposalNotificationQueue(){
        return QueueBuilder.durable("proposta-concluida.ms-notificacao").build();
    }


}
