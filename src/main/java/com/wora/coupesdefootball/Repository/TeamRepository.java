package com.wora.coupesdefootball.Repository;
import com.wora.coupesdefootball.Entity.Team;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends MongoRepository<Team,String> {
}
