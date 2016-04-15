package com.web2h.nan.core.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web2h.nan.model.entity.user.User;
import com.web2h.nan.model.entity.user.UserStatus;
import com.web2h.nan.persitence.dao.user.UserDao;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User getUser() {
		User user = userDao.read(1l);
		user.setName("IRvin");
		user.setPassword("123456");
		user.setStatus(UserStatus.ACTIVE);
		userDao.update(user);
		return user;
	}
}
