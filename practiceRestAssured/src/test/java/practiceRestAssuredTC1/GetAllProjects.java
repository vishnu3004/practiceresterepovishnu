package practiceRestAssuredTC1;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetAllProjects {
@Test

public void getallproject() {
	when()
	.get("http://localhost:8084/projects/TY_PROJ_818")
	
	.then()
	.assertThat().statusCode(200)
	.contentType(ContentType.JSON)
	.log().all();
}
}
