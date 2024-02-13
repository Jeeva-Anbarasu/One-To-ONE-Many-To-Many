package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Teacher;
import com.example.demo.service.TeacherService;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	@PostMapping("")
	public Teacher saveTeacher(@RequestBody Teacher teacher) {
		Teacher teacherSaved = teacherService.saveTeacher(teacher);
		return teacherSaved;
	}
	
	@GetMapping("/{id}")
	public Teacher getTeacherById(@PathVariable Long id) throws Exception {
		Teacher teacher = teacherService.getTeacherById(id);
		return teacher;
	}
	
	@GetMapping("/listAll")
	public List<Teacher> listAllTeachers(){
		List<Teacher> teachers = teacherService.listAllTeacher();
		return teachers;
	}
	
	@PostMapping("/addTeacher/{teacherId}/SubjectId/{subjectId}")
	public Teacher attachTeacherWithSubject(@PathVariable Long teacherId, 
			@PathVariable Long subjectId) throws Exception {
		Teacher savedTeacher = teacherService.addTeacherToSubject(teacherId, subjectId);
		return savedTeacher;
	}
	
	@DeleteMapping("/{teacherId}/deleteSubject/{subjectId}")
	public Teacher deleteSubjectForTeacher(@PathVariable Long teacherId , @PathVariable Long subjectId) throws Exception {
		Teacher teacher = teacherService.removeSubjectFromTeacher(teacherId, subjectId);
		return teacher;
	}
	
	@PostMapping("/classToTeacher/{teacherId}/class/{classId}")
	public Teacher addClassToTeacher(@PathVariable Long teacherId , @PathVariable Long classId) throws Exception{
		return teacherService.addClassToTeacher(teacherId, classId);
	}
	
	@DeleteMapping("/deleteClassToTeacher/{teacherId}/class/{classId}")
	public Teacher deleteClassToTeacher(@PathVariable Long teacherId , @PathVariable Long classId) throws Exception{
		return teacherService.deleteClassToTeacher(teacherId, classId);
	}
	
}
