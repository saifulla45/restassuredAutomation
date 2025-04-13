package com.api.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.endpoints.UserEndpoints;
import com.api.payload.User;
import com.api.utilities.ExcelDataProvider;

import io.restassured.response.Response;

public class DataDrivenTest {
	
	@Test(priority = 1,dataProvider = "userData",dataProviderClass = ExcelDataProvider.class)
	public void testCreateUser(String userId,String uname,String fname,String lname,String email,String pwd,String cellNum) {
		User userPayload = new User();
		userPayload.setId(Integer.parseInt(userId));
		userPayload.setUsername(uname);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(email);
		userPayload.setPassword(pwd);
		userPayload.setPhone(cellNum);
		Response res = UserEndpoints.createUser(userPayload);
		System.out.println("********* Create User Data log ********");
		res.then()
		.log()
		.all();
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority = 1,dataProvider = "username",dataProviderClass = ExcelDataProvider.class)
	public void testDeleteUser(String uname) {
		Response res = UserEndpoints.deleteUser(uname);
		System.out.println("$$$$$$$$ Delete User Data log $$$$$$$$");
		res.then()
		.log()
		.all();
		Assert.assertEquals(res.getStatusCode(), 200);
	}

}
