package com.wora.coupesdefootball.Service;
import com.wora.coupesdefootball.DTO.Match.CreateMatchDTO;
import com.wora.coupesdefootball.DTO.Match.ResponseMatchDTO;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
public interface  MatchService {

    ResponseMatchDTO createMatch(CreateMatchDTO createMatchDTO);
    Page<ResponseMatchDTO> getAllMatchs(Pageable pageable);
    ResponseMatchDTO getMatchById(String id);
    ResponseMatchDTO updateMatch(CreateMatchDTO createMatchDTO , String id);
    boolean deleteMatch(String id);

}