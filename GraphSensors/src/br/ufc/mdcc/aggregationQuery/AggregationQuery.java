package br.ufc.mdcc.aggregationQuery;

import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;

import br.ufc.mdcc.adapters.AdapterGraphDB;

public class AggregationQuery {
	private String queryAvgTemperature = "PREFIX sosa: <http://www.w3.org/ns/sosa/>\n"
			+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
			+ "PREFIX iotl: <http://purl.oclc.org/NET/UNIS/fiware/iot-lite/>\n"
			+ "prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
			+ "SELECT (AVG(?temp) as ?avgTemp) WHERE{\n"
			+ "    SERVICE<repository:Observation_sensor>{\n"
			+ " ?obs rdf:type sosa:Observation;\n"
			+ "      sosa:hasSimpleResult ?temp;\n"
			+ "      sosa:hasResultTime 202205101100;\n"
			+ "      sosa:madeBySensor ?sensTemp.\n"
			+ "    }\n"
			+ "    SERVICE<repository:Metadata_sensor>{\n"
			+ "   ?sensTemp rdf:type sosa:Sensor;\n"
			+ "           iotl:hasQuantityKind ?kind.\n"
			+ "    ?kind rdfs:label \"Temperatura\".\n"
			+ "    }\n"
			+ "}";

	private String queryAvgVent="PREFIX sosa: <http://www.w3.org/ns/sosa/>\n"
			+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
			+ "PREFIX iotl: <http://purl.oclc.org/NET/UNIS/fiware/iot-lite/>\n"
			+ "prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
			+ "SELECT (AVG(?vent) as ?avgVent) WHERE{\n"
			+ "    SERVICE<repository:Observation_sensor>{\n"
			+ " ?obs rdf:type sosa:Observation;\n"
			+ "      sosa:hasSimpleResult ?vent;\n"
			+ "      sosa:hasResultTime 202205101100;\n"
			+ "      sosa:madeBySensor ?sensVent.\n"
			+ "    }\n"
			+ "    SERVICE<repository:Metadata_sensor>{\n"
			+ "   ?sensVent rdf:type sosa:Sensor;\n"
			+ "           iotl:hasQuantityKind ?kind.\n"
			+ "    ?kind rdfs:label \"Intensidade_do_Vento\".\n"
			+ "    }\n"
			+ "}";
	private String queryUmidade="PREFIX sosa: <http://www.w3.org/ns/sosa/>\n"
			+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
			+ "PREFIX iotl: <http://purl.oclc.org/NET/UNIS/fiware/iot-lite/>\n"
			+ "prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
			+ "SELECT (AVG(?umid) AS ?avgUmid) WHERE{\n"
			+ "    SERVICE<repository:Observation_sensor>{\n"
			+ " ?obs rdf:type sosa:Observation;\n"
			+ "      sosa:hasSimpleResult ?umid;\n"
			+ "      sosa:hasResultTime 202205101100;\n"
			+ "      sosa:madeBySensor ?sensUmid.\n"
			+ "    }\n"
			+ "    SERVICE<repository:Metadata_sensor>{\n"
			+ "   ?sensUmid rdf:type sosa:Sensor;\n"
			+ "           iotl:hasQuantityKind ?kind.\n"
			+ "    ?kind rdfs:label \"Umidade_Relativa\".\n"
			+ "    }\n"
			+ "}";
	private String queryPm25 = "PREFIX sosa: <http://www.w3.org/ns/sosa/>\n"
			+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
			+ "PREFIX iotl: <http://purl.oclc.org/NET/UNIS/fiware/iot-lite/>\n"
			+ "prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
			+ "SELECT (AVG(?pm25) AS ?avgPm25) WHERE{\n"
			+ "    SERVICE<repository:Observation_sensor>{\n"
			+ " ?obs rdf:type sosa:Observation;\n"
			+ "      sosa:hasSimpleResult ?pm25;\n"
			+ "      sosa:hasResultTime 202205101100;\n"
			+ "      sosa:madeBySensor ?sensPm25.\n"
			+ "    }\n"
			+ "    SERVICE<repository:Metadata_sensor>{\n"
			+ "   ?sensPm25 rdf:type sosa:Sensor;\n"
			+ "           iotl:hasQuantityKind ?kind.\n"
			+ "    ?kind rdfs:label \"Partículas_com_diametro_inferior-a_2.5-micrograma_cubico_-_(Poluente_do_Ar)\".\n"
			+ "    }\n"
			+ "}";
	private String queryPm10="PREFIX sosa: <http://www.w3.org/ns/sosa/>\n"
			+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
			+ "PREFIX iotl: <http://purl.oclc.org/NET/UNIS/fiware/iot-lite/>\n"
			+ "prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
			+ "SELECT (AVG(?pm10) AS ?avgPm10) WHERE{\n"
			+ "    SERVICE<repository:Observation_sensor>{\n"
			+ " ?obs rdf:type sosa:Observation;\n"
			+ "      sosa:hasSimpleResult ?pm10;\n"
			+ "      sosa:hasResultTime 202205101100;\n"
			+ "      sosa:madeBySensor ?sensPm10.\n"
			+ "    }\n"
			+ "    SERVICE<repository:Metadata_sensor>{\n"
			+ "   ?sensPm10 rdf:type sosa:Sensor;\n"
			+ "           iotl:hasQuantityKind ?kind.\n"
			+ "    ?kind rdfs:label \"Partículas_com_diametro_inferior_a_10_micrograma_cubico_-_(Poluente_do_Ar)\".\n"
			+ "    }\n"
			+ "}";
	private String queryNo2="PREFIX sosa: <http://www.w3.org/ns/sosa/>\n"
			+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
			+ "PREFIX iotl: <http://purl.oclc.org/NET/UNIS/fiware/iot-lite/>\n"
			+ "prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
			+ "SELECT (AVG(?no2) AS ?avgNo2) WHERE{\n"
			+ "    SERVICE<repository:Observation_sensor>{\n"
			+ " ?obs rdf:type sosa:Observation;\n"
			+ "      sosa:hasSimpleResult ?no2;\n"
			+ "      sosa:hasResultTime 202205101100;\n"
			+ "      sosa:madeBySensor ?sensNo2.\n"
			+ "    }\n"
			+ "    SERVICE<repository:Metadata_sensor>{\n"
			+ "   ?sensNo2 rdf:type sosa:Sensor;\n"
			+ "           iotl:hasQuantityKind ?kind.\n"
			+ "    ?kind rdfs:label \"Micrograma_cubico_-_Dioxido_de_Azoto_-_(Poluente_do_Ar)\".\n"
			+ "    }\n"
			+ "}";
	private String queryO3="PREFIX sosa: <http://www.w3.org/ns/sosa/>\n"
			+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
			+ "PREFIX iotl: <http://purl.oclc.org/NET/UNIS/fiware/iot-lite/>\n"
			+ "prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
			+ "SELECT (AVG(?O3) AS ?avgO3) WHERE{\n"
			+ "    SERVICE<repository:Observation_sensor>{\n"
			+ " ?obs rdf:type sosa:Observation;\n"
			+ "      sosa:hasSimpleResult ?O3;\n"
			+ "      sosa:hasResultTime 202205101100;\n"
			+ "      sosa:madeBySensor ?sensO3.\n"
			+ "    }\n"
			+ "    SERVICE<repository:Metadata_sensor>{\n"
			+ "   ?sensO3 rdf:type sosa:Sensor;\n"
			+ "           iotl:hasQuantityKind ?kind.\n"
			+ "    ?kind rdfs:label \"Micrograma_cubico_-_Ozono_-_(Poluente_do_Ar)\".\n"
			+ "    }\n"
			+ "}";
	private String querySo2="PREFIX sosa: <http://www.w3.org/ns/sosa/>\n"
			+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
			+ "PREFIX iotl: <http://purl.oclc.org/NET/UNIS/fiware/iot-lite/>\n"
			+ "prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
			+ "SELECT (AVG(?So2) AS ?avgSo2) WHERE{\n"
			+ "    SERVICE<repository:Observation_sensor>{\n"
			+ " ?obs rdf:type sosa:Observation;\n"
			+ "      sosa:hasSimpleResult ?So2;\n"
			+ "      sosa:hasResultTime 202205101100;\n"
			+ "      sosa:madeBySensor ?sensSo2.\n"
			+ "    }\n"
			+ "    SERVICE<repository:Metadata_sensor>{\n"
			+ "   ?sensSo2 rdf:type sosa:Sensor;\n"
			+ "           iotl:hasQuantityKind ?kind.\n"
			+ "    ?kind rdfs:label \"Micrograma_cubico_-_Dioxido_de_Enxofre_-_(Poluente_do_Ar)\".\n"
			+ "    }\n"
			+ "}";
	public String getQueryAvgTemperature() {
		return queryAvgTemperature;
	}
	public void setQueryAvgTemperature(String dataTime) {
		this.queryAvgTemperature = "PREFIX sosa: <http://www.w3.org/ns/sosa/>\n"
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
				+ "PREFIX iotl: <http://purl.oclc.org/NET/UNIS/fiware/iot-lite/>\n"
				+ "prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
				+ "SELECT (AVG(?temp) as ?avgTemp) WHERE{\n"
				+ "    SERVICE<repository:Observation_sensor>{\n"
				+ " ?obs rdf:type sosa:Observation;\n"
				+ "      sosa:hasSimpleResult ?temp;\n"
				+ "      sosa:hasResultTime "+dataTime+";\n"
				+ "      sosa:madeBySensor ?sensTemp.\n"
				+ "    }\n"
				+ "    SERVICE<repository:Metadata_sensor>{\n"
				+ "   ?sensTemp rdf:type sosa:Sensor;\n"
				+ "           iotl:hasQuantityKind ?kind.\n"
				+ "    ?kind rdfs:label \"Temperatura\".\n"
				+ "    }\n"
				+ "}";;
	}
	public String getQueryAvgVent() {
		return queryAvgVent;
	}
	public void setQueryAvgVent(String dataTime) {
		this.queryAvgVent = "PREFIX sosa: <http://www.w3.org/ns/sosa/>\n"
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
				+ "PREFIX iotl: <http://purl.oclc.org/NET/UNIS/fiware/iot-lite/>\n"
				+ "prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
				+ "SELECT (AVG(?vent) as ?avgVent) WHERE{\n"
				+ "    SERVICE<repository:Observation_sensor>{\n"
				+ " ?obs rdf:type sosa:Observation;\n"
				+ "      sosa:hasSimpleResult ?vent;\n"
				+ "      sosa:hasResultTime "+dataTime+";\n"
				+ "      sosa:madeBySensor ?sensVent.\n"
				+ "    }\n"
				+ "    SERVICE<repository:Metadata_sensor>{\n"
				+ "   ?sensVent rdf:type sosa:Sensor;\n"
				+ "           iotl:hasQuantityKind ?kind.\n"
				+ "    ?kind rdfs:label \"Intensidade_do_Vento\".\n"
				+ "    }\n"
				+ "}";;
	}
	public String getQueryUmidade() {
		return queryUmidade;
	}
	public void setQueryUmidade(String dateTime) {
		this.queryUmidade = "PREFIX sosa: <http://www.w3.org/ns/sosa/>\n"
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
				+ "PREFIX iotl: <http://purl.oclc.org/NET/UNIS/fiware/iot-lite/>\n"
				+ "prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
				+ "SELECT (AVG(?umid) AS ?avgUmid) WHERE{\n"
				+ "    SERVICE<repository:Observation_sensor>{\n"
				+ " ?obs rdf:type sosa:Observation;\n"
				+ "      sosa:hasSimpleResult ?umid;\n"
				+ "      sosa:hasResultTime "+dateTime+";\n"
				+ "      sosa:madeBySensor ?sensUmid.\n"
				+ "    }\n"
				+ "    SERVICE<repository:Metadata_sensor>{\n"
				+ "   ?sensUmid rdf:type sosa:Sensor;\n"
				+ "           iotl:hasQuantityKind ?kind.\n"
				+ "    ?kind rdfs:label \"Umidade_Relativa\".\n"
				+ "    }\n"
				+ "}";;
	}
	public String getQueryPm25() {
		return queryPm25;
	}
	public void setQueryPm25(String dateTime) {
		this.queryPm25 = "PREFIX sosa: <http://www.w3.org/ns/sosa/>\n"
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
				+ "PREFIX iotl: <http://purl.oclc.org/NET/UNIS/fiware/iot-lite/>\n"
				+ "prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
				+ "SELECT (AVG(?pm25) AS ?avgPm25) WHERE{\n"
				+ "    SERVICE<repository:Observation_sensor>{\n"
				+ " ?obs rdf:type sosa:Observation;\n"
				+ "      sosa:hasSimpleResult ?pm25;\n"
				+ "      sosa:hasResultTime "+dateTime+";\n"
				+ "      sosa:madeBySensor ?sensPm25.\n"
				+ "    }\n"
				+ "    SERVICE<repository:Metadata_sensor>{\n"
				+ "   ?sensPm25 rdf:type sosa:Sensor;\n"
				+ "           iotl:hasQuantityKind ?kind.\n"
				+ "    ?kind rdfs:label \"Partículas_com_diametro_inferior-a_2.5-micrograma_cubico_-_(Poluente_do_Ar)\".\n"
				+ "    }\n"
				+ "}";;
	}
	public String getQueryPm10() {
		return queryPm10;
	}
	public void setQueryPm10(String dateTime) {
		this.queryPm10 = "PREFIX sosa: <http://www.w3.org/ns/sosa/>\n"
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
				+ "PREFIX iotl: <http://purl.oclc.org/NET/UNIS/fiware/iot-lite/>\n"
				+ "prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
				+ "SELECT (AVG(?pm10) AS ?avgPm10) WHERE{\n"
				+ "    SERVICE<repository:Observation_sensor>{\n"
				+ " ?obs rdf:type sosa:Observation;\n"
				+ "      sosa:hasSimpleResult ?pm10;\n"
				+ "      sosa:hasResultTime "+dateTime+";\n"
				+ "      sosa:madeBySensor ?sensPm10.\n"
				+ "    }\n"
				+ "    SERVICE<repository:Metadata_sensor>{\n"
				+ "   ?sensPm10 rdf:type sosa:Sensor;\n"
				+ "           iotl:hasQuantityKind ?kind.\n"
				+ "    ?kind rdfs:label \"Partículas_com_diametro_inferior_a_10_micrograma_cubico_-_(Poluente_do_Ar)\".\n"
				+ "    }\n"
				+ "}";
	}
	public String getQueryNo2() {
		return queryNo2;
	}
	public void setQueryNo2(String dateTime) {
		this.queryNo2 ="PREFIX sosa: <http://www.w3.org/ns/sosa/>\n"
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
				+ "PREFIX iotl: <http://purl.oclc.org/NET/UNIS/fiware/iot-lite/>\n"
				+ "prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
				+ "SELECT (AVG(?no2) AS ?avgNo2) WHERE{\n"
				+ "    SERVICE<repository:Observation_sensor>{\n"
				+ " ?obs rdf:type sosa:Observation;\n"
				+ "      sosa:hasSimpleResult ?no2;\n"
				+ "      sosa:hasResultTime "+dateTime+";\n"
				+ "      sosa:madeBySensor ?sensNo2.\n"
				+ "    }\n"
				+ "    SERVICE<repository:Metadata_sensor>{\n"
				+ "   ?sensNo2 rdf:type sosa:Sensor;\n"
				+ "           iotl:hasQuantityKind ?kind.\n"
				+ "    ?kind rdfs:label \"Micrograma_cubico_-_Dioxido_de_Azoto_-_(Poluente_do_Ar)\".\n"
				+ "    }\n"
				+ "}";
	}
	public String getQueryO3() {
		return queryO3;
	}
	public void setQueryO3(String dateTime) {
		this.queryO3 = "PREFIX sosa: <http://www.w3.org/ns/sosa/>\n"
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
				+ "PREFIX iotl: <http://purl.oclc.org/NET/UNIS/fiware/iot-lite/>\n"
				+ "prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
				+ "SELECT (AVG(?O3) AS ?avgO3) WHERE{\n"
				+ "    SERVICE<repository:Observation_sensor>{\n"
				+ " ?obs rdf:type sosa:Observation;\n"
				+ "      sosa:hasSimpleResult ?O3;\n"
				+ "      sosa:hasResultTime "+dateTime+";\n"
				+ "      sosa:madeBySensor ?sensO3.\n"
				+ "    }\n"
				+ "    SERVICE<repository:Metadata_sensor>{\n"
				+ "   ?sensO3 rdf:type sosa:Sensor;\n"
				+ "           iotl:hasQuantityKind ?kind.\n"
				+ "    ?kind rdfs:label \"Micrograma_cubico_-_Ozono_-_(Poluente_do_Ar)\".\n"
				+ "    }\n"
				+ "}";
	}
	public String getQuerySo2() {
		return querySo2;
	}
	public void setQuerySo2(String dateTime) {
		this.querySo2 = "PREFIX sosa: <http://www.w3.org/ns/sosa/>\n"
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
				+ "PREFIX iotl: <http://purl.oclc.org/NET/UNIS/fiware/iot-lite/>\n"
				+ "prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
				+ "SELECT (AVG(?So2) AS ?avgSo2) WHERE{\n"
				+ "    SERVICE<repository:Observation_sensor>{\n"
				+ " ?obs rdf:type sosa:Observation;\n"
				+ "      sosa:hasSimpleResult ?So2;\n"
				+ "      sosa:hasResultTime "+dateTime+";\n"
				+ "      sosa:madeBySensor ?sensSo2.\n"
				+ "    }\n"
				+ "    SERVICE<repository:Metadata_sensor>{\n"
				+ "   ?sensSo2 rdf:type sosa:Sensor;\n"
				+ "           iotl:hasQuantityKind ?kind.\n"
				+ "    ?kind rdfs:label \"Micrograma_cubico_-_Dioxido_de_Enxofre_-_(Poluente_do_Ar)\".\n"
				+ "    }\n"
				+ "}";
	}
	
	
	
}
