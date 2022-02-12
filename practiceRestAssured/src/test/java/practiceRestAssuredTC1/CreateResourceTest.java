package practiceRestAssuredTC1;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateResourceTest {
@Test
public void createresource() {
	         Random ran = new Random();
	        int randomNumber = ran.nextInt(500);
	
	      JSONObject jobj = new JSONObject();
	      jobj.put("createdBy", "vishnu");
	      jobj.put("projectName","Airtel"+randomNumber);
	      jobj.put("status","created");
	      jobj.put("teamSize",200);
	      
	      given()
	      			.body(jobj)
	      			.contentType(ContentType.JSON)
	      .when()
	      			.post("http://localhost:8084/addProject")
	      .then()
			.assertThat().statusCode(201)
			.contentType(ContentType.JSON)
			.log().all();
}
}
