package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "teacher_table")
public class Teacher {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	@JoinColumn(name = "subject_fk")
	private Subject subject;

	@ManyToMany(cascade =CascadeType.ALL , fetch = FetchType.LAZY)
	@JoinTable(name = "class_teacher" ,
	joinColumns = @JoinColumn(name = "teacher_fk"),
	inverseJoinColumns = @JoinColumn(name = "classes_fk")
			)
	private List<Classes> classes;
	
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

	public Teacher() {
		super();
	}
	
	

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", subject=" + subject + ", classes=" + classes + "]";
	}

	public List<Classes> getClasses() {
		return classes;
	}

	public void setClasses(List<Classes> classes) {
		this.classes = classes;
	}

	public Teacher(Long id, String name, Subject subject, List<Classes> classes) {
		super();
		this.id = id;
		this.name = name;
		this.subject = subject;
		this.classes = classes;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}


	public void addClass(Classes classesSave) {
		classes.add(classesSave);
	}
	
	public void removeClass(Classes savedClass) {
		classes.remove(savedClass);
	}
}
