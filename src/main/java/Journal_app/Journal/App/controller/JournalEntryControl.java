package Journal_app.Journal.App.controller;

import Journal_app.Journal.App.entry.JournalEntry;
import Journal_app.Journal.App.entry.User;
import Journal_app.Journal.App.repository.JournalRepository;
import Journal_app.Journal.App.repository.UserRepository;
import Journal_app.Journal.App.services.UserWorkerClass;
import Journal_app.Journal.App.services.WorkerClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/Journal")
public class JournalEntryControl {

    @Autowired
    private WorkerClass workerClass;
    @Autowired
    private JournalRepository journalRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserWorkerClass userWorkerClass;

    @GetMapping ("/{username}")
    public ResponseEntity<?> getEntries(@PathVariable String username)
    {
       User user = userRepository.findByUsername(username);

       if(user !=null)
       {
           return new ResponseEntity<>(user,HttpStatus.OK);
       }
       else
       {
           throw new RuntimeException("User not found");
       }

    }

    @PostMapping ("/{username}")
    public ResponseEntity<?> postEntries(@RequestBody JournalEntry journalEntry, @PathVariable String username)
    {
        workerClass.postEntries(journalEntry,username);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @DeleteMapping("/user/{username}")
    public ResponseEntity<?> deleteByUsername(@PathVariable String username)
    {
        workerClass.deleteUserByUsername(username);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/user/{username}")
    public ResponseEntity<?> updateByUsername(@RequestBody User user, @PathVariable String username)
    {
        return new ResponseEntity<>(workerClass.updateEntryByUsername(user,username), HttpStatus.OK);
    }


//    @PutMapping("id/{map_id}")
//    public ResponseEntity<JournalEntry> updateEntries(@PathVariable int map_id, @RequestBody JournalEntry myentry)
//    {
//        JournalEntry old = journalRepository.findById(map_id).orElse(null);
//        if(old != null)
//        {
//            old.setTitle(myentry.getTitle()!= null && !myentry.getTitle().equals("") ? myentry.getTitle(): old.getTitle());
//            old.setContent(myentry.getContent()!= null && !myentry.getTitle().equals("") ? myentry.getContent():old.getContent());
//            journalRepository.save(old);
//            return new ResponseEntity<>(old, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }


}
