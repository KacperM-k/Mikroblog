package pl.projekt.mikroblog.entry.service;

import pl.projekt.mikroblog.entry.entity.Entry;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface EntryService {

    List<Entry> findAllEntries();
    void addEntry(Entry entry);
    void deleteEntry(long id);
    Entry editEntry(long id);
    Optional<Entry> findEntryById(long id);
    List<Entry> findEntryByTitle(String title);
    List<Entry> findEntryByPublicationDate(Date date);




}
