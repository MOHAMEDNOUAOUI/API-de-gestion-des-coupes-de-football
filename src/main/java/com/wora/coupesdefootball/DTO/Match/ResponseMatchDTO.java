package com.wora.coupesdefootball.DTO.Match;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMatchDTO {
    private String id;
    private int round;
    private String team1;
    private String team2;
    private ResponseMatchResultDTO result;
    private String winner;

    public static class ResponseMatchResultDTO {
        private int team1Goals;
        private int team2Goals;
        private List<ResponsePlayerStatisticDTO> statistics;
    }

    public static class ResponsePlayerStatisticDTO {
        private String playerId;
        private int goals;
        private int assists;
        private int yellowCards;
        private int redCards;
    }
}
