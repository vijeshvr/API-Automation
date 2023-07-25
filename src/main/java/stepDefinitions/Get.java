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
import junit.framework.Assert;

public class Get {
	
	static String URI;
	static String Resource;
	static String QPKey;
	static String QPValue;
	static String ExAddress;
	static String ActAddress;
	static Response response;
	static String placeId;
	
	static String repAsString;
	
	@ParameterType(".*")
    public String dynamicParameter1(String value) {
        return value;}
	
	

	@Given("I have the following data for get {dynamicParameter1}, Query Parameter {dynamicParameter1} and {dynamicParameter1} and extracted place id")
	public void i_have_the_following_data_for_get_and_extracted_place_id(String Resou, String Qkey, String Qvalue) {
		 Resource=Resou;
	     QPKey=Qkey;
	     QPValue=Qvalue;
	     placeId= Post.placeId;
	     URI=Post.URI;
	     
	}
	@When("I send a get request to the API")
	public void i_send_a_get_request_to_the_api() {
		response = RestAssured
                .given()
                    .baseUri(URI)
                    .queryParam(QPKey, QPValue)
                    .queryParam("place_id", placeId)
                    .contentType(ContentType.JSON)
                .when()
                    .get(Resource)
                .then()
                    .extract().response();


	}
	@Then("the get response status code should be {int}")
	public void the_get_response_status_code_should_be(Integer int1) {
		response.then().statusCode(int1);
	}
	@Then("Validate the address from the response")
	public void validate_the_address_from_the_response() {
	    ExAddress=Post.Address;
	    
	    repAsString=response.getBody().asString();
        System.out.println(repAsString);
	    
	    JsonPath js=new JsonPath(repAsString);
	    ActAddress=js.getString("address");
	    
	    Assert.assertEquals("The address is validated ", ExAddress, ActAddress);
	    
	}

}
