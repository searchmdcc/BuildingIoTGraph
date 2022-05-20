package br.ufc.mdcc.adapters;

import com.google.gson.Gson;

import br.ufc.mdcc.AdapterInterfaces.SemanticAnnotation;
import br.ufc.mdcc.DataModel.AggregationSensor;
import br.ufc.mdcc.DataModel.ObservationSensor;
import br.ufc.mdcc.OntologyModel.OntologyInstances;

public class AdapterAggregationSensor implements SemanticAnnotation {
	private AggregationSensor agr;
	private OntologyInstances ont;
	private String obs;
	private String stream;
	private String analytics;
	
	public AdapterAggregationSensor(AggregationSensor agr) {
		super();
		this.agr = agr;
		this.obs="streamObs_"+this.agr.getMethod()+"_"+this.agr.getTypeSensor()+"_"+this.agr.getTimestamp();
		this.stream="iotStream_"+this.agr.getMethod()+"_"+this.agr.getTypeSensor()+"_"+this.agr.getTimestamp();
		this.analytics="analytics_"+this.agr.getMethod()+"_"+this.agr.getTypeSensor()+"_"+this.agr.getTimestamp();
		this.ont=new OntologyInstances();
	}

	public static AggregationSensor valuesAggregationSensor(String metodo, String value, String Sensor, String dateTime, String endProc, 
			String startProc,String endStream, String startStream) {
		AggregationSensor agg= new AggregationSensor();
		agg.setMethod(metodo);
		agg.setValue(value);
		agg.setTimestamp(dateTime);
		agg.setTypeSensor(Sensor);
		agg.setEndProcess(endProc);
		agg.setStartProcess(startProc);
		agg.setStartStream(startStream);
		agg.setEndStream(endStream);
		return agg;
	}
	@Override
	public String annotateDate() {
		//classes
		ont.createClass("http://example.com/", "http://purl.org/iot/ontology/iot-stream#", this.obs, "StreamObservation");
		ont.createClass("http://example.com/", "http://purl.org/iot/ontology/iot-stream#", this.stream, "IoT-Stream");
		ont.createClass("http://example.com/", "http://purl.org/iot/ontology/iot-stream#", this.analytics, "Analytics");
		//instances-objectyProperties
		ont.createIndividualObject("http://example.com/", "http://purl.org/iot/ontology/iot-stream#", "http://example.com/", this.obs, "belongsTo", this.stream);
		ont.createIndividualObject("http://example.com/", "http://purl.org/iot/ontology/iot-stream#", "http://example.com/", this.stream, "analyzedBy", this.analytics);
		//instancesDataProperties
		ont.createIndividuoLiteral("http://example.com/", "http://www.w3.org/ns/sosa/", this.obs, "hasSimpleResult", this.agr.getValue());
		ont.createIndividuoLiteral("http://example.com/", "http://www.w3.org/ns/sosa/", this.obs, "hasResultTime", this.agr.getTimestamp());
		ont.createIndividuoLiteral("http://example.com/", "http://purl.org/iot/ontology/iot-stream#", this.stream, "streamStart", this.agr.getStartStream());
		ont.createIndividuoLiteral("http://example.com/", "http://purl.org/iot/ontology/iot-stream#", this.stream, "streamEnd", this.agr.getEndStream());
		ont.createIndividuoLiteralString("http://example.com/", "http://purl.org/iot/ontology/iot-stream#", this.analytics, "methods", this.agr.getMethod());
		ont.createIndividuoLiteral("http://example.com/", "http://purl.org/iot/ontology/iot-stream#", this.analytics, "windowsStart", this.agr.getStartProcess());
		ont.createIndividuoLiteral("http://example.com/", "http://purl.org/iot/ontology/iot-stream#", this.analytics, "windowsEnd", this.agr.getEndProcess());
		ont.createIndividuoLiteralString("http://example.com/", "http://example.com/", this.analytics, "sensorType", this.agr.getTypeSensor());
		
		return ont.returnSemanticData();
	}

	@Override
	public String annotateListDate() {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
