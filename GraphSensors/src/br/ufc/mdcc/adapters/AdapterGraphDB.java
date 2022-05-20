package br.ufc.mdcc.adapters;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import br.ufc.mdcc.AdapterInterfaces.DataBase;

public class AdapterGraphDB implements DataBase {
	private static Logger logger = LoggerFactory.getLogger(AdapterGraphDB.class);
	private static final Marker WTF_MARKER = MarkerFactory.getMarker("WTF");
	private static String query;
	 // GraphDB 
	private static String Repo_select = 
	      "http://localhost:7200/repositories/Observations";
	private static String Repo_update = 
	      "http://localhost:7200/repositories/Observation_sensor/statements";
	@Override
	public ResultSet select(String query, String endpoint) {
		Repo_select=endpoint;
		query=query;
		QueryExecution queryExecution = QueryExecutionFactory
		        .sparqlService(Repo_select, query);
		 ResultSet results = queryExecution.execSelect();
		return results;
	}

	@Override
	public void insert(String data, String endpoint) {
		Repo_update=endpoint;
		this.query= "INSERT DATA {"+ data+"}";
		
		UpdateRequest updateRequest = UpdateFactory.create(query);
		UpdateProcessor updateProcessor = UpdateExecutionFactory.createRemote(updateRequest, Repo_update);
		updateProcessor.execute();

	}

}
