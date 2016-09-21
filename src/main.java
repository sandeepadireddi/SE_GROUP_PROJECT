

import java.util.HashMap;
import java.util.Map;

import org.apache.jena.ontology.OntClass;
public class main {
	static int i=0;
  static String errori;
	public static void main(String[] args) {
		OntClass[] Classes=new OntClass[10000];
		owlparser OwlParser=new owlparser();
		OwlParser.readfile("C:/Users/sandeep/Desktop/js game/type.rdf");
		Classes=OwlParser.GetClasses();
		Map<String, OntClass> map = new HashMap<String, OntClass>();
		  while ( Classes[i]!=null)
		  { System.out.println(Classes[i]);
			  map.put(Classes[i].toString().substring(Classes[i].toString().indexOf("#")), Classes[i]);
			  i=i+1;
		 }
		  System.out.println(map.get("#Medium"));
		errori=OwlParser.AddInstance(Classes[5], "#banu");
		System.out.println(errori);
		errori=OwlParser.AddInstance(Classes[4], "http://www.co-ode.org/ontologies/pizza/pizza.owl#sandeep");
		//error=OwlParser.AddInstance(Classes[2], "http://www.co-ode.org/ontologies/pizza/pizza.owl#sundhar");
	
	}}