package pl.projekt.mikroblog.entry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.projekt.mikroblog.entry.entity.Entry;
import pl.projekt.mikroblog.entry.service.EntryService;

import java.util.Date;

@Controller
public class EntryCreator {

    EntryService entryService;

    public EntryCreator(EntryService entryService) {
        this.entryService = entryService;
    }

    @GetMapping("entrycreator")
    public String addEntry(Model model) {
        model.addAttribute("newEntry", new Entry());
        return "entry_creator";
    }

    @PostMapping("entrycreator/addentry")
    public String redirectEntry(Entry entry){
        Date currentdate = new Date();
        entry.setPublicationDate(currentdate);
        entry.setUserId(1); //id musi być pobierane od użytkownika, który aktualnie jest zalogowany
        entryService.addEntry(entry);
        return"redirect:/entrieslist";
    }





}
