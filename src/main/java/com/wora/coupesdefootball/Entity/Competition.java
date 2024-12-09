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
@Document(collection = "competition")
public class Competition {
    @Id
    private String id;
    private String name;
    private int numberOfTeams;
    private List<ObjectId> teamIds;
    private int currentRound;
    private List<ObjectId> roundIds;
}
