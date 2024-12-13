package com.wora.coupesdefootball.Service.Impl;


import com.wora.coupesdefootball.Config.JwtTokenUtil;
import com.wora.coupesdefootball.DTO.Auth.LoginDTO;
import com.wora.coupesdefootball.Entity.Utilisateur;
import com.wora.coupesdefootball.Repository.UtilisateurRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthService {

    private final UtilisateurRepository utilisateurRepository;
    private final JwtTokenUtil jwtTokenUtil;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;


    public String login(LoginDTO loginDTO){
        Utilisateur user = utilisateurRepository.findByUsername(loginDTO.getUsername())
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));


        if (!passwordEncoder.matches(loginDTO.getPassword() , user.getPassword())){
            throw new RuntimeException("invalid Password");
        }

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        loginDTO.getPassword(),
                        List.of(new SimpleGrantedAuthority(user.getRole().name()))
                )
        );


        String token =  jwtTokenUtil.generateToken(authentication);

        System.out.println(token);
        return token;
    }

}
