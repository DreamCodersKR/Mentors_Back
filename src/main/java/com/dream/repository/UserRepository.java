package com.dream.repository;

import com.dream.entity.Tb_User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Tb_User, String> {
//	public Tb_User findByEmail(String email);
	Optional<Tb_User> findByEmail(String email);  // JPA에선 Optional로 처리해야 null값을 직접처리하지 않아도됨
}
