package com.wora.coupesdefootball.DTO.Utilisateur;

import com.wora.coupesdefootball.Entity.Enum.Role;
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

    private Role role = Role.ROLE_USER;
}