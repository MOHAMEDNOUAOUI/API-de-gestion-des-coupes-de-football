package com.wora.coupesdefootball.DTO.Team;

import com.wora.coupesdefootball.DTO.Players.CreatePlayersDTO;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTeamDTO {
    private String name;
    private String city;
    private List<CreatePlayersDTO> players;
}