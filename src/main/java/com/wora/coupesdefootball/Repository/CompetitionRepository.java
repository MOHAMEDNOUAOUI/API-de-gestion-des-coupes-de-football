package com.wora.coupesdefootball.Repository;
import com.wora.coupesdefootball.Entity.Competition;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionRepository extends MongoRepository<Competition,String> {
}
