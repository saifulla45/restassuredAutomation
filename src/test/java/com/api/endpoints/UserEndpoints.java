package com.api.endpoints;

import java.util.ResourceBundle;

import com.api.payload.User;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints {
	
	public static ResourceBundle getUrl() {
		return ResourceBundle.getBundle("Routes");
	}
	
	public static Response createUser(User payload) {
		return RestAssured.given()
				.log()
				.all()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(payload)
				.when()
				//.post(Routes.post_url);
				.post(getUrl().getString("post_url"));
	}
	
	public static Response getUser(String userName) {
		return RestAssured.given()
				.log()
				.all()
				.accept(ContentType.JSON)
				.pathParam("username", userName)
				.when()
				//.get(Routes.get_url);
				.get(getUrl().getString("get_url"));
	}
	
	public static Response updateUser(String userName,User payload) {
		return RestAssured.given()
				.log()
				.all()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.pathParam("username", userName)
				.body(payload)
				.when()
				//.put(Routes.put_url);
				.put(getUrl().getString("put_url"));
	}
	
	public static Response deleteUser(String userName) {
		return RestAssured.given()
				.log()
				.all()
				.accept(ContentType.JSON)
				.pathParam("username", userName)
				.when()
				//.delete(Routes.delete_url); 
				.delete(getUrl().getString("delete_url"));
	}
}
