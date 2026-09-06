Feature: Validating place API

@AddPlace @Regression
Scenario Outline: verifying is place is successfully added using addplaceAPI
Given Add place payload with "<name>" "<Language>" "<Address>"
When User calls "addplaceApi" with "post" http request
Then the API call get success with satus code 200
And "status" in response body is "OK"
And verify created placeId maps to "<name>" using "GetPlaceAPI"
Examples:
	|name	|Language	|Address|
	|Green Street| eng	|America|
	|Yellow Street|	French|NewYork|

@DeletePlace @Regression	
Scenario: Verifying if delete place functionality is working or not
Given Delete PlacePayload
When User calls "deleteplaceApi" with "Delete" http request
Then the API call get success with satus code 200
And "status" in response body is "OK"	