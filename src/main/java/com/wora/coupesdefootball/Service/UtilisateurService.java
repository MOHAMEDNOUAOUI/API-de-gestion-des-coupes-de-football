package com.wora.coupesdefootball.Service;
import com.wora.coupesdefootball.DTO.Utilisateur.CreateUtilisateurDTO;
import com.wora.coupesdefootball.DTO.Utilisateur.ResponseUtilisateurDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
public interface  UtilisateurService {

    void register(CreateUtilisateurDTO createUtilisateurDTO);
    Page<ResponseUtilisateurDTO> getAllUtilisateurs(Pageable pageable);
    ResponseUtilisateurDTO getUtilisateurById(String id);
    ResponseUtilisateurDTO updateUtilisateur(CreateUtilisateurDTO createUtilisateurDTO , String id);
    boolean deleteUtilisateur(String id);

}