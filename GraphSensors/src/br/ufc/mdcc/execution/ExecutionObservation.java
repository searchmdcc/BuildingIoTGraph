package br.ufc.mdcc.execution;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import br.ufc.mdcc.DataModel.ObservationSensor;
import br.ufc.mdcc.adapters.AdapterGraphDB;
import br.ufc.mdcc.adapters.AdapterObservationSensor;
import br.ufc.mdcc.adapters.AdapterRequestAPI;

public class ExecutionObservation {

	public void observationUnit(String URL, ArrayList<String> ids, String repositorio) {
		HttpURLConnection con=null;
		URL url = null;
		for(int i=0; i<ids.size(); i++) {
			//String u="https://opendata-cml.qart.pt/measurements/"+ids.get(i)+"?startDate=202204010000&endDate=202205132300";
			String u=URL;
			//System.out.println(i);
			try {
				url = new URL(u);
				
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
					ObservationSensor obs=AdapterObservationSensor.dataTransform(json);
					AdapterObservationSensor adpObs= new AdapterObservationSensor(obs);
					String dados=adpObs.annotateDate();
					//System.out.println(dados);
					//gdb.insert(dados,"http://localhost:7200/repositories/Observation_sensor/statements");
					gdb.insert(dados,repositorio);
					System.out.println("ok");
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
	
	public void observationList(String URL, ArrayList<String> ids, String repositorio) {
		HttpURLConnection con=null;
		URL url = null;
		for(int i=0; i<ids.size(); i++) {
			//String u="https://opendata-cml.qart.pt/measurements/"+ids.get(i)+"?startDate=202204010000&endDate=202205132300";
			String u=URL;
			//System.out.println(i);
			try {
				url = new URL(u);
				
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
					ObservationSensor[] obs=AdapterObservationSensor.dataTransformList(json);
					AdapterObservationSensor adpObs= new AdapterObservationSensor(obs);
					String dados=adpObs.annotateListDate();
					//System.out.println(dados);
					//gdb.insert(dados,"http://localhost:7200/repositories/Observation_sensor/statements");
					gdb.insert(dados,repositorio);
					System.out.println("ok");
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


	
}
