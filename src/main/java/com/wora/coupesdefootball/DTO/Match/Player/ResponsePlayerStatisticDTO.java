package com.wora.coupesdefootball.DTO.Match.Player;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponsePlayerStatisticDTO {
    private ObjectId playerId;
    private int goals;
    private int assists;
    private int yellowCards;
    private int redCards;
}
