package com.wora.coupesdefootball.Service.Impl;
import com.wora.coupesdefootball.DTO.Match.Player.CreatePlayerStatisticDTO;
import com.wora.coupesdefootball.Entity.Players;
import com.wora.coupesdefootball.Entity.Team;
import com.wora.coupesdefootball.Exception.EntityNotFoundException;
import com.wora.coupesdefootball.Repository.PlayersRepository;
import com.wora.coupesdefootball.Repository.TeamRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import com.wora.coupesdefootball.Repository.MatchRepository;
import com.wora.coupesdefootball.DTO.Match.CreateMatchDTO;
import com.wora.coupesdefootball.DTO.Match.ResponseMatchDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.wora.coupesdefootball.Service.MatchService;
import com.wora.coupesdefootball.Mapper.MatchMapper;
import com.wora.coupesdefootball.Entity.Match;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private MatchMapper matchMapper;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private PlayersRepository playersRepository;

    @Override
    public ResponseMatchDTO createMatch(CreateMatchDTO createMatchDTO) {


        Optional<Team> team1 = teamRepository.findById(createMatchDTO.getTeam1());
        Optional<Team> team2 = teamRepository.findById(createMatchDTO.getTeam2());

        if (team2.isEmpty() || team1.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "One or both teams do not exist");
        }



        List<CreatePlayerStatisticDTO> playerStatistic = createMatchDTO.getResult().getStatistics();

        List<ObjectId> team1Players = team1.get().getPlayers();
        List<ObjectId> team2Players = team2.get().getPlayers();


        for (CreatePlayerStatisticDTO playerStat : playerStatistic) {
            boolean isPlayerInTeam1 = team1Players.contains(playerStat.getPlayerId());
            boolean isPlayerInTeam2 = team2Players.contains(playerStat.getPlayerId());

            if (!isPlayerInTeam1 && !isPlayerInTeam2) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Player " + playerStat.getPlayerId() + " is not in either team");
            }
        }

        Match entity = matchMapper.toEntity(createMatchDTO);
        Match match = matchRepository.save(entity);
        return matchMapper.toResponse(match);
    }

    @Override
    public Page<ResponseMatchDTO> getAllMatchs(Pageable pageable) {
        Page<Match> matchs = matchRepository.findAll(pageable);
        if (matchs.isEmpty()){
            throw new RuntimeException("The are no matchs yet");
        }
        return matchs.map(matchMapper::toResponse);
    }

    @Override
    public ResponseMatchDTO getMatchById(String id) {
        if(matchRepository.existsById(id)){
            Match match = matchRepository.findById(id).get();
            return matchMapper.toResponse(match);
        }else{
            throw new EntityNotFoundException("This Match with the id " + id + " doesn not exist");
        }
    }

    @Override
    public ResponseMatchDTO updateMatch(CreateMatchDTO createMatchDTO, String id) {
        return null;
    }


    @Override
    public boolean deleteMatch(String id) {
        Optional<Match> match = matchRepository.findById(id);
        if (match.isPresent()){
            matchRepository.deleteById(id);
            return true;
        }
        else {
            throw new EntityNotFoundException("Match not found");
        }
    }

}