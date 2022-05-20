package br.ufc.mdcc.DataModel;

public class ObservationSensor {
	private String id;
	private String avg;
	private String date;
	private String value;
	private String unit;
	private String nameObs;
	private String nameSensor;
	private String numberStation;


	public void formatData() {
		if(this.value==null) {
			this.value="0.0";
		}
	}
	public String getNumberStation() {
		return numberStation;
	}
	public void setNumberStation(String numberStation) {
		this.numberStation = numberStation;
	}
	public String getNameObs() {
		return nameObs;
	}
	public void setNameObs(String nameObs) {
		this.nameObs = nameObs;
	}
	public String getNameSensor() {
		return nameSensor;
	}
	public void setNameSensor(String nameSensor) {
		this.nameSensor = nameSensor;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAvg() {
		return avg;
	}
	public void setAvg(String avg) {
		this.avg = avg;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	
}
