package com.wora.coupesdefootball.Service.Impl;
import com.wora.coupesdefootball.Exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import com.wora.coupesdefootball.Repository.MatchRepository;
import com.wora.coupesdefootball.DTO.Match.CreateMatchDTO;
import com.wora.coupesdefootball.DTO.Match.ResponseMatchDTO;
import org.springframework.stereotype.Service;
import com.wora.coupesdefootball.Service.MatchService;
import com.wora.coupesdefootball.Mapper.MatchMapper;
import com.wora.coupesdefootball.Entity.Match;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private MatchMapper matchMapper;

    @Override
    public ResponseMatchDTO createMatch(CreateMatchDTO createMatchDTO) {
        Match entity = matchMapper.toEntity(createMatchDTO);
        Match match = matchRepository.save(entity);
        return matchMapper.toResponse(entity);
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