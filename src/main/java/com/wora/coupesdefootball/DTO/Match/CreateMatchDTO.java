package com.wora.coupesdefootball.DTO.Match;

import java.util.List;

public class CreateMatchDTO {

    private int round;
    private String team1;
    private String team2;
    private CreateMatchResultDTO result;
    private String winner;


    public static class CreateMatchResultDTO {
        private int team1Goals;
        private int team2Goals;
        private List<CreatePlayerStatisticDTO> statistics;
    }

    public static class CreatePlayerStatisticDTO {
        private String playerId;
        private int goals;
        private int assists;
        private int yellowCards;
        private int redCards;
    }
}
