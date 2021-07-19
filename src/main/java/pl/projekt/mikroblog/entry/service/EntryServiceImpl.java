package pl.projekt.mikroblog.entry.service;

import org.springframework.stereotype.Repository;
import pl.projekt.mikroblog.entry.entity.Entry;
import pl.projekt.mikroblog.entry.repository.EntryRepo;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class EntryServiceImpl implements EntryService {

    EntryRepo entryRepo;

    public EntryServiceImpl(EntryRepo entryRepo) {
        this.entryRepo = entryRepo;
    }

    @Override
    public List<Entry> findAllEntries() {
        return entryRepo.findAll();
    }

    @Override
    public void addEntry(Entry entry) {
        entryRepo.save(entry);
    }

    @Override
    public void deleteEntry(long id) {
        entryRepo.deleteById(id);
    }

    @Override
    public Entry editEntry(long id) {
        return null;
    }

    @Override
    public Optional<Entry> findEntryById(long id) {
        return entryRepo.findById(id);
    }

    @Override
    public List<Entry> findEntryByTitle(String title) {
        List<Entry> allEntries = findAllEntries();
        return allEntries.stream().filter(entry -> entry.getTitle().equals(title)).collect(Collectors.toList());
    }

    @Override
    public List<Entry> findEntryByPublicationDate(Date date) {
        List<Entry> allEntries = findAllEntries();
        return allEntries.stream().filter(entry -> entry.getPublicationDate() == date).collect(Collectors.toList());
    }
}
