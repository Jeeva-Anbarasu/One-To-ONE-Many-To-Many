package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Classes;

public interface ClassesRepository extends JpaRepository<Classes , Long> {

}
