package com.pieropan.propostaapp.repository;

import com.pieropan.propostaapp.entity.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal, Long> {


    List<Proposal> findAllByIntegratedIsFalse();
}
