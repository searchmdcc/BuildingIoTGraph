package br.ufc.mdcc.OntologyModel;

public class OntologyInstances {
	private String classes="";
	private String individualObject="";
	private String individualLiteral="";


	public void createClass(String prefixs,String prefixOb, String subject, String TargetClassName) {
		this.classes=this.classes+"<"+prefixs+subject+"> "+"<http://www.w3.org/1999/02/22-rdf-syntax-ns#type> "+ "<"+prefixOb+TargetClassName+">.\n";
	//System.out.println(this.classes);
	}
	public void createIndividualObject(String prefixS,String prefixP, String prefixOb, String subject, String property, String object) {
		this.individualObject=this.individualObject+"<"+prefixS+subject+"> "+"<"+prefixP+property+"> "+"<"+prefixOb+object+">.\n";
		//System.out.println(this.individualObject);
	}
	public void createIndividuoLiteralString(String prefixS,String prefixP, String subject, String property, String object) {
		this.individualLiteral=this.individualLiteral+"<"+prefixS+subject+"> "+"<"+prefixP+property+"> "+"\""+object+"\""+".\n";
		//System.out.println(this.individualLiteral);
	}
	public void createIndividuoLiteral(String prefixS,String prefixP, String subject, String property, String object) {
		this.individualLiteral=this.individualLiteral+"<"+prefixS+subject+"> "+"<"+prefixP+property+"> "+object+".\n";
		//System.out.println(this.individualLiteral);
	}
	public String returnSemanticData() {
		String data=this.classes+this.individualObject+this.individualLiteral;
		return data;
	}
	
	

}
