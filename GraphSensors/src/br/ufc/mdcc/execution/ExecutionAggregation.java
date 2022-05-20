package br.ufc.mdcc.execution;

import br.ufc.mdcc.DataModel.AggregationSensor;
import br.ufc.mdcc.adapters.AdapterAggregationSensor;
import br.ufc.mdcc.adapters.AdapterGraphDB;
import br.ufc.mdcc.aggregationQuery.AggregationQuery;
import br.ufc.mdcc.aggregationQuery.QueryExecution;

public class ExecutionAggregation {
	
	public static String aggregationSemanticAnotate(String query, String urlDb, String name, String method,  String sensor, String dateTime, String endProc, 
			String startProc,String endStream, String startStream) {
		
		
		String value = QueryExecution.executionQueryAggregation(query,urlDb, name);
		value=value.replace("^^http://www.w3.org/2001/XMLSchema#decimal", "");
		AggregationSensor agg=AdapterAggregationSensor.valuesAggregationSensor(method, value, sensor, dateTime,
				endProc, startProc,endStream, startStream);
		AdapterAggregationSensor anot= new AdapterAggregationSensor(agg);
		
		return anot.annotateDate();
	}
	

	
	
	
	

}
