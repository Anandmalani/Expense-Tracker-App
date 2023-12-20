package com.example.ExpenseTrackerApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ExpenseTrackerApp.entity.Userr;

public interface UserRepository extends JpaRepository<Userr, Long> {
    
	Optional<Userr> findById(Integer id);

	void deleteById(Integer id);

	boolean existsByUsername(String username);

	Userr findByUsername(String username);

}


