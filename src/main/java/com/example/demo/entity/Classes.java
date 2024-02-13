package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "classes_table")
public class Classes {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id ;
	
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Classes(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Classes() {
		super();
	}

	@Override
	public String toString() {
		return "Classes [id=" + id + ", name=" + name + "]";
	}
	
	
}
