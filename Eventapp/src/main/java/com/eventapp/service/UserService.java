package com.eventapp.service;

import com.eventapp.dao.User;

public interface UserService {
	public void addUser(User user);
	public User findByName(String name);
}