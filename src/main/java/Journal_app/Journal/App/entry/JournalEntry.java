package Journal_app.Journal.App.entry;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("JournalEntryTest") //ORM mapping Java class with collection
public class JournalEntry {

    //Merge to Main Successful post approval
    @Id
    private int id;

    private String content;

    private String title;

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

}
