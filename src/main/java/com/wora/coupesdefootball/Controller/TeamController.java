package com.wora.coupesdefootball.Controller;

import com.wora.coupesdefootball.Service.TeamService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.wora.coupesdefootball.DTO.Team.ResponseTeamDTO;
import com.wora.coupesdefootball.DTO.Team.CreateTeamDTO;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping("/admin/teams")
    public ResponseEntity<ResponseTeamDTO> createTeam(@RequestBody @Valid CreateTeamDTO createTeamDTO) {
        ResponseTeamDTO response = teamService.createTeam(createTeamDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/admin/teams")
    public ResponseEntity<Page<ResponseTeamDTO>> getAllTeams(Pageable pageable) {
        Page<ResponseTeamDTO> response = teamService.getAllTeams(pageable);
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    @GetMapping("/admin/{teamId}")
    public ResponseEntity<ResponseTeamDTO> getTeamById(@PathVariable("teamId") ObjectId id){
        ResponseTeamDTO response = teamService.getTeamById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    @DeleteMapping("/admin/{teamId}")
    public ResponseEntity<?> deleteTeamById(@PathVariable("teamId") ObjectId id){
        if(teamService.deleteTeam(id)){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Deleted Succefully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Something went wrong");
    }

    @PatchMapping("/admin/{teamId}")
    public ResponseEntity<ResponseTeamDTO> updateTeam(@RequestBody CreateTeamDTO createTeamDTO , @PathVariable("teamId") ObjectId id){
        ResponseTeamDTO response = teamService.updateTeam(createTeamDTO , id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
