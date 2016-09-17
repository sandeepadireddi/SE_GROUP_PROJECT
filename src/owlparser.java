import java.io.FileWriter;
import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;

import org.apache.jena.rdf.model.ModelFactory;


import org.apache.jena.util.iterator.ExtendedIterator;
public final class owlparser {
private OntModel base = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, null);
private OntModel output = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, null);

   private  FileWriter out;
   private  int i=0;
   private OntClass[] Classes=new OntClass[200];
  
   public void read(String Value){
	   try{
   base.read(Value);
   //output.read("C:/Users/sandeep/Desktop/js game/inst.rdf");
   }catch(Error e)
	   {
		System.out.print("sssssssss");
	   }
	   }
 
	  
   public OntClass[] GetClasses(){ 
	   ExtendedIterator<OntClass> iter = base.listNamedClasses();
	   while ( iter.hasNext()){
	  

   		Classes[i]=  iter.next();
   	
   		System.out.println(Classes[i]);
 
   		i=i+1;
   		 
	   }
	   return Classes;
   }
   
   public String  AddInstance(OntClass klass,String value){
	   String fileName = "C:/Users/sandeep/Desktop/js game/output.rdf";
	  
	try {
		out = new FileWriter( fileName );
		Individual p1 = output.createIndividual( value, klass );

        output.write( out, "RDF/XML" );

	} catch (Exception e) {
		// TODO Auto-generated catch block
		
		return "error";
		
	}
	    return "";
	    
	   
	    }
   }

