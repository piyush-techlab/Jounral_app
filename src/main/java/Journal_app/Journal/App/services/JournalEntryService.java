package Journal_app.Journal.App.services;

import Journal_app.Journal.App.entry.JournalEntry;
import Journal_app.Journal.App.repository.JournalEntryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepo journalEntryRepo;


    public void saveEntry(JournalEntry journalEntry)
    {
        journalEntryRepo.save(journalEntry);
    }

    public List<JournalEntry> getAllEntries()
    {
        return journalEntryRepo.findAll();
    }

    public Optional<JournalEntry> getEntryById(int id)
    {
        return journalEntryRepo.findById(id);
    }

    public void delEntry(int id)
    {
        journalEntryRepo.deleteById(id);

    }





}
