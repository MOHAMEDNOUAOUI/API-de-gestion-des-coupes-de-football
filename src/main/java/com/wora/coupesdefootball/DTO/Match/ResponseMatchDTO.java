package com.wora.coupesdefootball.DTO.Match;

import com.wora.coupesdefootball.DTO.Match.MatchResult.ResponseMatchResultDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

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
}
