package com.example.hackathon;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.hackathon.MastTran;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
@Transactional
public interface MastTranRepository extends JpaRepository<MastTran, Long> {
	
	
	public MastTran findBypan(Long pan);
	public MastTran findBymerchid(Long merchid);
	public List<MastTran> findAll();

}