package com.devsuperior.dsmovie.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmovie.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String email);
}
