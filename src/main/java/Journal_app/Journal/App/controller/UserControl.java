package Journal_app.Journal.App.controller;

import Journal_app.Journal.App.entry.User;
import Journal_app.Journal.App.repository.UserRepository;
import Journal_app.Journal.App.services.UserWorkerClass;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserControl
{

    @Autowired
    private UserWorkerClass userWorkerClass;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<User>> getUser()
    {
        return new ResponseEntity<>(userWorkerClass.getEntries(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> postUser(@RequestBody User user)
    {
        userWorkerClass.postUserEntries(user);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @DeleteMapping("/id/{user_id}")
    public ResponseEntity<?> deleteuserByID(@PathVariable String user_id)
    {
        userWorkerClass.deleteuserById(user_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/id/{user_id}")
    public ResponseEntity<Optional<User>> getuserById(@PathVariable String user_id)
    {
        Optional<User> user = userWorkerClass.getEntryByID(user_id);
        if (user == null)
        {
            throw new RuntimeException("Data Not Found");
        }
        else
        {
            return new ResponseEntity<>(userWorkerClass.getEntryByID(user_id),HttpStatus.OK);
        }
    }

    @PutMapping("id/{user_id}")
    public ResponseEntity<?> updateuserByID(@RequestBody User user, @PathVariable String user_id)
    {
        User old = userRepository.findById(user_id).orElse(null);
        if (old == null)
        {
            throw new RuntimeException("Data not Found");
        }

        old.setUsername(old.getUsername()!= user.getUsername() && !user.getUsername().equals("") ? user.getUsername():old.getUsername());
        old.setPassword(old.getPassword()!=user.getPassword() && !user.getPassword().equals("") ? user.getPassword() : old.getPassword() );
        userRepository.save(old);
        return new ResponseEntity<>(old,HttpStatus.OK);
    }
}