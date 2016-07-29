package com.taqnihome.service;

import java.util.List;

import com.taqnihome.domain.Student;
import com.taqnihome.domain.Team;
import com.taqnihome.domain.User;

public interface UserDataService {
	
	public String userSignup(User user);

	public String userLogin(String password,String macAddress);

	public User userAvailable(String mac_address);
		

}
