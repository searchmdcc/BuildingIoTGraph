package br.ufc.mdcc.DataModel;

import java.util.ArrayList;

public class MetadataSensor{
	private String address="";
	private String locationId, endpoint;
	private Coordinates coordinates;
	private ArrayList<Sensor> sensors= new ArrayList<Sensor>();

	public void formatData() {
		this.address=this.address.replace(" ","_");
		this.address=this.address.replace("ç","c");
		
		
	}
	public ArrayList<Sensor> getSensors() {
		return sensors;
	}
	public void setSensors(ArrayList<Sensor> sensors) {
		this.sensors = sensors;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public String getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}
	
	
	
	
	
	
	
}
