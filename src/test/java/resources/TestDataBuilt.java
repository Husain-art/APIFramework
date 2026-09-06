package resources;

import java.util.ArrayList;
import java.util.List;

import Pojo.AddPlace;
import Pojo.Location;

public class TestDataBuilt {

	public AddPlace addPlacePayload(String name, String language, String address) {
		AddPlace ad = new AddPlace();
		ad.setAccuracy("50");
		ad.setAddress(address);
		ad.setLanguage(language);
		ad.setName(name);
		ad.setPhone_number("(+91) 983 893 3937");
		ad.setWebsite("http://google.com");
		Location l = new Location();
		l.setLat("-38.383494");
		l.setLng("33.427362");
		ad.setLocation(l);
		List<String> types = new ArrayList<String>();
		types.add("shoe park");
		types.add("shop");
		ad.setTypes(types);
		return ad;
	}
	public String deletePlacePayLoad(String placeId) {
		String dpp = "{\r\n"
				+ "    \"place_id\":\""+ placeId +"\"\r\n"
				+ "}";
		return dpp;
	}
}
