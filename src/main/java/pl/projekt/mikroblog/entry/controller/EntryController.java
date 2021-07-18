package pl.projekt.mikroblog.entry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.projekt.mikroblog.entry.service.EntryService;

@Controller
public class EntryController {

    EntryService entryService;

    @Autowired
    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    @GetMapping("entrieslist")
    public String showAllEntries(Model model) {
        model.addAttribute("entries", entryService.findAllEntries());
        return "all_entries";
    }






}
