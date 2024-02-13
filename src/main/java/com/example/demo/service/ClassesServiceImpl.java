package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Classes;
import com.example.demo.repository.ClassesRepository;

@Service
public class ClassesServiceImpl implements ClassesService {

	
	@Autowired
	private ClassesRepository classRepository;
	
	@Override
	public Classes saveClasses(Classes classes) {
		Classes  classesSaved = classRepository.save(classes);
		return classesSaved;
	}

	@Override
	public Classes deleteClassById(Long id) throws Exception{
		Classes classes = getClassById(id);
		classRepository.deleteById(id);
		return classes;
	}

	@Override
	public Classes editClass(Long id, Classes classes)throws Exception {
		Classes classesSaved = getClassById(id);
		classesSaved.setName(classes.getName());
		return classRepository.save(classesSaved);
	}

	@Override
	public Classes getClassById(Long id) throws Exception{
		Classes classes = classRepository.findById(id).orElseThrow(() -> new Exception("The class with given id is not available"));
		return classes;
	}

}
