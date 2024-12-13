package com.wora.coupesdefootball.Entity;
import com.wora.coupesdefootball.Entity.Enum.ARole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "utilisateur")
public class Utilisateur {
    @Id
    private ObjectId id;

    @NotBlank
    private String username;
    @NotBlank
    private String password;

    @NotNull
    private ARole Arole;
}
