package com.example.ExpenseTrackerApp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.ExpenseTrackerApp.entity.Entry;
import com.example.ExpenseTrackerApp.service.EntryService;


import java.util.List;

@RestController
@RequestMapping("/entry")
public class EntryController {

	 @Autowired
	 private EntryService entryService;
	
	 @GetMapping
	 public List<Entry> getAllEntries() {
	     return entryService.getAllEntries();
	 }
	
	 @PostMapping
	 public void saveEntry(@RequestBody Entry expense) {
	      entryService.saveEntry(expense);
	 }
	
	 @DeleteMapping("/{id}")
	 public void deleteEntry(@PathVariable Integer id) {
	     entryService.deleteEntry(id);
	 }
	
	 @GetMapping("/{id}")
		public Entry getEntry(@PathVariable Integer id) {
			return entryService.getEntry(id);
			
		}
		@PutMapping("/{id}")
		public Entry updateBook(@RequestBody Entry e1 ,@PathVariable Integer id) {
			return entryService.updateEntry(e1,id);

			
			
		}

}

