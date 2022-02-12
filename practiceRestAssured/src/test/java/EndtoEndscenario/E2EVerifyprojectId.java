package EndtoEndscenario;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;
import java.util.Random;

public class E2EVerifyprojectId {
@Test
public void e2everifyproid() {
	 Random ran = new Random();
     int randomNumber = ran.nextInt(500);
    
     JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "nadeesh");
		jobj.put("projectName","APTYSS_"+ randomNumber);
		jobj.put("status","created");
		jobj.put("teamSize",800);
		
		given()
				.body(jobj)
				.contentType(ContentType.JSON)
				
		.when()
		 		.post("http://localhost:8084/addProject")
		.then()
				.assertThat().statusCode(201)
				.contentType(ContentType.JSON)
				.log().all();
		
		String expectedprojectId = "TY_PROJ_645";
		Response response = when()
		   .get("http://localhost:8084/projects");
		List<String> projectId = response.jsonPath().get("projectId");
		boolean flag = false;
		for(String pname:projectId) {
			try {
				if (pname.equals(expectedprojectId)) {
					flag=true;
					
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		response.then()
		.assertThat()
		.contentType(ContentType.JSON).and().statusCode(200)
		.log().all();
		Assert.assertEquals(flag, true);

		
		
		
		
}
}
