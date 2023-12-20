package com.example.ExpenseTrackerApp.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "entry")
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Float amount;

    private String description;

//    private LocalDateTime date;

//    public Entry(Integer id, Float amount, String description, LocalDateTime date, String category, Userr user) {
//		super();
//		this.id = id;
//		this.amount = amount;
//		this.description = description;
//		this.date = date;
//		this.category = category;
//		this.user = user;
//	}

	private String category;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private Userr user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public LocalDateTime getDate() {
//		return date;
//	}
//
//	public void setDate(LocalDateTime date) {
//		this.date = date;
//	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Userr getUser() {
		return user;
	}

	public void setUser(Userr user) {
		this.user = user;
	}

	public Entry() {
		super();
	}

	public Entry(Integer id, Float amount, String description, String category, Userr user) {
		super();
		this.id = id;
		this.amount = amount;
		this.description = description;
		this.category = category;
		this.user = user;
	}
	
    

    // Getters and setters

    // Constructors
}
