import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import br.ufc.mdcc.DataModel.AggregationSensor;
import br.ufc.mdcc.DataModel.EventSensor;
import br.ufc.mdcc.DataModel.MetadataSensor;
import br.ufc.mdcc.DataModel.ObservationSensor;
import br.ufc.mdcc.DataModel.Sensor;
import br.ufc.mdcc.adapters.AdapterAggregationSensor;
import br.ufc.mdcc.adapters.AdapterEventSensor;
import br.ufc.mdcc.adapters.AdapterFirebase;
import br.ufc.mdcc.adapters.AdapterGraphDB;
import br.ufc.mdcc.adapters.AdapterMetadataSensor;
import br.ufc.mdcc.adapters.AdapterObservationSensor;
import br.ufc.mdcc.adapters.AdapterRequestAPI;
import br.ufc.mdcc.aggregationQuery.AggregationQuery;
import br.ufc.mdcc.aggregationQuery.QueryExecution;
import br.ufc.mdcc.execution.ExecutionAggregation;
import br.ufc.mdcc.execution.ExecutionMetadata;

public class ExecutionGraph {
	
public static ArrayList<String> buscarIds() {
	HttpURLConnection con=null;
	URL url = null;
	try {
		url = new URL("http://opendata-cml.qart.pt/locations");
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	AdapterRequestAPI req= new AdapterRequestAPI();
	con=req.connection(url);
	ArrayList<String> ids = null;
	try {
		switch (con.getResponseCode()) {
			case 200:
				ids=new ArrayList<String> ();
				String json = req.getJson(url);
				MetadataSensor[] metadata=AdapterMetadataSensor.dataTransformList(json);
				for(MetadataSensor m:metadata) {
					for(Sensor s:m.getSensors()) {
						ids.add(s.getId());
					}
				}
				
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return ids;
}

	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Construindo grafo de conhecimento com dados de sensores");
		System.out.println("Escolha uma opção:\n 1 - Anotar metadados de sensores\n "
				+ "2  - Anotar leitura de dados de sensores\n 3 - Anotar agregações de dados\n 4 - Anotar eventos\n");
		int esc=sc.nextInt();
		if(esc==1) {
			/*ExecutionMetadata.metadataUnit("http://opendata-cml.qart.pt/locations", "http://localhost:7200/repositories/Metadata_sensor/statements");*/

		}else if(esc==2) {
			
		}else if(esc==3) {
			/*AdapterGraphDB gdb=new AdapterGraphDB();
			AggregationQuery query = new AggregationQuery();
			String dataTemp = ExecutionAggregation.aggregationSemanticAnotate(query.getQueryAvgTemperature(),"http://localhost:7200/repositories/DadosAmbientais_lisboa", "avgTemp",
					"AVG", "Temperatura", "202205101100", "202205101159", "202205101100","202205102300", "202205100000");
			//System.out.println(data);
			gdb.insert(dataTemp, "http://localhost:7200/repositories/IoTStream/statements");
			System.out.println("ok");
			String dataVent = ExecutionAggregation.aggregationSemanticAnotate(query.getQueryAvgVent(),"http://localhost:7200/repositories/DadosAmbientais_lisboa", "avgVent",
					"AVG", "Intensidade_do_vento", "202205101100", "202205101159", "202205101100","202205102300", "202205100000");
			gdb.insert(dataVent, "http://localhost:7200/repositories/IoTStream/statements");
			System.out.println("ok");
			String dataUmid = ExecutionAggregation.aggregationSemanticAnotate(query.getQueryUmidade(),"http://localhost:7200/repositories/DadosAmbientais_lisboa", "avgUmid",
					"AVG", "Umidade_relativa", "202205101100", "202205101159", "202205101100","202205102300", "202205100000");
			gdb.insert(dataUmid, "http://localhost:7200/repositories/IoTStream/statements");
			System.out.println("ok");
			String dataNo2 = ExecutionAggregation.aggregationSemanticAnotate(query.getQueryNo2(),"http://localhost:7200/repositories/DadosAmbientais_lisboa", "avgNo2",
					"AVG", "NO2", "202205101100", "202205101159", "202205101100","202205102300", "202205100000");
			gdb.insert(dataNo2, "http://localhost:7200/repositories/IoTStream/statements");
			System.out.println("ok");
			String dataO3 = ExecutionAggregation.aggregationSemanticAnotate(query.getQueryO3(),"http://localhost:7200/repositories/DadosAmbientais_lisboa", "avgO3",
					"AVG", "O3", "202205101100", "202205101159", "202205101100","202205102300", "202205100000");
			gdb.insert(dataO3, "http://localhost:7200/repositories/IoTStream/statements");
			System.out.println("ok");
			String dataPm10 = ExecutionAggregation.aggregationSemanticAnotate(query.getQueryPm10(),"http://localhost:7200/repositories/DadosAmbientais_lisboa", "avgPm10",
					"AVG", "PM10", "202205101100", "202205101159", "202205101100","202205102300", "202205100000");
			gdb.insert(dataPm10, "http://localhost:7200/repositories/IoTStream/statements");
			System.out.println("ok");
			String dataPm25 = ExecutionAggregation.aggregationSemanticAnotate(query.getQueryPm25(),"http://localhost:7200/repositories/DadosAmbientais_lisboa", "avgPm25",
					"AVG", "PM25", "202205101100", "202205101159", "202205101100","202205102300", "202205100000");
			gdb.insert(dataPm25, "http://localhost:7200/repositories/IoTStream/statements");
			System.out.println("ok");
			String dataSo2 = ExecutionAggregation.aggregationSemanticAnotate(query.getQuerySo2(),"http://localhost:7200/repositories/DadosAmbientais_lisboa", "avgSo2",
					"AVG", "SO2", "202205101100", "202205101159", "202205101100","202205102300", "202205100000");
			gdb.insert(dataSo2, "http://localhost:7200/repositories/IoTStream/statements");
			System.out.println("ok");*/
		}else if(esc==4) {
			AdapterFirebase firebase= new AdapterFirebase();
			firebase.inicializarFirebase();
			AdapterGraphDB gdb=new AdapterGraphDB();
			
			System.out.println("Escolha uma opção:\n 1 - Anotar Lista de eventos\n 2 - Anotar evento único");
			int opt=sc.nextInt();
			if(opt==1) {
				ArrayList<EventSensor> ev=firebase.getListEvents("Eventos");
				AdapterEventSensor adp=new AdapterEventSensor(ev);
				String data=adp.annotateListDate();
				//System.out.println(data);
				gdb.insert(data, "http://localhost:7200/repositories/IoTStream/statements");
				System.out.println("ok");
			}else if(opt==2) {
				EventSensor ev=firebase.getEvent("Eventos", "huxMJVPfApHC4vaKo9Ed");
				AdapterEventSensor adp = new AdapterEventSensor(ev);
				String data=adp.annotateDate();
				
				//System.out.println(ev.getEvent());
			}else {
				System.out.println("Escolha uma opção válida!");
			}

			
		}else {
			System.out.println("Escolha uma opção válida!");
		}

		
		
		/**/
}
}
