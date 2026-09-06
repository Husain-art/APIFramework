package stepDefinations;

import static io.restassured.RestAssured.given;

import static org.junit.Assert.*;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuilt;
import resources.Utils;
//import static org.hamcrest.Matchers.*;
public class StepDefination extends Utils {

	RequestSpecification res;
	ResponseSpecification resspec= new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();;
	Response response;
	TestDataBuilt tDB = new TestDataBuilt();
	public static String placeId;
	@Given("Add place payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String Language, String Address) throws IOException {
		res = given().spec(requestSpecification()).body(tDB.addPlacePayload(name,Language,Address));
	}
	
	@When("User calls {string} with {string} http request")
	public void user_calls_with_http_request(String string, String method) {
		APIResources a = APIResources.valueOf(string);
		if(method.equalsIgnoreCase("Post"))
			response = res.when().post(a.getResources());
		else if(method.equalsIgnoreCase("Get"))
			response = res.when().get(a.getResources());
		else if(method.equalsIgnoreCase("Delete"))
			response = res.when().delete(a.getResources());
	}
	
	@Then("the API call get success with satus code {int}")
	public void the_api_call_get_success_with_satus_code(Integer int1) {
		assertEquals(response.getStatusCode(), 200);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String Expectedvalue) {
	    assertEquals(getJsonPath(response,keyValue),Expectedvalue);
	}
	
	@Then("verify created placeId maps to {string} using {string}")
	public void verify_created_place_id_maps_to_using(String expectedname, String string2) throws IOException {
//		APIResources ga = APIResources.valueOf(string2);
		placeId = getJsonPath(response, "place_id");
		res = given().spec(requestSpecification())
				.queryParam("place_id", placeId);
		user_calls_with_http_request(string2,"Get");
		String actualName = getJsonPath(response, "name");
		assertEquals(actualName, expectedname);
//			.when()
//				.get(ga.getResources())
//			.then()
//				.assertThat().body("name", equalTo(name));
	}
	
	@Given("Delete PlacePayload")
	public void delete_place_payload() throws IOException {
		res = given().spec(requestSpecification()).body(tDB.deletePlacePayLoad(placeId));
		
	}
	
}
