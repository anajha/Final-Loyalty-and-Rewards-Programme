package com.example.hackathon;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.hackathon.CardMerchLog;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
@Transactional
public interface CardMerchLogRepository extends JpaRepository<CardMerchLog, Long> {
	
	
	public CardMerchLog findBypan(Long pan1);
	public List<CardMerchLog> findAll();

}
