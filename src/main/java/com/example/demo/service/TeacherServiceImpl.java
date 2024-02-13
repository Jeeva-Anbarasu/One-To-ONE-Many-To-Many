package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Classes;
import com.example.demo.entity.Subject;
import com.example.demo.entity.Teacher;
import com.example.demo.repository.SubjectRepository;
import com.example.demo.repository.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService {

	
	@Autowired
	private TeacherRepository teacherRepo;
	
	@Autowired
	private SubjectRepository subjectRepo;
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private ClassesService classService;
	
	@Override
	public Teacher saveTeacher(Teacher teacher) {
		Teacher teacherSaved = teacherRepo.save(teacher);
		return teacherSaved;
	}

	@Override
	public Teacher getTeacherById(Long id) throws Exception {
		Teacher teacher = teacherRepo.findById(id).orElseThrow(() -> new Exception("The teacher with given id is not available"));
		return teacher;
	}

	@Override
	public Teacher deleteTeacher(Long id) throws Exception {
		Teacher teacherSaved = getTeacherById(id);
		teacherRepo.deleteById(id);
		return teacherSaved;
	}

	@Override
	public Teacher editTeacher(Long id, Teacher teacher) throws Exception {
		Teacher teacherSaved = getTeacherById(id);
		teacherSaved.setName(teacher.getName());
		if(teacher.getSubject().getId() == null) {
			return teacherRepo.save(teacherSaved);
		}else {
			Subject subject = subjectRepo.findById(teacher.getSubject().getId()).orElseThrow(() -> new Exception("City id is not found"));
			subject.setSubjectName(teacher.getSubject().getSubjectName());
			teacherSaved.setSubject(subject);
			return teacherSaved;
		}
	}

	@Override
	public Teacher addTeacherToSubject(Long teacherId, Long subjectId) throws Exception {
		Teacher teacher = teacherRepo.findById(teacherId).get();
		if(teacher.getSubject() != null) {
			throw new Exception("The teacher is already attached to the subject");
		}
		Subject subject = subjectService.getSubject(subjectId);
		teacher.setSubject(subject);
		return saveTeacher(teacher);
	}

	@Override
	public List<Teacher> listAllTeacher() {
		List<Teacher> teacher = teacherRepo.findAll();
		return teacher;
	}

	@Override
	public Teacher removeSubjectFromTeacher(Long teacherId, Long subjectId) throws Exception {
		Teacher teacher = getTeacherById(teacherId);
		Subject subject = subjectService.getSubject(subjectId);
		
		if(teacher.getSubject().getId() != subjectId) {
			throw new Exception("The given subject id doesn't belongs to teacherId");
		}else {
			teacher.setSubject(null);
			teacher.setClasses(null);
			return teacherRepo.save(teacher);
		}
	}

	@Override
	public Teacher addClassToTeacher(Long teacherId, Long classId) throws Exception {
		Teacher teacher =  getTeacherById(teacherId);
		Classes classes = classService.getClassById(classId);
		if(teacher.getClasses().contains(classes)) {
			throw new Exception("The teacher is already mapped to the give class");
		}
		teacher.addClass(classes);
		return teacherRepo.save(teacher);
	}

	@Override
	public Teacher deleteClassToTeacher(Long teacherId, Long classId) throws Exception {
		Teacher teacher = this.getTeacherById(teacherId);
		Classes classes = classService.getClassById(classId);
		teacher.removeClass(classes);
		return teacher;
	}

}
