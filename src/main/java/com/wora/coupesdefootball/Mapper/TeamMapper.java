package com.wora.coupesdefootball.Mapper;

import com.wora.coupesdefootball.DTO.Team.CreateTeamDTO;
import com.wora.coupesdefootball.DTO.Team.ResponseTeamDTO;
import com.wora.coupesdefootball.Entity.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TeamMapper {


    @Mapping(target = "players", ignore = true)
    Team toEntity(CreateTeamDTO createTeamDto);
    ResponseTeamDTO toResponse(Team team);
}