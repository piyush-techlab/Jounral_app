package Journal_app.Journal.App.services;

import Journal_app.Journal.App.entry.JournalEntry;
import Journal_app.Journal.App.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class WorkerClass

{
    @Autowired
    private JournalRepository journalRepository;


    public List<JournalEntry> getEntries()
    {
        return journalRepository.findAll();
    }

    public Optional<JournalEntry> getEntryByID(int map_id)
    {
        return journalRepository.findById(map_id);
    }

    public void postEntries(JournalEntry user_entries)
    {
        journalRepository.save(user_entries);
    }

    public void deleteEntryByID(int map_id)
    {
        journalRepository.deleteById(map_id);
    }

    public void postEntryByID()
    {

    }


}
