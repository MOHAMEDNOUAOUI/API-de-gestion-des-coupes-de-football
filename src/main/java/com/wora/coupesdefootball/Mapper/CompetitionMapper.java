package com.wora.coupesdefootball.Mapper;

import com.wora.coupesdefootball.DTO.Competition.CreateCompetitionDTO;
import com.wora.coupesdefootball.DTO.Competition.ResponseCompetitionDTO;
import com.wora.coupesdefootball.Entity.Competition;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CompetitionMapper {

    Competition toEntity(CreateCompetitionDTO createCompetitionDto);
    ResponseCompetitionDTO toResponse(Competition competition);
}