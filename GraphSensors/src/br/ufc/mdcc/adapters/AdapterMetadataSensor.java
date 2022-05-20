package br.ufc.mdcc.adapters;

import com.google.gson.Gson;

import br.ufc.mdcc.AdapterInterfaces.SemanticAnnotation;
import br.ufc.mdcc.DataModel.MetadataSensor;
import br.ufc.mdcc.DataModel.ObservationSensor;
import br.ufc.mdcc.DataModel.Sensor;
import br.ufc.mdcc.OntologyModel.OntologyInstances;

public class AdapterMetadataSensor implements SemanticAnnotation {
	private MetadataSensor metadataUni;
	private MetadataSensor[] metadataList;
	private OntologyInstances ont;
	private String nameSensor;
	private String service;
	private String station;
	private String point;
	private String address;
	private String station2;
	
	public AdapterMetadataSensor(MetadataSensor metadata) {
		super();
		this.metadataUni = metadata;
		//this.sensor=metadata.getSensorName()+"_"+metadata.getNumberStation();
		this.service="service_"+metadata.getLocationId();
		this.station="station_"+metadata.getLocationId();
		this.point="point_"+metadata.getLocationId();
		this.address="address_"+metadata.getLocationId();
		this.station2="estacao0"+metadata.getLocationId();
		this.metadataUni.formatData();
		this.ont=new OntologyInstances();
		
	}
	public AdapterMetadataSensor(MetadataSensor[] metadata) {
		super();
		this.metadataList = metadata;
		this.ont=new OntologyInstances();
		
	}
	public static MetadataSensor dataTransform(String URL){
		Gson gson = new Gson();
		MetadataSensor data = gson.fromJson(URL, MetadataSensor.class);
		return data;
		
	}
	public static MetadataSensor[] dataTransformList(String URL){
		Gson gson = new Gson();
		MetadataSensor[] data = gson.fromJson(URL, MetadataSensor[].class);
		return data;
		
	}
	public void metadataLocation(MetadataSensor metadata) {
	ont.createClass("http://example.com/", "http://www.w3.org/2003/01/geo/wgs84_pos/", this.point, "Point");
	ont.createClass("http://example.com/", "http://dbpedia.org/resource/classes/", this.address, "Address");
	ont.createClass("http://example.com/", "http://example.com/", this.station2, "Station"); 
	
	ont.createIndividualObject("http://example.com/", "http://example.com/","http://example.com/", this.station2, "hasAddress", this.address);
	ont.createIndividualObject("http://example.com/", "http://www.w3.org/2003/01/geo/wgs84_pos/","http://example.com/", this.address, "location", this.point);

	ont.createIndividuoLiteral("http://example.com/", "http://www.w3.org/2003/01/geo/wgs84_pos/", this.point, "lat", metadata.getCoordinates().getLat());
	ont.createIndividuoLiteral("http://example.com/", "http://www.w3.org/2003/01/geo/wgs84_pos/", this.point, "long", metadata.getCoordinates().getLng());
	ont.createIndividuoLiteralString("http://example.com/", "http://www.w3.org/2000/01/rdf-schema#", this.address, "label", metadata.getAddress());
	
	
	}
	public void metadataSensors(MetadataSensor metadata) {
		for(Sensor sensor: metadata.getSensors()) {
			this.nameSensor="Sensor_"+sensor.getId();
			sensor.definitionQuantityKind();
			//classes
			ont.createClass("http://example.com/", "http://www.w3.org/ns/sosa/", this.nameSensor, "Sensor");
			ont.createClass("http://example.com/","http://purl.org/NET/ssnx/qu/qu/", "unit_"+this.nameSensor, "Unit");
			ont.createClass("http://example.com/", "http://purl.org/NET/ssnx/qu/qu/", "QuatityKind_"+this.nameSensor, "QuatityKind");
			ont.createClass("http://example.com/", "http://purl.oclc.org/NET/UNIS/fiware/iot-lite/", this.service, "Service");
			ont.createClass("http://example.com/", "http://example.com/", this.station, "Station");
			//instances-objectyProperties
			ont.createIndividualObject("http://example.com/", "http://purl.oclc.org/NET/UNIS/fiware/iot-lite/","http://example.com/", this.nameSensor, "hasUnit","unit_"+this.nameSensor);
			ont.createIndividualObject("http://example.com/", "http://purl.oclc.org/NET/UNIS/fiware/iot-lite/","http://example.com/", this.nameSensor, "hasQuantityKind", "QuatityKind_"+this.nameSensor);
			ont.createIndividualObject("http://example.com/", "http://purl.oclc.org/NET/UNIS/fiware/iot-lite/","http://example.com/", this.nameSensor, "exposedBy", this.service);
			ont.createIndividualObject("http://example.com/", "http://example.com/","http://example.com/", this.nameSensor, "belongsStation", this.station);
			
			//instancesDataProperties
			ont.createIndividuoLiteralString("http://example.com/", "http://example.com/", this.nameSensor, "id", sensor.getId());
			ont.createIndividuoLiteralString("http://example.com/", "http://example.com/", this.nameSensor, "measurementType", "avg");
			ont.createIndividuoLiteralString("http://example.com/", "http://www.w3.org/2000/01/rdf-schema#", this.station, "label", metadata.getLocationId());
			ont.createIndividuoLiteralString("http://example.com/", "http://example.com/", this.nameSensor, "updateFrequency", "1h");
			ont.createIndividuoLiteralString("http://example.com/", "http://purl.oclc.org/NET/UNIS/fiware/iot-lite/", this.service, "endpoint", "http://opendata-cml.qart.pt/lastmeasurement/"+sensor.getId());
			ont.createIndividuoLiteralString("http://example.com/", "http://www.w3.org/2000/01/rdf-schema#", "QuatityKind_"+this.nameSensor, "label", sensor.getLabelQuantityKind());
			ont.createIndividuoLiteralString("http://example.com/", "http://www.w3.org/2000/01/rdf-schema#", "unit_"+this.nameSensor, "label", sensor.getUnit());

				
					//Intances owl:sameAs
			ont.createIndividualObject("http://example.com/", "http://www.w3.org/2002/07/owl#", "http://example.com/", this.station, "sameAs", this.station2);
					
		}
			

				

		
	}
	@Override
	public String annotateDate() {
		metadataLocation(this.metadataUni);
		metadataSensors(this.metadataUni);
		return ont.returnSemanticData();
		
	}


	@Override
	public String annotateListDate() {
		for(MetadataSensor metadata:this.metadataList) {
			this.service="service_"+metadata.getLocationId();
			this.station="station_"+metadata.getLocationId();
			this.point="point_"+metadata.getLocationId();
			this.address="address_"+metadata.getLocationId();
			this.station2="estacao0"+metadata.getLocationId();
			metadata.formatData();
			metadataLocation(metadata);
			metadataSensors(metadata);
		}
	
		
		return ont.returnSemanticData();
	}

	


	

}
