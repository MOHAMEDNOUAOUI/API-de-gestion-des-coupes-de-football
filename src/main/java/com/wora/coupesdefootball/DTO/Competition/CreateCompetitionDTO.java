package com.wora.coupesdefootball.DTO.Competition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCompetitionDTO {
    private String name;
    private int numberOfTeams;
    private List<ObjectId> teamIds;
    private int currentRound;
    private List<ObjectId> roundIds;
}