package com.wora.coupesdefootball.DTO.Utilisateur;

import com.wora.coupesdefootball.Entity.Enum.RoleType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUtilisateurDTO {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotNull
    private RoleType role = RoleType.ROLE_CLIENT;
}