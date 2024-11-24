package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Userendpointsusingproperties {

	static ResourceBundle getURL(){
		ResourceBundle routes=ResourceBundle.getBundle("Routes");      //load properties file // by default it will featch for the file name no need to give full path
	
	  return routes;
	}
	
	public static Response createUser(User payload)
	{
		
		
		String Post_URL	=getURL().getString("post_url");
		
		Response response = 
				given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(payload)
				.when()
					.post(Post_URL);
		return response;
	}

	public static Response readUser(String userName)
	{
		
		String Get_URL	=getURL().getString("get_url");
		Response response = 
				given()
					.pathParam("username", userName)
				.when()
					.get(Get_URL);
		return response;
	}

	public static Response updateUser(String userName, User payload)
	{
		
		
		String Update_Url	=getURL().getString("update_url");
		Response response = 
				given()
					.contentType(ContentType.
							JSON)
					.accept(ContentType.JSON)
					.pathParam("username", userName)
					.body(payload)
				.when()
					.put(Update_Url);
		return response;
	}

	public static Response deleteUser(String userName)
	{
		String Delete_URL	=getURL().getString("delete_url");
		
		Response response = 
				given()
					.pathParam("username", userName)
				.when()
					.delete(Delete_URL);
		return response;
	}
	

}
