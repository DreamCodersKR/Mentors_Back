package com.dream.repository;

import com.dream.entity.Tb_User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Tb_User, String> {
	public Tb_User findByEmail(String email);
}
