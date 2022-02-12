package practiceRestAssuredTC1;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import org.hamcrest.Matchers;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class AddSingleprojectTest {
@Test

public void addsingle() {
	//Step 1:  create data
	JSONObject jobj =new JSONObject();//json simple dependency
	jobj.put("createdBy","vishnu");
	jobj.put("createdOn", "11/02/2022");
	//jobj.put("projectId", "string");
	jobj.put("projectName", "vishnu_pro-3");
	jobj.put("status", "Created");
	jobj.put("teamSize", 10);
	
	given()
	.body(jobj)
	.contentType(ContentType.JSON)
	.when()
	.post("http://localhost:8084/addProject")
	.then()
	.assertThat().statusCode(201).time(Matchers.lessThan(500L), TimeUnit.MILLISECONDS)
	.contentType(ContentType.JSON)
	.log().all();
	
}
}
