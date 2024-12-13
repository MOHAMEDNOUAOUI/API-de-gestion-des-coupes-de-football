package com.wora.coupesdefootball.Repository;
import com.wora.coupesdefootball.Entity.Players;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayersRepository extends MongoRepository<Players, ObjectId> {
}
