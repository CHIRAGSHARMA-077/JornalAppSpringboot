package net.engineeringdigest.journalApp.entity;

import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "users") // tells this is mapped to mongodb, its instance will act like a row in mongodbb

@Data
public class User
{
    @Id
    private ObjectId id;
    @Indexed(unique = true)// to use this we have to set property in application.properties

    private String userName;

    private String password;
    private List<String> Roles;
    @DBRef
    private List<JournalEntry> journalEntries=new ArrayList<>();// here users and journal entries are not linked yet

    public User() {

    }
    // to link them DBRef is used in which  we are creating a reference of journal entries in users
    // journal entries meinn jo entries rakhi hai unka reference rakhegi pura document nhi title wagera kuch nhi hai
    // just a reference



}
