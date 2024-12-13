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

    Match toEntity(CreateMatchDTO createMatchDTO);

//    @Mapping(source = "result" , target = "result")
//    @Mapping(source = "result.statistics" , target = "result.statistics")
    ResponseMatchDTO toResponse(Match match);

}
