package practiceRestAssuredTC1;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class UpdateResource {
@Test

public void updateresource() {
	 Random ran = new Random();
     int randomNumber = ran.nextInt(500);

   JSONObject jobj = new JSONObject();
   jobj.put("createdBy", "nadeesh");
   jobj.put("projectName","Idea"+randomNumber);
   jobj.put("status","complted");
   jobj.put("teamSize",300);
   
   given()
   			.body(jobj)
   			.contentType(ContentType.JSON)
   .when()
   			.put("http://localhost:8084/projects/TY_PROJ_618")
   .then()
		.assertThat().statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
}
}
