package Journal_app.Journal.App.services;

import Journal_app.Journal.App.entry.JournalEntry;
import Journal_app.Journal.App.entry.User;
import Journal_app.Journal.App.repository.JournalRepository;
import Journal_app.Journal.App.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class UserWorkerClass

{
    @Autowired
    private UserRepository userRepository;


    public List<User> getEntries()
    {
        return userRepository.findAll();
    }

    public Optional<User> getEntryByID(String user_id)
    {
        return userRepository.findById(user_id);
    }

    public void postUserEntries(User user)
    {
        userRepository.save(user);
    }

    public void deleteuserById(String user_id)
    {
        userRepository.deleteById(user_id);
    }

    public void postEntryByID()
    {

    }


}
