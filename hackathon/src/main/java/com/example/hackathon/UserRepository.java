package com.example.hackathon;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.hackathon.Transaction;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
@Transactional
public interface UserRepository extends JpaRepository<Transaction, Long> {
	
	
	public Transaction findBypan(Long pan);
	public List<Transaction> findAll();

}