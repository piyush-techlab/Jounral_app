package Journal_app.Journal.App.services;

import Journal_app.Journal.App.entry.JournalEntry;
import Journal_app.Journal.App.entry.User;
import Journal_app.Journal.App.repository.JournalRepository;
import Journal_app.Journal.App.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class WorkerClass

{
    @Autowired
    private JournalRepository journalRepository;

    @Autowired
    private UserRepository userRepository;


    public List<JournalEntry> getEntries()
    {
        return journalRepository.findAll();
    }

    public Optional<JournalEntry> getEntryByID(int map_id)
    {
        return journalRepository.findById(map_id);
    }

    public void postEntries(JournalEntry user_entries, String username)
    {
        User user = userRepository.findByUsername(username);

        if (user == null)
        {
            throw new RuntimeException("User not found");
        }

        JournalEntry saveEntries =  journalRepository.save(user_entries);
        user.getJournalEntryList().add(saveEntries);
        userRepository.save(user);

    }

    public void deleteEntryByID(int map_id)
    {
        journalRepository.deleteById(map_id);
    }

    public void postEntryByID()
    {

    }


}
