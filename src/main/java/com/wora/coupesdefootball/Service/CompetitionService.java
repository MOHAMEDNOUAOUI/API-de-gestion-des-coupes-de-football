package com.wora.coupesdefootball.Service;
import com.wora.coupesdefootball.DTO.Competition.CreateCompetitionDTO;
import com.wora.coupesdefootball.DTO.Competition.ResponseCompetitionDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
public interface  CompetitionService {

    ResponseCompetitionDTO createCompetition(CreateCompetitionDTO createCompetitionDTO);
    Page<ResponseCompetitionDTO> getAllCompetitions(Pageable pageable);
    ResponseCompetitionDTO getCompetitionById(String id);
    ResponseCompetitionDTO updateCompetition(CreateCompetitionDTO createCompetitionDTO , String id);
    boolean deleteCompetition(String id);

}