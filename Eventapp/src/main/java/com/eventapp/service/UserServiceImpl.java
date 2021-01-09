package com.eventapp.service;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eventapp.dao.User;
import com.eventapp.repo.UserRepo;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	
	public UserServiceImpl(UserRepo userRepo) {
		this.userRepo = userRepo;
	}
	
	@Override
	public void addUser(User user) {
		userRepo.save(user);
	}
	@Override
	public User findByName(String name) {
		return userRepo.findByName(name);
	}
}


