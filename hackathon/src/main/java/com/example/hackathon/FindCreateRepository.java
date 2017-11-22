package com.example.hackathon;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.hackathon.FindCreate;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
@Transactional
public interface FindCreateRepository extends JpaRepository<FindCreate, Long> {
	
	
	public FindCreate findBypan(Long pan);
	public List<FindCreate> findAll();

}