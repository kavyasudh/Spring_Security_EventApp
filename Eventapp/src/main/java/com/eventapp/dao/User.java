package com.eventapp.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_table1")
public class User {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String password;
	
	private String[]roles;// ADMIN, MGR, CLERK
	
	/*
	 * @Column(name="role")
	 * 
	 * @CollectionTable(name="appuser_roles")
	 * 
	 * @ElementCollection(fetch = FetchType.EAGER) 
	 * private List<String> roles=new ArrayList<>();
	 */

	public User() {}
	
	public User(String name, String password,
			String[] roles) {
		this.name = name;
		this.password=password;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String[] getRoles() {
		return roles;
	}

	public void setRoles(String[] roles) {
		this.roles = roles;
	}

	
}
