package com.ads.orm.Spring_Orm;

import com.ads.orm.Spring_Orm.entity.User;
import com.ads.orm.Spring_Orm.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringOrmApplication implements CommandLineRunner {
 Logger logger = LoggerFactory.getLogger(SpringOrmApplication.class);
	@Autowired
	private UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(SpringOrmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setAge(25);
		user.setCity("delhi");
		user.setName("Amri");
		User userSaved = userService.saveUser(user);
		System.out.println(userSaved);

//		//Get Single User
//		User user = userService.getSingleUser(3);
//		logger.info("User found {}", user);
//
//		//Get All User
//		List<User> user= userService.getAllUser();
//		logger.info("User get {}",user);
//
//		//Update users
//		User user = new User();
//		user.setCity("Azamgarh");
//		user.setAge(28);
//		user.setName("Suraj");
//		User userUpdate = userService.updateUser(user,1);
//		logger.info("Updated user {}",userUpdate);
//
//		//Delete User
//		userService.deleteUser(2);
	}
}
