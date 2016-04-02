package com.web2h.nan.persitence.dao.user;

import org.springframework.stereotype.Repository;

import com.web2h.nan.model.entity.user.User;
import com.web2h.nan.persitence.dao.generic.GenericDaoImpl;

/**
 * User DAO implementation class.
 * 
 * @author Web2h
 */
@Repository("userDao")
public class UserDaoImpl extends GenericDaoImpl<User, Long> implements UserDao {

}