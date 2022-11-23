package com.sourav.learningManagementSystem.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sourav.learningManagementSystem.model.Users;
import com.sourav.learningManagementSystem.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userReposetory;
	private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public Users addUser(Users user) {
		Optional<Users> optional = userReposetory.findById(user.getUserName());
		if(optional.isPresent()) {
			LOG.error("Username is already taken");
		}
		return userReposetory.saveAndFlush(user);
	}

}
