package com.wora.coupesdefootball.DTO.Match.MatchResult;

import com.wora.coupesdefootball.DTO.Match.CreateMatchDTO;
import com.wora.coupesdefootball.DTO.Match.Player.CreatePlayerStatisticDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMatchResultDTO {
    private int team1Goals;
    private int team2Goals;
    private List<CreatePlayerStatisticDTO> statistics;
}