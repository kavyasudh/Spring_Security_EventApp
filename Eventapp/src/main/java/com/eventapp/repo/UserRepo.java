package com.eventapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventapp.dao.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
	public User findByName(String name);
}

