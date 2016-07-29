package com.taqnihome.dao;

import java.util.List;

import com.taqnihome.domain.User;

public interface UserDataDao {

public String userSignup(User user);

public String userLogin(String password, String macAddress);

public User userAvailable(String mac_address);


	
}
