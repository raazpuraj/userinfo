package com.user.userinfo.entity;
import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "UserData")
@Data
public class UserData {


	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "userName")
	private String userName;

	@Column(name = "address")
	private String address;



}

	
