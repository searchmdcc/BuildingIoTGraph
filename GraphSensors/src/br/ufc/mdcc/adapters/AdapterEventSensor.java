package br.ufc.mdcc.adapters;

import java.util.ArrayList;

import br.ufc.mdcc.AdapterInterfaces.SemanticAnnotation;
import br.ufc.mdcc.DataModel.AggregationSensor;
import br.ufc.mdcc.DataModel.EventSensor;
import br.ufc.mdcc.OntologyModel.OntologyInstances;

public class AdapterEventSensor implements SemanticAnnotation {
	private ArrayList<EventSensor> eventList;
	private EventSensor ev;
	private OntologyInstances ont;
	private String event;
	private String stream;
	private String analytics;
	
	public AdapterEventSensor(EventSensor ev){
		super();
		this.ev = ev;
		this.ev.setMethod(this.ev.getMethod().replace(" ","_"));
		this.ev.setTypeSensor(this.ev.getTypeSensor().replace(" ","_"));
		this.ev.setEvent(this.ev.getEvent().replace(" ","_"));
		this.ev.setEndProcess(this.ev.getEndProcess().replace(" ","_"));
		this.ev.setEndStream(this.ev.getEndStream().replace(" ","_"));
		this.ev.setStartProcess(this.ev.getStartProcess().replace(" ","_"));
		this.ev.setStartStream(this.ev.getStartStream().replace(" ","_"));
		this.event="event"+this.ev.getMethod()+this.ev.getTypeSensor()+this.ev.getStartProcess();
		this.stream="iotStream"+this.ev.getMethod()+this.ev.getTypeSensor()+this.ev.getStartStream();
		this.analytics="analytics"+this.ev.getMethod()+this.ev.getTypeSensor()+this.ev.getStartProcess();
		this.ont=new OntologyInstances();
	}
	public AdapterEventSensor(ArrayList<EventSensor> ev){
		super();
		this.eventList= ev;
		this.ont=new OntologyInstances();
	}

	@Override
	public String annotateDate() {
		//classes
		ont.createClass("http://example.com/", "http://purl.org/iot/ontology/iot-stream#", this.event, "Event");
		ont.createClass("http://example.com/", "http://purl.org/iot/ontology/iot-stream#", this.stream, "IoT-Stream");
		ont.createClass("http://example.com/", "http://purl.org/iot/ontology/iot-stream#/", this.analytics, "Analytics");
		//instances-objectyProperties
		ont.createIndividualObject("http://example.com/", "http://purl.org/iot/ontology/iot-stream#", "http://example.com/", this.event, "detectedFrom", this.stream);
		ont.createIndividualObject("http://example.com/", "http://purl.oclc.org/NET/UNIS/fiware/iot-lite/", "http://example.com/", this.stream, "analyzedBy", this.analytics);
		//instancesDataProperties
		ont.createIndividuoLiteralString("http://example.com/", "http://purl.org/iot/ontology/iot-stream#", this.event, "label", this.ev.getEvent());
		ont.createIndividuoLiteralString("http://example.com/", "http://purl.org/iot/ontology/iot-stream#", this.stream, "streamStart", this.ev.getStartStream());
		ont.createIndividuoLiteralString("http://example.com/", "http://purl.org/iot/ontology/iot-stream#", this.stream, "streamEnd", this.ev.getEndStream());
		ont.createIndividuoLiteralString("http://example.com/", "http://purl.org/iot/ontology/iot-stream#", this.analytics, "methods", this.ev.getMethod());
		ont.createIndividuoLiteralString("http://example.com/", "http://purl.org/iot/ontology/iot-stream#", this.analytics, "windowsStart", this.ev.getStartProcess());
		ont.createIndividuoLiteralString("http://example.com/", "http://purl.org/iot/ontology/iot-stream#", this.analytics, "windowsEnd", this.ev.getEndProcess());
		ont.createIndividuoLiteralString("http://example.com/", "http://purl.org/iot/ontology/iot-stream#", this.analytics, "parameters", this.ev.getTypeSensor());
		
		return ont.returnSemanticData();
	}

	@Override
	public String annotateListDate() {
		for(EventSensor ev: this.eventList) {
			ev.setMethod(ev.getMethod().replace(" ","_"));
			ev.setTypeSensor(ev.getTypeSensor().replace(" ","_"));
			ev.setEvent(ev.getEvent().replace(" ","_"));
			ev.setEndProcess(ev.getEndProcess().replace(" ","_"));
			ev.setEndStream(ev.getEndStream().replace(" ","_"));
			ev.setStartProcess(ev.getStartProcess().replace(" ","_"));
			ev.setStartStream(ev.getStartStream().replace(" ","_"));
			this.event="event_"+ev.getMethod()+"_"+ev.getTypeSensor()+"_"+ev.getStartProcess();
			this.stream="iotStream_"+ev.getMethod()+"_"+ev.getTypeSensor()+"_"+ev.getStartStream();
			this.analytics="analytics_"+ev.getMethod()+"_"+ev.getTypeSensor()+"_"+ev.getStartProcess();
			
			ont.createClass("http://example.com/", "http://purl.org/iot/ontology/iot-stream#", this.event, "Event");
			ont.createClass("http://example.com/", "http://purl.org/iot/ontology/iot-stream#", this.stream, "IoT-Stream");
			ont.createClass("http://example.com/", "http://purl.org/iot/ontology/iot-stream#/", this.analytics, "Analytics");
			//instances-objectyProperties
			ont.createIndividualObject("http://example.com/", "http://purl.org/iot/ontology/iot-stream#", "http://example.com/", this.event, "detectedFrom", this.stream);
			ont.createIndividualObject("http://example.com/", "http://purl.oclc.org/NET/UNIS/fiware/iot-lite/", "http://example.com/", this.stream, "analyzedBy", this.analytics);
			//instancesDataProperties
			ont.createIndividuoLiteralString("http://example.com/", "http://purl.org/iot/ontology/iot-stream#", this.event, "label", ev.getEvent());
			ont.createIndividuoLiteralString("http://example.com/", "http://purl.org/iot/ontology/iot-stream#", this.stream, "streamStart", ev.getStartStream());
			ont.createIndividuoLiteralString("http://example.com/", "http://purl.org/iot/ontology/iot-stream#", this.stream, "streamEnd", ev.getEndStream());
			ont.createIndividuoLiteralString("http://example.com/", "http://purl.org/iot/ontology/iot-stream#", this.analytics, "methods", ev.getMethod());
			ont.createIndividuoLiteralString("http://example.com/", "http://purl.org/iot/ontology/iot-stream#", this.analytics, "windowsStart", ev.getStartProcess());
			ont.createIndividuoLiteralString("http://example.com/", "http://purl.org/iot/ontology/iot-stream#", this.analytics, "windowsEnd", ev.getEndProcess());
			ont.createIndividuoLiteralString("http://example.com/", "http://purl.org/iot/ontology/iot-stream#", this.analytics, "parameters", ev.getTypeSensor());
			
			
		}
	
		return ont.returnSemanticData();
	}

	
}
