package br.ufc.mdcc.DataModel;

public class AggregationSensor {
	private String method;
	private String startProcess, endProcess;
	private String startStream, endStream;
	private String typeSensor, value, timestamp;
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getStartProcess() {
		return startProcess;
	}
	public void setStartProcess(String startProcess) {
		this.startProcess = startProcess;
	}
	public String getEndProcess() {
		return endProcess;
	}
	public void setEndProcess(String endProcess) {
		this.endProcess = endProcess;
	}
	public String getStartStream() {
		return startStream;
	}
	public void setStartStream(String startStream) {
		this.startStream = startStream;
	}
	public String getEndStream() {
		return endStream;
	}
	public void setEndStream(String endStream) {
		this.endStream = endStream;
	}
	public String getTypeSensor() {
		return typeSensor;
	}
	public void setTypeSensor(String typeSensor) {
		this.typeSensor = typeSensor;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	
	
}
