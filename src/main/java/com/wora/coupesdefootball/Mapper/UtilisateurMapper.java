package com.wora.coupesdefootball.Mapper;

import com.wora.coupesdefootball.DTO.Utilisateur.CreateUtilisateurDTO;
import com.wora.coupesdefootball.DTO.Utilisateur.ResponseUtilisateurDTO;
import com.wora.coupesdefootball.Entity.Utilisateur;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UtilisateurMapper {

    Utilisateur toEntity(CreateUtilisateurDTO createUtilisateurDto);
    @Mapping(source = "id" , target = "id")
    @Mapping(source = "username" , target = "username")
    @Mapping(source = "password" , target = "password")
    @Mapping(source = "role" , target = "role")
    ResponseUtilisateurDTO toResponse(Utilisateur utilisateur);
}