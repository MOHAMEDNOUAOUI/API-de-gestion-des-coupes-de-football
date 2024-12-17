package com.wora.coupesdefootball.Repository;
import com.wora.coupesdefootball.Entity.Utilisateur;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends MongoRepository<Utilisateur, String> {
    Optional<Utilisateur> findByUsername(String username);
}
