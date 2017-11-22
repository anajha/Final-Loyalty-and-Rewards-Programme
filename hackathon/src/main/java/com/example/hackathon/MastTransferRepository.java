package com.example.hackathon;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.hackathon.MastTransfer;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
@Transactional
public interface MastTransferRepository extends JpaRepository<MastTransfer, Long> {
	
	
	public MastTransfer findBypan1(Long pan1);
	public List<MastTransfer> findAll();

}
