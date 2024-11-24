package api.endpoints;

/* 
Swagger URI --> https://petstore.swagger.io

Create user(Post) : https://petstore.swagger.io/v2/user
Get user (Get): https://petstore.swagger.io/v2/user/{username}
Update user (Put) : https://petstore.swagger.io/v2/user/{username}
Delete user (Delete) : https://petstore.swagger.io/v2/user/{username}

*/
//https://petstore.swagger.io/#/user/createUsersWithListInput

	//https://petstore.swagger.io/#/user/getUserByName
		
		
public class Routes {
	
public static String base_url  ="https://petstore.swagger.io/v2";
 	
 	//User Model
    public static String post_url  = base_url+"/user";
    public static String get_url=base_url+"/user/{username}";
    public static String update_url=base_url+"/user/{username}";
    public static String delete_url=base_url+"/user/{username}";

   //strore module
	//Here you will create store module urls
	
	//pet module
		//Here you will create pet module urls

}




