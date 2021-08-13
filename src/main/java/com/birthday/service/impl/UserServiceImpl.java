package com.birthday.service.impl;

import com.birthday.model.User;
import com.birthday.model.UserRole;
import com.birthday.repo.RoleRepository;
import com.birthday.repo.UserRepository;
import com.birthday.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	//creating user

	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {

		User local=this.userRepository.findByUsername(user.getUsername());
		if(local !=null){
			System.out.println("User is already exits!!");
			throw new Exception("User is present!!");
		}else
		{
			//create user extracting roles from userroles
			for(UserRole ur:userRoles){
				roleRepository.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);//users are associated with all the roles
			local=this.userRepository.save(user);
		}

		return local;
	}
    //getting user by username
	@Override
	public User getUser(String username) {
		return this.userRepository.findByUsername(username);
	}

	@Override
	public void deleteUser(Long userId) {
		this.userRepository.deleteById(userId);
	}
}
