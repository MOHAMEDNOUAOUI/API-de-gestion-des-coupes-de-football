package com.wora.coupesdefootball.DTO.Team.emdb;

import com.wora.coupesdefootball.DTO.Players.ResponsePlayersDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class teamEmbd {
    private String name;
    private String city;
    private List<ResponsePlayersDTO> players;
}
