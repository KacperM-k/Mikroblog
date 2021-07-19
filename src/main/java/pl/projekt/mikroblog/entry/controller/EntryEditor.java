//package pl.projekt.mikroblog.entry.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import pl.projekt.mikroblog.entry.entity.Entry;
//import pl.projekt.mikroblog.entry.service.EntryService;
//
//@Controller
//public class EntryEditor {
//
//    EntryService entryService;
//
//    public EntryEditor(EntryService entryService) {
//        this.entryService = entryService;
//    }
//
//    @GetMapping("entryeditor/{id}")
//    public String getEntryEditor(Model model, @PathVariable long id) {
//        model.addAttribute("entryToEdit", entryService.findEntryById(id));
//        return "entry_editor";
//    }
//
//    @PostMapping("entryeditor/edit")
//    public String editEntry(Entry entry) {
//
//        return "redirect:/entrieslist";
//    }
//}
