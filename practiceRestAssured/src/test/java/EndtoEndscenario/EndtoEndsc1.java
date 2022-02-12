package EndtoEndscenario;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class EndtoEndsc1 {
@Test

public void endtoend() {
	Random ran = new Random();
    int randomNumber = ran.nextInt(500);

  JSONObject jobj = new JSONObject();
  jobj.put("createdBy", "manohar");
  jobj.put("projectName","Idea"+randomNumber);
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
  
  String proId = "TY_PROJ_638";
 	given()
 			.pathParam("projectId", proId)
 	.when()
 			.delete("http://localhost:8084/projects/{projectId}")
 	.then()
 			.contentType(ContentType.JSON)
 			.statusCode(204)
 			.log().all();
 
}
}
