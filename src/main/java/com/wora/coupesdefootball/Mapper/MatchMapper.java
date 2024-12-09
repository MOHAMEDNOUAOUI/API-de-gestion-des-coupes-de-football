package com.wora.coupesdefootball.Mapper;

import com.wora.coupesdefootball.DTO.Match.CreateMatchDTO;
import com.wora.coupesdefootball.DTO.Match.ResponseMatchDTO;
import com.wora.coupesdefootball.Entity.Match;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MatchMapper {

    Match toEntity(CreateMatchDTO createMatchDTO);

    @Mapping(source = "result.team1Goals" , target = "result.team1Goals")
    @Mapping(source = "result.team2Goals" , target = "result.team2Goals")
    @Mapping(source = "result.statistics" , target = "result.statistics")
    ResponseMatchDTO toResponse (Match match);
}
