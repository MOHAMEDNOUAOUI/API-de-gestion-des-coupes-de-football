package com.wora.coupesdefootball.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "match")
public class Match {
    @Id
    private String id;
    private int round;
    private ObjectId team1;
    private ObjectId team2;


    public static class MatchResult {
        private int team1Goals;
        private int team2Goals;
        private List<PlayerStatistic> statistics;
    }

    public static class PlayerStatistic {
        private ObjectId playerId;
        private int goals;
        private int assists;
        private int yellowCards;
        private int redCards;
    }

}
