package Journal_app.Journal.App.repository;


import Journal_app.Journal.App.entry.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepo extends MongoRepository<JournalEntry,Integer> {

}
