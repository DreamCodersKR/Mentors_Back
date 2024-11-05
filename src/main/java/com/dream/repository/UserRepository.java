package com.dream.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dream.entity.Tb_User;

@Repository
public interface UserRepository extends JpaRepository<Tb_User,Integer>{
	
public Tb_User findByEmail(String email);
	

	
}
