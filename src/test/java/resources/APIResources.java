package resources;

public enum APIResources {
	
	addplaceApi("maps/api/place/add/json"),
	GetPlaceAPI("/maps/api/place/get/json"),
	deleteplaceApi("maps/api/place/delete/json");
	
	private String resource;
	
	APIResources(String resource){
		this.resource=resource;
	}
	
	public String getResources() {
		return resource;
	}

}
