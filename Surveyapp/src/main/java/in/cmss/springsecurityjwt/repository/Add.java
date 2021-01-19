package in.cmss.springsecurityjwt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import in.cmss.springsecurityjwt.Addition;

@Repository
public interface Add extends MongoRepository<Addition, Integer> {

}
