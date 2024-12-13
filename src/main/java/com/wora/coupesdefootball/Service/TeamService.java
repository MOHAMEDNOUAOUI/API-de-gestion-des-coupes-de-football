package com.wora.coupesdefootball.Service;
import com.wora.coupesdefootball.DTO.Team.CreateTeamDTO;
import com.wora.coupesdefootball.DTO.Team.ResponseTeamDTO;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
public interface  TeamService {

    ResponseTeamDTO createTeam(CreateTeamDTO createTeamDTO);
    Page<ResponseTeamDTO> getAllTeams(Pageable pageable);
    ResponseTeamDTO getTeamById(ObjectId id);
    ResponseTeamDTO updateTeam(CreateTeamDTO createTeamDTO , ObjectId id);
    boolean deleteTeam(ObjectId id);

}