package Journal_app.Journal.App.controller;

import Journal_app.Journal.App.entry.JournalEntry;
import Journal_app.Journal.App.services.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/Journal")
public class JournalEntryControl {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getALL()
    {
      return journalEntryService.getAllEntries();
    }

    @PostMapping
    public boolean setValues(@RequestBody JournalEntry journalEntry)
    {

        journalEntryService.saveEntry(journalEntry);
        return true;

    }

    @GetMapping ("id/{map_id}")
    public JournalEntry getDetailsByID(@PathVariable int map_id)
    {
        return journalEntryService.getEntryById(map_id).orElse(null);
    }

    @DeleteMapping ("id/{map_id}")
    public boolean deleteById(@PathVariable int map_id)
    {
        journalEntryService.delEntry(map_id);
        return true;
    }

    @PutMapping ("id/{map_id}")
    public boolean updateById(@PathVariable int map_id, @RequestBody JournalEntry journalentry)
    {
        return true;
    }

}
