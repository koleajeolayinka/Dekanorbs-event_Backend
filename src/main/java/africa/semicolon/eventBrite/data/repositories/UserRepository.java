package africa.semicolon.eventBrite.data.repositories;

import africa.semicolon.eventBrite.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
        Optional<User> findByEmail(String email);
}

