package practiceonusersenarios;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class UserisnotCreated {
@Test
public void usernotcreated() {
	 Random ran = new Random();
     int randomNumber = ran.nextInt(500);
	 JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "");
		jobj.put("projectName","TYSS_"+ randomNumber);
		jobj.put("status","created");
		jobj.put("teamSize",300);
		
		given()
				.body(jobj)
				.contentType(ContentType.JSON)
				
		.when()
		 		.post("http://localhost:8084/addProject")
		.then()
				.assertThat().statusCode(201)
				.contentType(ContentType.JSON)
				.log().all();
		
		String expectedcreatedBy = "vishnu";
     Response response = when()
     .get("http://localhost:8084/projects");
String actualcreatedBy = response.jsonPath().get("[0].createdBy");
response.then()
              .assertThat()
              .contentType(ContentType.JSON).and().statusCode(200)
              .log().all();
Assert.assertEquals(expectedcreatedBy,actualcreatedBy);
}
}
