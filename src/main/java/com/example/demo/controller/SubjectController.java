package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Subject;
import com.example.demo.service.SubjectService;

@RestController
@RequestMapping("/subject")
public class SubjectController {

	@Autowired
	private SubjectService subjectService;
	
	@GetMapping("/{id}")
	public Subject getSubjectById(@PathVariable Long id) throws Exception {
		Subject subject = subjectService.getSubject(id);
		return subject;
	}
	
	@PostMapping("")
	public Subject saveSubject(@RequestBody Subject subject) {
		Subject subjectSaved = subjectService.saveSubject(subject);
		return subjectSaved;
	}
}
