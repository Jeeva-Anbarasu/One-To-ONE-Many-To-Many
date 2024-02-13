package com.example.demo.service;

import com.example.demo.entity.Subject;

public interface SubjectService {
	
	public Subject saveSubject(Subject subject);
	
	public Subject getSubject(Long id) throws Exception;
}
