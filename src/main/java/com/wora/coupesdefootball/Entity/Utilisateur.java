package com.wora.coupesdefootball.Entity;
import com.wora.coupesdefootball.Entity.Enum.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "utilisateur")
public class Utilisateur {
    @Id
    private String id;

    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotNull
    private Role role;
}
