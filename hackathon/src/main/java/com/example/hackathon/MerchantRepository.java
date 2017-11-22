package com.example.hackathon;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.hackathon.Merchant;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
@Transactional
public interface MerchantRepository extends JpaRepository<Merchant, Long> {
	
	
	public Merchant findBymerchid(Long merchid);
	public List<Merchant> findAll();

}
