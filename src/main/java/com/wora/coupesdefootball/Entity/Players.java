package com.wora.coupesdefootball.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "players")
public class Players {
    @Id
    private String id;
    private String name;
    private String surname;
    private String position;
    private int number;
}
