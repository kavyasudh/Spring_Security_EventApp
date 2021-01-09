package com.eventapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.eventapp.dao.User;


@Service
public class DetailService implements UserDetailsService{
	
	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String name)throws UsernameNotFoundException {
		User user=userService.findByName(name);
		System.out.println(user);
		
		if(user==null)
			throw new UsernameNotFoundException("user with username:"+name+" is not found");
		else
		//convert to spring security user
		return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), 
				AuthorityUtils.createAuthorityList(user.getRoles()));
	}

}

