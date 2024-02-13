package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Classes;
import com.example.demo.service.ClassesService;

@RestController
@RequestMapping("/classes")
public class ClassesController {
	
	@Autowired
	private ClassesService classService;
	
	@PostMapping("")
	public Classes saveClass(@RequestBody Classes classes) {
		return classService.saveClasses(classes);
	}
	
	@DeleteMapping("/{id}")
	public Classes deleteClass(@PathVariable Long id) throws Exception{
		return classService.deleteClassById(id);
	}
	
	@PostMapping("/edit")
	public Classes editClass(Long id , @RequestBody Classes classes) throws Exception{
		return classService.editClass(id, classes);
	}
	
	@GetMapping("/{id}")
	public Classes getClassById(@PathVariable Long id) throws Exception{
		return classService.getClassById(id);
	}
	
	
}
