package com.api.testcases;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import com.api.endpoints.UserEndpoints;
import com.api.payload.User;
import com.github.javafaker.Faker;

import io.restassured.response.Response;

public class UserTest {
	
	Faker faker;
	User userPayload;
	
	public static Logger logger;
	
	@BeforeClass
	public void generateTestData() {
		faker = new Faker();
		userPayload = new User();
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		logger = LogManager.getLogger("com.restassured.apiautomation");
	}
	
	@Test(priority = 1)
	public void testCreateUser() {
		logger.info("Create user Test is starting");
		Response res = UserEndpoints.createUser(userPayload);
		System.out.println("********* Create User Data log ********");
		res.then()
		.log()
		.all();
		Assert.assertEquals(res.getStatusCode(), 200);
		logger.info("Successfully completed Create User Test");
	}
	
	@Test(priority = 2)
	public void testGetUser() {
		Response res = UserEndpoints.getUser(this.userPayload.getUsername());
		System.out.println("@@@@@@@@ Get User Data log @@@@@@@@");
		res.then()
		.log()
		.all();
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority = 3)
	public void testUpdateUser() {
		userPayload.setFirstName(faker.name().firstName());
		Response res = UserEndpoints.updateUser(this.userPayload.getUsername(), userPayload);
		System.out.println("++++++++ Update User Data log ++++++++");
		res.then()
		.log()
		.all();
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority = 4)
	public void testDeleteUser() {
		Response res = UserEndpoints.deleteUser(this.userPayload.getUsername());
		System.out.println("$$$$$$$$ Delete User Data log $$$$$$$$");
		res.then()
		.log()
		.all();
		Assert.assertEquals(res.getStatusCode(), 200);
	}

}
