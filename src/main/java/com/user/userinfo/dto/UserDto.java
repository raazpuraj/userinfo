package com.user.userinfo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String userName;

    private String emailID;
    private String password;

    private String address;

	public String getMiddleName() {
		return address;
	}
	public void setMiddleName(String middleName) {
		this.address = middleName;
	}
	public String getFirstName() {
		return userName;
	}
	public void setFirstName(String firstName) {
		this.userName = firstName;
	}


	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}


	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
