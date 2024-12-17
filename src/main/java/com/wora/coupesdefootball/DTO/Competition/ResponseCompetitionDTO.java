package com.wora.coupesdefootball.DTO.Competition;

import com.wora.coupesdefootball.DTO.Team.emdb.teamEmbd;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseCompetitionDTO {
    private String id;
    private String name;
    private int numberOfTeams;
    private List<teamEmbd> teamIds;
    private int currentRound;
//    private List<ObjectId> roundIds;
}