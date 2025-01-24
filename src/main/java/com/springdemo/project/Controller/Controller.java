package com.springdemo.project.Controller;

import com.springdemo.project.Entity.JournalEntry;
import com.springdemo.project.Service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.Optional;

@RestController
@RequestMapping("/journal")
public class Controller {

    @Autowired
    JournalService journalService;

    @GetMapping
    public List<JournalEntry> getAllEntries(){
        return journalService.getAllEntries();

    }

    @GetMapping("/{id}")
    public JournalEntry getEntryById(@PathVariable String id){
        return null;
    }

    @PostMapping("/entry")
    public JournalEntry createEntries(@RequestBody JournalEntry journalEntry){
        return journalService.createEntry(journalEntry);
    }

    @PutMapping("/{id}")
    public JournalEntry updateEntry(@PathVariable String id, @RequestBody JournalEntry journalEntry){
        Optional<JournalEntry> optionalJournalEntry = journalService.getEntry(id);
        JournalEntry journalEntry1 = optionalJournalEntry.get();
        journalEntry1.setContent(journalEntry.getContent());
        journalEntry1.setTitle(journalEntry.getTitle());
        return journalService.updateEntry(journalEntry1);


    }
    @DeleteMapping("/{id}")
    public String deleteEntries(@PathVariable String id) {
        journalService.deleteEntry(id);
        return "Deleted";
    }



}
