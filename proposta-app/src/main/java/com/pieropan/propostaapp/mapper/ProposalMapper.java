package com.pieropan.propostaapp.mapper;

import com.pieropan.propostaapp.dto.ProposalRequestDto;
import com.pieropan.propostaapp.dto.ProposalResponseDto;
import com.pieropan.propostaapp.entity.Proposal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ProposalMapper {
    @Mapping(target = "user.name", source = "name")
    @Mapping(target = "user.lastName", source = "lastName")
    @Mapping(target = "user.cpf", source = "cpf")
    @Mapping(target = "user.phone", source = "phone")
    @Mapping(target = "user.income", source = "income")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "approved", ignore = true)
    @Mapping(target = "integrated", ignore = true)
    @Mapping(target = "observation", ignore = true)
    Proposal convertDtoToProprosal(ProposalRequestDto proposalRequestDto);




}
