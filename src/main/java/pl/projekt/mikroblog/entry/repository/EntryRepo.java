package pl.projekt.mikroblog.entry.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.projekt.mikroblog.entry.entity.Entry;

@Repository
public interface EntryRepo extends JpaRepository<Entry, Long> {
}
