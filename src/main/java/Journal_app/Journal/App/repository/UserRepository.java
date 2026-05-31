package Journal_app.Journal.App.repository;

import Journal_app.Journal.App.entry.JournalEntry;
import Journal_app.Journal.App.entry.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Objects;

public interface UserRepository extends MongoRepository<User,String> {

   User findByUsername(String username);
}
