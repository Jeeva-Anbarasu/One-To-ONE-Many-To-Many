package com.example.demo.service;

import com.example.demo.entity.Classes;

public interface ClassesService {

	public Classes saveClasses(Classes classes);
	
	public Classes deleteClassById(Long id) throws Exception;
	
	public Classes editClass(Long id , Classes classes)throws Exception;
	
	public Classes getClassById(Long id) throws Exception;
	
}
