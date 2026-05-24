package Journal_app.Journal.App.controller;

import Journal_app.Journal.App.entry.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;

@RestController
@RequestMapping("/Journal")
public class JournalEntryControl {

    Map<Integer , JournalEntry> journalEntries = new HashMap();

    @GetMapping
    public List<JournalEntry> getALL()
    {
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public boolean setValues(@RequestBody JournalEntry journalentry)
    {
        journalEntries.put(journalentry.getId(), journalentry);
        return true;
    }

    @GetMapping ("id/{map_id}")
    public JournalEntry getDetailsByID(@PathVariable int map_id)
    {
        return journalEntries.get(map_id);
    }

    @DeleteMapping ("id/{map_id}")
    public boolean deleteById(@PathVariable int map_id)
    {
        journalEntries.remove(map_id);
        return true;
    }

    @PutMapping ("id/{map_id}")
    public boolean updateById(@PathVariable int map_id, @RequestBody JournalEntry journalentry)
    {
        journalEntries.put(map_id, journalentry);
        return true;
    }

}
