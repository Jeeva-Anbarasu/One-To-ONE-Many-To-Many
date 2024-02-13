package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Subject;
import com.example.demo.repository.SubjectRepository;

@Service
public class SubjectServiceImpl implements SubjectService {

	
	@Autowired
	private SubjectRepository subjectRepo;
	
	@Override
	public Subject saveSubject(Subject subject) {
		Subject subjectSaved = subjectRepo.save(subject);
		return subject;
	}

	@Override
	public Subject getSubject(Long id) throws Exception {
		Subject subject = subjectRepo.findById(id).orElseThrow(() -> new Exception("given id is not found")); 
		return subject;
	}

}
