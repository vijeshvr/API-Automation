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

public class Delete {
	static String URI;
	static String Resource;
	static String QPKey;
	static String QPValue;
	
	static Response response;
	static String placeId;

	@ParameterType(".*")
    public String dynamicParameter2(String value) {
        return value;}
	
	
	@Given("I have the following data for delete {dynamicParameter2}, Query Parameter {dynamicParameter2} and {dynamicParameter2}")
	public void i_have_the_following_data_for_delete_resource_query_parameter_key_and_qaclick123(String Resou, String Qkey, String Qvalue) {
		 Resource=Resou;
	     QPKey=Qkey;
	     QPValue=Qvalue;
	     placeId=Post.placeId;
	     URI=Post.URI;
	}
	@When("I send a delete request to the API")
	public void i_send_a_delete_request_to_the_api() {
		response = RestAssured
                .given()
                    .baseUri(URI)
                    .queryParam(QPKey, QPValue)
                    .queryParam("place_id", placeId)
                    .contentType(ContentType.JSON)
                .when()
                    .post(Resource)
                .then()
                    .extract().response();

       
        System.out.println(response.getBody().asString());

	}
	@Then("the delete response status code should be {int}")
	public void the_delete_response_status_code_should_be(Integer int1) {
		response.then().statusCode(int1);
	}
}
