package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import static io.restassured.matcher.ResponseAwareMatcher.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class TestsExamples {
	
	@Test
	public void test_1(){
		
		Response response = get("https://reqres.in/api/users?page=2");
		
		System.out.println("The Status code is: " + response.getStatusCode());
		System.out.println("The Response time is: " + response.getTime());	
		System.out.println("The body of the get request is: " + response.getBody().asString());
		System.out.println("The Response Status Line is: " + response.getStatusLine());
		System.out.println("The Response Header is: " + response.getHeader("content-type"));
		
		int statusCode = response.getStatusCode();
		
		Assert.assertEquals(statusCode, 200 );
		
	}

	@Test
	public void test_2() {
		
		baseURI = "https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[1].id", equalTo(8)).
			log().all();
			
	}


	
}
