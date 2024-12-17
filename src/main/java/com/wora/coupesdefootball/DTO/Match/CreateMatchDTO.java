package com.wora.coupesdefootball.DTO.Match;

import com.wora.coupesdefootball.DTO.Match.MatchResult.CreateMatchResultDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.util.List;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateMatchDTO {

    private int round;
    private String team1;
    private String team2;
    private CreateMatchResultDTO result;


}
