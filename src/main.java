

import org.apache.jena.ontology.OntClass;
public class main {
  static String error;
	public static void main(String[] args) {
		OntClass[] Classes=new OntClass[200];
		// TODO Auto-generated method stub
		owlparser OwlParser=new owlparser();
		OwlParser.readfile("C:/Users/sandeep/Desktop/js game/type.rdf");
		Classes=OwlParser.GetClasses();
		
		error=OwlParser.AddInstance(Classes[5], "http://www.co-ode.org/ontologies/pizza/pizza.owl#banu");
		error=OwlParser.AddInstance(Classes[4], "http://www.co-ode.org/ontologies/pizza/pizza.owl#sandeep");
		error=OwlParser.AddInstance(Classes[2], "http://www.co-ode.org/ontologies/pizza/pizza.owl#sundhar");
	
	}}