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
@Document(collection = "round")
public class Round {
    @Id
    private String id;
    private int roundNumber;
    private ObjectId competitionId;
    private List<ObjectId> matches;
}
