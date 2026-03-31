package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.entity.journalEntry;
import net.engineeringdigest.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService     {
    @Autowired
    private JournalEntryRepository journalEntryRepository;
    @Autowired
    private UserService userService;
    @Transactional
    public void saveEntry(journalEntry journalEntry, String userName) {
        User user=userService.findByUserName(userName);
        journalEntry saved=journalEntryRepository.save(journalEntry);
        user.getJournalEntries().add(saved);
        userService.saveUser(user);

    }
    public void saveEntry(journalEntry journalEntryy){
        journalEntryRepository.save(journalEntryy);

    }
    public List<journalEntry> getAll(){
        return journalEntryRepository.findAll();
    }
    public Optional<journalEntry> fndById(ObjectId Id){
        return journalEntryRepository.findById(Id);

    }
    @Transactional
    public boolean deleteById(ObjectId Id, String userName){
        try {
            User user = userService.findByUserName(userName);

            boolean removed = user.getJournalEntries()
                    .removeIf(x -> x.getId().equals(Id));

            if (removed) {
                userService.saveUser(user);   // use correct method
                journalEntryRepository.deleteById(Id);
            }

            return removed;

        } catch (Exception e){
            System.out.println(e);
            throw new RuntimeException("An error occured while deleting the entry.", e);
        }
    }



}


