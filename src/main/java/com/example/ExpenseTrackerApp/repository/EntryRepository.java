package com.example.ExpenseTrackerApp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ExpenseTrackerApp.entity.Entry;
import com.example.ExpenseTrackerApp.entity.Userr;

public interface EntryRepository extends JpaRepository<Entry, Long> {

	void deleteById(Integer id);
    // Additional query methods if needed

	Optional<Entry> findById(Integer id);

	List<Entry> findByUser(Userr user);

}

