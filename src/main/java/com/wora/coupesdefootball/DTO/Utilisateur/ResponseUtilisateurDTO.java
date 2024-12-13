package com.wora.coupesdefootball.DTO.Utilisateur;

import com.wora.coupesdefootball.Entity.Enum.ARole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseUtilisateurDTO {
    private String id;
    private String username;
    private String password;
    private ARole role;
}