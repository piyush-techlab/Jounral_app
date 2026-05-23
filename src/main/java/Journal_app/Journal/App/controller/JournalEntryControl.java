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

}
