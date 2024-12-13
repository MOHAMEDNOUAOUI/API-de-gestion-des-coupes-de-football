package com.wora.coupesdefootball.Controller;

import com.wora.coupesdefootball.Service.MatchService;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.wora.coupesdefootball.DTO.Match.ResponseMatchDTO;
import com.wora.coupesdefootball.DTO.Match.CreateMatchDTO;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class MatchController {

    private final MatchService matchService;

    @PostMapping("/operator/matches/results")
    public ResponseEntity<ResponseMatchDTO> createMatch(@RequestBody @Valid CreateMatchDTO createMatchDTO) {
        ResponseMatchDTO response = matchService.createMatch(createMatchDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/public/results")
    public ResponseEntity<Page<ResponseMatchDTO>> getAllMatchs(Pageable pageable) {
        Page<ResponseMatchDTO> response = matchService.getAllMatchs(pageable);
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    @GetMapping("/{matchId}")
    public ResponseEntity<ResponseMatchDTO> getMatchById(@PathVariable("matchId") ObjectId  id){
        ResponseMatchDTO response = matchService.getMatchById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    @DeleteMapping("/{matchId}")
    public ResponseEntity<?> deleteMatchById(@PathVariable("matchId") ObjectId id){
        if(matchService.deleteMatch(id)){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Deleted Succefully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Something went wrong");
    }

    @PatchMapping("/{matchId}")
    public ResponseEntity<ResponseMatchDTO> updateMatch(@RequestBody CreateMatchDTO createMatchDTO , @PathVariable("matchId") ObjectId id){
        ResponseMatchDTO response = matchService.updateMatch(createMatchDTO , id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
