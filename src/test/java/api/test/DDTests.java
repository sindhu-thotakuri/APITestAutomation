package api.test;

import org.testng.annotations.Test;

import api.endpoints.Userendpoints;
import api.payload.User;
import api.utilities.Dataprovider;
import io.restassured.response.Response;
import junit.framework.Assert;

public class DDTests {
	
	@Test(priority=1, dataProvider="Data", dataProviderClass=Dataprovider.class )
	public void testPostUser(String userID, String userName, String fname, String lname, String userMail, String pwd, String ph)
	//Same order how we added in in excel 
	{
		
		User userpayload=new User(); // crete object
		userpayload.setId(Integer.parseInt(userID));
		userpayload.setUsername(userName);
		userpayload.setFirstName(fname);
		userpayload.setLastName(lname);
		userpayload.setEmail(userMail);
		userpayload.setPassword(pwd);
		userpayload.setPhone(ph);
		
		Response response= Userendpoints.createUser(userpayload);
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority=2, dataProvider="UserNames" , dataProviderClass=Dataprovider.class)
	public void testDeleteUser(String userName) {
		
		Response response=Userendpoints.deleteUser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
