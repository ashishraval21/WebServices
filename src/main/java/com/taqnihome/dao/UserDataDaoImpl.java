package com.taqnihome.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.taqnihome.domain.Student;
import com.taqnihome.domain.Team;
import com.taqnihome.domain.User;

@Repository
@Transactional
public class UserDataDaoImpl implements UserDataDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public String userSignup(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(user);
		
		return sessionFactory.getCurrentSession().getIdentifier(user).toString();
	}

	public String userLogin(String password,String macAddress) {
		// TODO Auto-generated method stub
		
		User user = (User) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.and(Restrictions.eq("password", password),Restrictions.eq("macAddress", macAddress))).list().get(0);
		if(user!=null){
			return user.getUserName();
		}
		
		return "";
	}

	public User userAvailable(String mac_address) {
		// TODO Auto-generated method stub
		return (User) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("macAddress", mac_address)).list().get(0);
	}
	
	
	
}
