package com.wora.coupesdefootball.DTO.Players;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponsePlayersDTO {
    private ObjectId id;
    private String name;
    private String surname;
    private String position;
    private int number;
}