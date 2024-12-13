package com.wora.coupesdefootball.Mapper;

import com.wora.coupesdefootball.DTO.Players.CreatePlayersDTO;
import com.wora.coupesdefootball.DTO.Players.ResponsePlayersDTO;
import com.wora.coupesdefootball.Entity.Players;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PlayersMapper {

    Players toEntity(CreatePlayersDTO createPlayersDto);
    ResponsePlayersDTO toResponse(Players players);
}