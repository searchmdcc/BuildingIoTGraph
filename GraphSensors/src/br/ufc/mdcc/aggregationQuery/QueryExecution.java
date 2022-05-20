package br.ufc.mdcc.aggregationQuery;

import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;

import br.ufc.mdcc.adapters.AdapterGraphDB;

public class QueryExecution {
	public static String executionQueryAggregation(String query, String urlDB, String name) {
		AdapterGraphDB gdb = new AdapterGraphDB();
		String value=null;
		ResultSet results=gdb.select(query, urlDB);
		 for (ResultSet r=results; r.hasNext();) {
		      QuerySolution qs = r.next();
		      value = qs.get(name).toString();
	}
		 return value;
	}
	
}
