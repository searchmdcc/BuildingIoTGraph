package br.ufc.mdcc.adapters;

import java.util.Iterator;

import com.google.gson.Gson;

import br.ufc.mdcc.AdapterInterfaces.SemanticAnnotation;
import br.ufc.mdcc.DataModel.ObservationSensor;

import br.ufc.mdcc.OntologyModel.OntologyInstances;

public class AdapterObservationSensor implements SemanticAnnotation{
	private ObservationSensor obs;
	private ObservationSensor[] obsList;
	private String observ;
	private String sensor;
	private OntologyInstances ont;

	public AdapterObservationSensor(ObservationSensor obs) {
		super();
		this.obs = obs;
		this.observ="observation_"+obs.getId()+"_"+obs.getDate();
		this.sensor="Sensor_"+obs.getId();
		obs.formatData();
		this.ont=new OntologyInstances();
		
	}
	public AdapterObservationSensor(ObservationSensor[] obs) {
		super();
		this.obsList = obs;
		this.ont=new OntologyInstances();
		
	}
	public static ObservationSensor dataTransform(String URL){
		Gson gson = new Gson();
		ObservationSensor data = gson.fromJson(URL, ObservationSensor.class);
		return data;
		
	}
	public static ObservationSensor[] dataTransformList(String URL){
		Gson gson = new Gson();
		ObservationSensor[] data = gson.fromJson(URL, ObservationSensor[].class);
		return data;
		
	}
	
	@Override
	public String annotateDate() {
		ont.createClass("http://example.com/","http://www.w3.org/ns/sosa/", observ, "Observation");
		ont.createClass("http://example.com/", "http://www.w3.org/ns/sosa/", this.sensor, "Sensor");
		ont.createIndividuoLiteral("http://example.com/", "http://www.w3.org/ns/sosa/", observ, "hasSimpleResult", obs.getValue());
		ont.createIndividuoLiteral("http://example.com/", "http://www.w3.org/ns/sosa/", observ, "hasResultTime", obs.getDate());
		ont.createIndividualObject("http://example.com/","http://www.w3.org/ns/sosa/", "http://example.com/", observ, "madeBySensor", this.sensor);

		
		return ont.returnSemanticData();
	}
	@Override
	public String annotateListDate() {
		for(ObservationSensor obs:obsList) {
			obs.formatData();
			this.observ="observation_"+obs.getId()+"_"+obs.getDate();
			this.sensor="Sensor_"+obs.getId();
			ont.createClass("http://example.com/","http://www.w3.org/ns/sosa/", observ, "Observation");
			ont.createClass("http://example.com/", "http://www.w3.org/ns/ssn/", sensor, "Sensor");
			ont.createIndividuoLiteral("http://example.com/", "http://www.w3.org/ns/sosa/", observ, "hasSimpleResult", obs.getValue());
			ont.createIndividuoLiteral("http://example.com/", "http://www.w3.org/ns/sosa/", observ, "hasResultTime", obs.getDate());
			ont.createIndividualObject("http://example.com/","http://www.w3.org/ns/sosa/", "http://example.com/", observ, "madeBySensor", this.sensor);

		}
		return ont.returnSemanticData();
	}


}
