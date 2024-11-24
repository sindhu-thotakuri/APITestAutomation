package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.Userendpoints;
import api.payload.User;
import io.restassured.response.Response;
import junit.framework.Assert;

public class Usertest {
	
	Faker faker;
	User userpayload; // we have pass faker data to User class so created object for that
	public Logger logger; //Logger is class to generate the logs
	//we can create debug logs , dev will understand debug logs , in lo4j2 xml file add roolt level as debug <Root level="Debug">
	// we can use debug.info("debugging...")
	@Test(priority=1)
	public void setup() {
		
		
		
		faker = new Faker();
		userpayload= new User();
		
		userpayload.setId(faker.idNumber().hashCode()); //hash code do not repeat values(for Unique values)
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5, 10));
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		
		
		logger=LogManager.getLogger(this.getClass()); //LogManager is predefined class , this.getClass  is because same class name will be displayed in log file
		
	}

	@Test(priority=2)
	public void testPostUser() {
		
		logger.info("***********creating user********************");
		Response response=Userendpoints.createUser(userpayload); // what payload we have generated above we have to pass that varoble
		
		
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*************user is created ****************");
	}
	@Test(priority=3)
	public void testGetUser() {
	logger.info("***********Reading user info ********************");
	Response response=	Userendpoints.readUser(this.userpayload.getUsername());// object.calling getuser name
	response.then().log().all();
	Assert.assertEquals(response.getStatusCode(), 200);
	logger.info("*********** user info is displayed ********************");
	}
	
	@Test(priority=4)
	public void testUpdateuser() {
		
		//first updating the data using payload
		
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		
		logger.info("***********Updating user ********************");
		Response response =Userendpoints.updateUser(this.userpayload.getUsername(),userpayload);// two params username, payload
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("*********** User is updated ********************");
		
		
		//checking data after update // same retrive data after update use read user
		Response responseafterupdate=Userendpoints.readUser(this.userpayload.getUsername());// object.calling getuser name
		response.then().log().all();
		Assert.assertEquals(responseafterupdate.getStatusCode(), 200);

	
	}
	@Test(priority=5)
	public void  testDeleteUser() {
		
		logger.info("***********Deleting user ********************");
		Response response= Userendpoints.deleteUser(this.userpayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*********** User is deleted ********************");
	}
	
	
	
	
}
