package com.wora.coupesdefootball.Service.Impl;
import com.wora.coupesdefootball.Exception.EntityNotFoundException;
import com.wora.coupesdefootball.Exception.UtilisateurFound;
import org.springframework.beans.factory.annotation.Autowired;
import com.wora.coupesdefootball.Repository.UtilisateurRepository;
import com.wora.coupesdefootball.DTO.Utilisateur.CreateUtilisateurDTO;
import com.wora.coupesdefootball.DTO.Utilisateur.ResponseUtilisateurDTO;
import org.springframework.stereotype.Service;
import com.wora.coupesdefootball.Service.UtilisateurService;
import com.wora.coupesdefootball.Mapper.UtilisateurMapper;
import com.wora.coupesdefootball.Entity.Utilisateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private UtilisateurMapper utilisateurMapper;

    @Override
    public void register(CreateUtilisateurDTO createUtilisateurDTO) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findByUsername(createUtilisateurDTO.getUsername());
        if (utilisateur.isPresent()){
            throw new UtilisateurFound("Utilisateur found already");
        }
        Utilisateur entity = utilisateurMapper.toEntity(createUtilisateurDTO);
        utilisateurRepository.save(entity);
    }

    @Override
    public Page<ResponseUtilisateurDTO> getAllUtilisateurs(Pageable pageable) {
        Page<Utilisateur> utilisateurs = utilisateurRepository.findAll(pageable);
        if (utilisateurs.isEmpty()){
            throw new RuntimeException("The are no utilisateurs yet");
        }
        return utilisateurs.map(utilisateurMapper::toResponse);
    }

    @Override
    public ResponseUtilisateurDTO getUtilisateurById(String id) {
        if(utilisateurRepository.existsById(id)){
            Utilisateur utilisateur = utilisateurRepository.findById(id).get();
            return utilisateurMapper.toResponse(utilisateur);
        }else{
            throw new EntityNotFoundException("This Utilisateur with the id " + id + " doesn not exist");
        }
    }


    @Override
    public boolean deleteUtilisateur(String id) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
        if (utilisateur.isPresent()){
            utilisateurRepository.deleteById(id);
            return true;
        }
        else {
            throw new EntityNotFoundException("Utilisateur not found");
        }
    }

     @Override
    public ResponseUtilisateurDTO updateUtilisateur(CreateUtilisateurDTO createUtilisateurDTO , String id) {
        return null;
    }
}