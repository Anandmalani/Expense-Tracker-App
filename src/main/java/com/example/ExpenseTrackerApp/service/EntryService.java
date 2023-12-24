package com.example.ExpenseTrackerApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ExpenseTrackerApp.entity.Entry;
import com.example.ExpenseTrackerApp.entity.Userr;
import com.example.ExpenseTrackerApp.repository.EntryRepository;

import jakarta.transaction.Transactional;

import java.util.List;

@Service
public class EntryService {
	private EntryRepository entryRepository;
	
	@Autowired
    public EntryService(EntryRepository entryRepository) {
		super();
		this.entryRepository = entryRepository;
	}

	
    
	@Transactional
    public List<Entry> getAllEntries() {
        return entryRepository.findAll();
    }
	@Transactional
    public void saveEntry(Entry entry) {
        entryRepository.save(entry);
    }


    @Transactional
	public void deleteEntry(Integer id) {
		// TODO Auto-generated method stub
//		System.out.println(id);
		 entryRepository.deleteById(id);
		
	}



    @Transactional
	public Entry getEntry(Integer id) {
		// TODO Auto-generated method stub
		return entryRepository.findById(id).get();
	}




	public Entry updateEntry(Entry e1, Integer id) {
		// TODO Auto-generated method stub
		e1.setId(id);
		entryRepository.save(e1);
		
		return e1;
	}



	public Userr getUserById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}



	



	public List<Entry> getAllEntriesForUser(Userr user) {
		// TODO Auto-generated method stub
		return entryRepository.findByUser(user);
//		return null;
	}

    // Additional methods as needed
}

