package com.birthday;

import com.birthday.model.Role;
import com.birthday.model.UserRole;
import com.birthday.repo.UserRepository;
import com.birthday.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.birthday.model.User;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class BirthdayserverApplication implements CommandLineRunner {
	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(BirthdayserverApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//
//		User user=new User();
//
//		user.setFirstName("Gaurav");
//		user.setLastName("Kumar");
//		user.setUsername("gaurav1234");
//		user.setEmail("abc@gmail.com");
//		user.setPassword("1234");
//		user.setProfile("default.png");
//		user.setBirthday("29/01/98");
//		user.setDateOfJoining("16/06/21");
//
//
//		Role role1=new Role();
//		role1.setRoleId(44L);
//		role1.setRoleName("ADMIN");
//
//		//setting userrole
//		Set<UserRole> userRoleSet=new HashSet<>();
//		UserRole userRole=new UserRole();
//		userRole.setRole(role1);
//		userRole.setUser(user);
//		userRoleSet.add(userRole);
//
//		User user1=this.userService.createUser(user,userRoleSet);
//		System.out.println(user1.getUsername());



	}

}
