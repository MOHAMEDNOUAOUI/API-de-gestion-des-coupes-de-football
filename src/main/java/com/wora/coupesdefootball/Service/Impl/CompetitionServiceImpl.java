package com.wora.coupesdefootball.Service.Impl;
import com.wora.coupesdefootball.Exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import com.wora.coupesdefootball.Repository.CompetitionRepository;
import com.wora.coupesdefootball.DTO.Competition.CreateCompetitionDTO;
import com.wora.coupesdefootball.DTO.Competition.ResponseCompetitionDTO;
import org.springframework.stereotype.Service;
import com.wora.coupesdefootball.Service.CompetitionService;
import com.wora.coupesdefootball.Mapper.CompetitionMapper;
import com.wora.coupesdefootball.Entity.Competition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;


@Service
public class CompetitionServiceImpl implements CompetitionService {

    @Autowired
    private CompetitionRepository competitionRepository;

    @Autowired
    private CompetitionMapper competitionMapper;

    @Override
    public ResponseCompetitionDTO createCompetition(CreateCompetitionDTO createCompetitionDTO) {
        Competition entity = competitionMapper.toEntity(createCompetitionDTO);
        Competition competition = competitionRepository.save(entity);
        return competitionMapper.toResponse(entity);
    }

    @Override
    public Page<ResponseCompetitionDTO> getAllCompetitions(Pageable pageable) {
        Page<Competition> competitions = competitionRepository.findAll(pageable);
        if (competitions.isEmpty()){
            throw new RuntimeException("The are no competitions yet");
        }
        return competitions.map(competitionMapper::toResponse);
    }

    @Override
    public ResponseCompetitionDTO getCompetitionById(String id) {
        if(competitionRepository.existsById(id)){
            Competition competition = competitionRepository.findById(id).get();
            return competitionMapper.toResponse(competition);
        }else{
            throw new EntityNotFoundException("This Competition with the id " + id + " doesn not exist");
        }
    }


    @Override
    public boolean deleteCompetition(String id) {
        Optional<Competition> competition = competitionRepository.findById(id);
        if (competition.isPresent()){
            competitionRepository.deleteById(id);
            return true;
        }
        else {
            throw new EntityNotFoundException("Competition not found");
        }
    }

     @Override
    public ResponseCompetitionDTO updateCompetition(CreateCompetitionDTO createCompetitionDTO , String id) {
        return null;
    }
}