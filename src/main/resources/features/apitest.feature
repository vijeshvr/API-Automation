Feature: Google Map API


 Scenario Outline: Add a new location to the Google Map API

 Given The API endpoint is <URI>

 And I have the following data for post <Resource>, Query Parameter <key> and <Value> and <Address> to be added

 When I send a post request to the API

 Then the post response status code should be <Statuscode>  
 
 And Get the placeId from the response

 Examples:

 | URI | Resource | key | Value | Address | Statuscode |
 | https://rahulshettyacademy.com | maps/api/place/add/json | key | qaclick123 | Chennai | 200 |
 
 
 Scenario Outline: Validate the new address

 Given The API endpoint is <URI>

 And I have the following data for get <Resource>, Query Parameter <key> and <Value> and extracted place id
 
 When I send a get request to the API

 Then the get response status code should be <Statuscode>

 And Validate the address from the response

 Examples:

 | URI | Resource | key | Value | Statuscode |
 | https://rahulshettyacademy.com | maps/api/place/get/json | key | qaclick123 | 200 |



 Scenario Outline: Delete the place from the Map

 Given The API endpoint is <URI>
 And I have the following data for delete <Resource>, Query Parameter <key> and <Value>
 When I send a delete request to the API
 Then the delete response status code should be <Statuscode>


Examples:

 | URI | Resource| key | Value | Statuscode |
 | https://rahulshettyacademy.com | maps/api/place/delete/json | key | qaclick123 | 200 |

