package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Teacher;

public interface TeacherService {
	
	public Teacher saveTeacher(Teacher teacher);
	
	public Teacher getTeacherById(Long id) throws Exception;
	
	public List<Teacher> listAllTeacher();
	
	public Teacher deleteTeacher(Long id) throws Exception;
	
	public Teacher editTeacher(Long id , Teacher teacher) throws Exception;
	
	public Teacher addTeacherToSubject(Long teacherId , Long subjectId) throws Exception;
	
	public Teacher removeSubjectFromTeacher(Long teacherId , Long subjectId) throws Exception;
	
	public Teacher addClassToTeacher(Long teacherId , Long classId) throws Exception;

	public Teacher deleteClassToTeacher(Long teacherId , Long classId) throws Exception;
}