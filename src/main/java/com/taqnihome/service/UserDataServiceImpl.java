package com.taqnihome.service;

import java.util.List;

import org.hibernate.procedure.internal.Util.ResultClassesResolutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taqnihome.dao.UserDataDao;
import com.taqnihome.domain.Student;
import com.taqnihome.domain.Team;
import com.taqnihome.domain.User;


@Service
@Transactional
public class UserDataServiceImpl implements UserDataService {
	

@Autowired
private  UserDataDao userDataDao;
	
public String userSignup(User user){
	return userDataDao.userSignup(user);
}

public String userLogin(String password,String macAddress){
	return userDataDao.userLogin(password,macAddress);
}

public User userAvailable(String mac_address){
	return userDataDao.userAvailable(mac_address);
}
	



}
