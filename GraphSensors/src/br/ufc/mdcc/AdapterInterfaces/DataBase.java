package br.ufc.mdcc.AdapterInterfaces;
import org.apache.jena.query.ResultSet;

public interface DataBase {
	public ResultSet select(String query, String endpoint);
	public void insert(String query, String endpoint);
}
