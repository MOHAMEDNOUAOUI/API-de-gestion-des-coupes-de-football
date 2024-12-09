package com.wora.coupesdefootball.Controller;


import com.wora.coupesdefootball.DTO.Auth.LoginDTO;
import com.wora.coupesdefootball.DTO.Utilisateur.CreateUtilisateurDTO;
import com.wora.coupesdefootball.Service.Impl.AuthService;
import com.wora.coupesdefootball.Service.UtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final UtilisateurService utilisateurService;
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(CreateUtilisateurDTO createUtilisateurDTO) {
        utilisateurService.register(createUtilisateurDTO);
        return ResponseEntity.ok("Registred Succefully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(LoginDTO loginDTO){
        String token = authService.login(loginDTO);
        return ResponseEntity.ok(token);
    }
}
