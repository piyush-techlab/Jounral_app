package Journal_app.Journal.App.entry;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("JournalEntryTest") //ORM mapping Java class with collection
@Data //LombokProject - Creating getter and setter in run time
public class JournalEntry {

    @Id
    private int id;

    private String content;

    private String title;

}
