package com.wora.coupesdefootball.Mapper;

import com.wora.coupesdefootball.DTO.Match.CreateMatchDTO;
import com.wora.coupesdefootball.DTO.Match.ResponseMatchDTO;
import com.wora.coupesdefootball.Entity.Match;
import org.bson.types.ObjectId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface MatchMapper {
    @Mapping(target = "team1" , ignore = true)
    @Mapping(target = "team2" , ignore = true)
    Match toEntity(CreateMatchDTO createMatchDTO);

    ResponseMatchDTO toResponse(Match match);

}
