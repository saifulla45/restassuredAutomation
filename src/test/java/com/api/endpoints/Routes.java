package com.api.endpoints;

public class Routes {
	
	public static final String BASE_URI = "https://petstore.swagger.io/v2";
	
	public static String post_url = BASE_URI+"/user";
	public static String get_url = BASE_URI+"/user/{username}";
	public static String put_url = BASE_URI+"/user/{username}";
	public static String delete_url = BASE_URI+"/user/{username}";
}
