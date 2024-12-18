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
    private ObjectId id;
    private int round;
    private ObjectId team1;
    private ObjectId team2;
    private MatchResult result;
    private ObjectId winner;

    public String getId() {
        return id != null ? id.toHexString() : null;
    }

    public String getTeam1() {
        return team1 != null ? team1.toHexString() : null;
    }
    public String getTeam2() {
        return team2 != null ? team2.toHexString() : null;
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MatchResult {
        private int team1Goals;
        private int team2Goals;
        private List<PlayerStatistic> statistics;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PlayerStatistic {
        private ObjectId playerId;
        private int goals;
        private int assists;
        private int yellowCards;
        private int redCards;
    }

}
