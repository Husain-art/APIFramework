package cucumber.option;

import java.io.IOException;

import io.cucumber.java.Before;
import stepDefinations.StepDefination;

public class Hooks {
	
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException {
		StepDefination sd = new StepDefination();
		if(StepDefination.placeId==null) {
			sd.add_place_payload_with("FoodZone", "Spanish", "NewYork");
			sd.user_calls_with_http_request("addplaceApi", "post");
			sd.verify_created_place_id_maps_to_using("FoodZone", "GetPlaceAPI");
		}

	}
}
