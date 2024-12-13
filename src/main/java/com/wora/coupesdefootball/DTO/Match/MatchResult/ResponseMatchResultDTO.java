package com.wora.coupesdefootball.DTO.Match.MatchResult;

import com.wora.coupesdefootball.DTO.Match.Player.ResponsePlayerStatisticDTO;
import com.wora.coupesdefootball.DTO.Match.ResponseMatchDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMatchResultDTO {
    private int team1Goals;
    private int team2Goals;
    private List<ResponsePlayerStatisticDTO> statistics;
}
