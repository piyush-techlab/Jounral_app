package Journal_app.Journal.App.repository;

import Journal_app.Journal.App.entry.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalRepository extends MongoRepository<JournalEntry,Integer> {
}
