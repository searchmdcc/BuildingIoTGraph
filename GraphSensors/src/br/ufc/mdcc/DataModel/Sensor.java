package br.ufc.mdcc.DataModel;

public class Sensor {
	private String id;
	private String unit;
	private String labelQuantityKind;
	
	public void definitionQuantityKind() {
		if(this.unit.equals("ºC")) {
			this.setLabelQuantityKind("Temperatura");
			this.setUnit("Celsius");
			
		}else if(this.unit.equals("%")){
			this.setLabelQuantityKind("Umidade_Relativa");
			this.setUnit("Percentagem");
		}else if(this.unit.equals("mbar")){
			this.setLabelQuantityKind("Milibar_(Pressao_atmosferica)");
		}else if(this.unit.equals("dB(A)")){
			this.setLabelQuantityKind("Decibel_(Intensidade_do_som)");
		}else if(this.unit.equals("µg/m3")){
			if(this.id.contains("QA00NO")) {
				this.setLabelQuantityKind("Micrograma_cubico_-_(Poluente_do_ar)");
			}
			else if(this.id.contains("QA0NO2")) {
				this.setLabelQuantityKind("Micrograma_cubico_-_Dioxido_de_Azoto_-_(Poluente_do_Ar)");
			}
			else if(this.id.contains("QA00O3")) {
				this.setLabelQuantityKind("Micrograma_cubico_-_Ozono_-_(Poluente_do_Ar)");
			}else if(this.id.contains("QAPM25")) {
				this.setLabelQuantityKind("Partículas_com_diametro_inferior-a_2.5-micrograma_cubico_-_(Poluente_do_Ar)");
			}
			else if(this.id.contains("QAPM10")) {
				this.setLabelQuantityKind("Partículas_com_diametro_inferior_a_10_micrograma_cubico_-_(Poluente_do_Ar)");
			}
			else if(this.id.contains("QA0SO2")) {
				this.setLabelQuantityKind("Micrograma_cubico_-_Dioxido_de_Enxofre_-_(Poluente_do_Ar)");
			}else if(this.id.contains("QAC6H6")) {
				this.setLabelQuantityKind("Micrograma_cubico_-_Benzeno_-_(Poluente_do_Ar)");
			}else if(this.id.contains("QA00CO")) {
				this.setLabelQuantityKind("Micrograma_cubico_-_Monoxido_de_Carbono_-_(Poluente_do_Ar)");
			}	
		}else if(this.unit.equals("Veiculos")) {
			this.setLabelQuantityKind("Contagem");
		}else if(this.unit.equals("")) {
			this.setLabelQuantityKind("Dados_de_Ultravioleta");
		}else if(this.unit.equals("º")) {
			this.setLabelQuantityKind("Direcao_do_vento");
		}else if(this.unit.equals("km/h")) {
			this.setLabelQuantityKind("Intensidade_do_Vento");
		}else {
			this.setLabelQuantityKind("Nao_informado");
		}
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getLabelQuantityKind() {
		return labelQuantityKind;
	}
	public void setLabelQuantityKind(String quantityKind) {
		this.labelQuantityKind = quantityKind;
	}

	

}
