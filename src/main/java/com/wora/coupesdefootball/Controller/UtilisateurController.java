package com.wora.coupesdefootball.Controller;

import com.wora.coupesdefootball.Service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.wora.coupesdefootball.DTO.Utilisateur.ResponseUtilisateurDTO;
import com.wora.coupesdefootball.DTO.Utilisateur.CreateUtilisateurDTO;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;


    @GetMapping
    public ResponseEntity<Page<ResponseUtilisateurDTO>> getAllUtilisateurs(Pageable pageable) {
        Page<ResponseUtilisateurDTO> response = utilisateurService.getAllUtilisateurs(pageable);
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    @GetMapping("/{utilisateurId}")
    public ResponseEntity<ResponseUtilisateurDTO> getUtilisateurById(@PathVariable("utilisateurId") String id){
        ResponseUtilisateurDTO response = utilisateurService.getUtilisateurById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    @DeleteMapping("/{utilisateurId}")
    public ResponseEntity<?> deleteUtilisateurById(@PathVariable("utilisateurId") String id){
        if(utilisateurService.deleteUtilisateur(id)){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Deleted Succefully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Something went wrong");
    }

    @PatchMapping("/{utilisateurId}")
    public ResponseEntity<ResponseUtilisateurDTO> updateUtilisateur(@RequestBody CreateUtilisateurDTO createUtilisateurDTO , @PathVariable("utilisateurId") String id){
        ResponseUtilisateurDTO response = utilisateurService.updateUtilisateur(createUtilisateurDTO , id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
