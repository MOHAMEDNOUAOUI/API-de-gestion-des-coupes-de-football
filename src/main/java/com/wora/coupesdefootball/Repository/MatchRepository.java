package com.wora.coupesdefootball.Repository;
import com.wora.coupesdefootball.Entity.Match;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends MongoRepository<Match,String> {
}
