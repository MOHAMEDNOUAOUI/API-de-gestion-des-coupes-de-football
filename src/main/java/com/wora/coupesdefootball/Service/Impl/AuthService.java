package com.wora.coupesdefootball.Service.Impl;


import com.wora.coupesdefootball.Config.JwtTokenUtil;
import com.wora.coupesdefootball.DTO.Auth.LoginDTO;
import com.wora.coupesdefootball.Entity.Utilisateur;
import com.wora.coupesdefootball.Repository.UtilisateurRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthService {

    private final UtilisateurRepository utilisateurRepository;
    private final JwtTokenUtil jwtTokenUtil;
    private final PasswordEncoder passwordEncoder;


    public String login(LoginDTO loginDTO){
        Utilisateur user = utilisateurRepository.findByUsername(loginDTO.getUsername())
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));


        if (!passwordEncoder.matches(loginDTO.getPassword() , user.getPassword())){
            throw new RuntimeException("invalid Password");
        }

        return jwtTokenUtil.generateToken(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        null,
                        List.of(new SimpleGrantedAuthority(user.getRole().name()))
                )
        );
    }

}
