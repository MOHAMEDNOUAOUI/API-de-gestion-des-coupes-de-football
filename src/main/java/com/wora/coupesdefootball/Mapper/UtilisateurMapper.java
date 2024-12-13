package com.wora.coupesdefootball.Mapper;

import com.wora.coupesdefootball.DTO.Utilisateur.CreateUtilisateurDTO;
import com.wora.coupesdefootball.DTO.Utilisateur.ResponseUtilisateurDTO;
import com.wora.coupesdefootball.Entity.Utilisateur;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UtilisateurMapper {

    @Mapping(source = "username" , target = "username")
    @Mapping(source = "password" , target = "password")
    @Mapping(source = "role" , target = "Arole")
    Utilisateur toEntity(CreateUtilisateurDTO createUtilisateurDto);

    ResponseUtilisateurDTO toResponse(Utilisateur utilisateur);
}