package br.ufc.mdcc.execution;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import br.ufc.mdcc.DataModel.MetadataSensor;
import br.ufc.mdcc.DataModel.ObservationSensor;
import br.ufc.mdcc.adapters.AdapterGraphDB;
import br.ufc.mdcc.adapters.AdapterMetadataSensor;
import br.ufc.mdcc.adapters.AdapterObservationSensor;
import br.ufc.mdcc.adapters.AdapterRequestAPI;

public class ExecutionMetadata {
	public static void metadataUnit(String URL, String repositorio) {
		HttpURLConnection con=null;
		URL url = null;
		try {
			url = new URL(URL);
				
		} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AdapterRequestAPI req= new AdapterRequestAPI();
		con=req.connection(url);
			
		try {
			switch (con.getResponseCode()) {
				case 200:
					String json = req.getJson(url);
					AdapterGraphDB gdb = new AdapterGraphDB();	
					MetadataSensor[] metadata=AdapterMetadataSensor.dataTransformList(json);
					AdapterMetadataSensor adp = new AdapterMetadataSensor(metadata);
					String data=adp.annotateListDate();;
					gdb.insert(data,repositorio);
					gdb.insert(data,"http://localhost:3030/Metadata_sensor/update");
					break;
				case 500:
					System.out.println("Status 500");
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				con.disconnect();
			}
			
		}
		
	
	
	


}
