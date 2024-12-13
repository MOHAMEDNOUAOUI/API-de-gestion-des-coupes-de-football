package com.wora.coupesdefootball.DTO.Team;

import com.wora.coupesdefootball.DTO.Players.ResponsePlayersDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTeamDTO {
    private ObjectId id;
    private String name;
    private String city;
    private List<ResponsePlayersDTO> players;
}