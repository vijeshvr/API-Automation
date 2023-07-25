package stepDefinitions;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import jsBody.AddPlaceBody;

public class Post {
	
	static String URI;
	static String Resource;
	static String QPKey;
	static String QPValue;
	static String Address;
	static String JSBody1;
	
	static Response response;
	static String placeId;

	@ParameterType(".*")
    public String dynamicParameter(String value) {
        return value;}

	@Given("The API endpoint is {dynamicParameter}")
	public static void the_api_endpoint_is_(String uri) {
	     URI= uri;
	    
	}
	@Given("I have the following data for post {dynamicParameter}, Query Parameter {dynamicParameter} and {dynamicParameter} and {dynamicParameter} to be added")
	public static void i_have_the_following_data(String Resou, String Qkey, String Qvalue, String add) {
	     Resource=Resou;
	     QPKey=Qkey;
	     QPValue=Qvalue;
	     Address=add;
	    
	    JSBody1 = AddPlaceBody.AddJsBody(Address);
	    
	    
	}
	@When("I send a post request to the API")
	public static void i_send_a_post_request_to_the_api() {
		 response = RestAssured
                .given()
                    .baseUri(URI)
                    .queryParam(QPKey, QPValue)
                    .contentType(ContentType.JSON)
                    .body(JSBody1)
                .when()
                    .post(Resource)
                .then()
                    .extract().response();

       
        System.out.println(response.getBody().asString());
	}
	@Then("the post response status code should be {int}")
	public static void the_post_response_status_code_should_be(Integer int1) {
		 response.then().statusCode(int1);
	}
	@Then("Get the placeId from the response")
	public static void get_the_place_id_from_the_response() {
		 String responseBody = response.getBody().asString();
		
	    JsonPath js= new JsonPath(responseBody);
	    placeId= js.getString("place_id");
	    
	    System.out.println("The place ID is of "+Address+" is "+ placeId);
	    
	}
	
}
