package com.wora.coupesdefootball.Service.Impl;
import com.wora.coupesdefootball.DTO.Players.ResponsePlayersDTO;
import com.wora.coupesdefootball.Entity.Players;
import com.wora.coupesdefootball.Exception.EntityNotFoundException;
import com.wora.coupesdefootball.Mapper.PlayersMapper;
import com.wora.coupesdefootball.Repository.PlayersRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import com.wora.coupesdefootball.Repository.TeamRepository;
import com.wora.coupesdefootball.DTO.Team.CreateTeamDTO;
import com.wora.coupesdefootball.DTO.Team.ResponseTeamDTO;
import org.springframework.stereotype.Service;
import com.wora.coupesdefootball.Service.TeamService;
import com.wora.coupesdefootball.Mapper.TeamMapper;
import com.wora.coupesdefootball.Entity.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private TeamMapper teamMapper;
    @Autowired
    private PlayersMapper playersMapper;
    @Autowired
    private PlayersRepository playersRepository;

    @Override
    public ResponseTeamDTO createTeam(CreateTeamDTO createTeamDTO) {
        Team entity = teamMapper.toEntity(createTeamDTO);


        List<ObjectId> playersIds = createTeamDTO.getPlayers().stream().map(Player -> {
            Players pl = playersMapper.toEntity(Player);
            return playersRepository.save(pl).getId();
        }).toList();

        entity.setPlayers(playersIds);
        Team team = teamRepository.save(entity);
        return teamMapper.toResponse(team);
    }

    @Override
    public Page<ResponseTeamDTO> getAllTeams(Pageable pageable) {
        Page<Team> teams = teamRepository.findAll(pageable);
        if (teams.isEmpty()){
            throw new RuntimeException("The are no teams yet");
        }
        return teams.map(team -> {
            System.out.println(team.getName());
            List<Players> players = playersRepository.findAllById(team.getPlayers());
            List<ResponsePlayersDTO> responsePlayersDTOs = players.stream().map(playersMapper::toResponse).toList();
            ResponseTeamDTO responseTeamDTO = teamMapper.toResponse(team);
            responseTeamDTO.setPlayers(responsePlayersDTOs);
            return responseTeamDTO;
        });
    }

    @Override
    public ResponseTeamDTO getTeamById(ObjectId id) {
        if(teamRepository.existsById(id)){
            Team team = teamRepository.findById(id).get();
            return teamMapper.toResponse(team);
        }else{
            throw new EntityNotFoundException("This Team with the id " + id + " doesn not exist");
        }
    }


    @Override
    public boolean deleteTeam(ObjectId id) {
        Optional<Team> team = teamRepository.findById(id);
        if (team.isPresent()){
            teamRepository.deleteById(id);
            return true;
        }
        else {
            throw new EntityNotFoundException("Team not found");
        }
    }

     @Override
    public ResponseTeamDTO updateTeam(CreateTeamDTO createTeamDTO , ObjectId id) {
        return null;
    }
}