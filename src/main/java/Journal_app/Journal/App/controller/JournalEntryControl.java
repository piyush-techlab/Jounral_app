package Journal_app.Journal.App.controller;

import Journal_app.Journal.App.entry.JournalEntry;
import Journal_app.Journal.App.services.WorkerClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/Journal")
public class JournalEntryControl {

    @Autowired
    private WorkerClass workerClass;

    @GetMapping
    public List<JournalEntry> getEntries()
    {
        return workerClass.getEntries();
    }

    @PostMapping
    public boolean postEntries(@RequestBody JournalEntry journalEntry)
    {
        workerClass.postEntries(journalEntry);
        return true;
    }

    @DeleteMapping("/id/{map_id}")
    public boolean deleteEntriesByID(@PathVariable int map_id)
    {
        workerClass.deleteEntryByID(map_id);
        return true;
    }

    @GetMapping("/id/{map_id}")

    public JournalEntry getEntryByID(@PathVariable int map_id)
    {
        return workerClass.getEntryByID(map_id);
    }

    @PutMapping
    public void updateEntries()
    {

    }


}
