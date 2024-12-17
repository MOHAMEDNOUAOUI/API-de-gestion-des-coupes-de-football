package com.wora.coupesdefootball.Controller;

import com.wora.coupesdefootball.Service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.wora.coupesdefootball.DTO.Competition.ResponseCompetitionDTO;
import com.wora.coupesdefootball.DTO.Competition.CreateCompetitionDTO;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/competition")
public class CompetitionController {

    @Autowired
    private CompetitionService competitionService;

    @PostMapping
    public ResponseEntity<ResponseCompetitionDTO> createCompetition(@RequestBody @Valid CreateCompetitionDTO createCompetitionDTO) {
        ResponseCompetitionDTO response = competitionService.createCompetition(createCompetitionDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<ResponseCompetitionDTO>> getAllCompetitions(Pageable pageable) {
        Page<ResponseCompetitionDTO> response = competitionService.getAllCompetitions(pageable);
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    @GetMapping("/{competitionId}")
    public ResponseEntity<ResponseCompetitionDTO> getCompetitionById(@PathVariable("competitionId") String id){
        ResponseCompetitionDTO response = competitionService.getCompetitionById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    @DeleteMapping("/{competitionId}")
    public ResponseEntity<?> deleteCompetitionById(@PathVariable("competitionId") String id){
        if(competitionService.deleteCompetition(id)){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Deleted Succefully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Something went wrong");
    }

    @PatchMapping("/{competitionId}")
    public ResponseEntity<ResponseCompetitionDTO> updateCompetition(@RequestBody CreateCompetitionDTO createCompetitionDTO , @PathVariable("competitionId") String id){
        ResponseCompetitionDTO response = competitionService.updateCompetition(createCompetitionDTO , id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
