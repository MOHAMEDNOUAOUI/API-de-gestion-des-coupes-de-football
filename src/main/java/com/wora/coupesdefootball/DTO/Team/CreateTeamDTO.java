package com.wora.coupesdefootball.DTO.Team;

import com.wora.coupesdefootball.DTO.Players.CreatePlayersDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTeamDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String city;
    @NotEmpty
    private List<CreatePlayersDTO> players;
}