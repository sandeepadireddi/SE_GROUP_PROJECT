import java.io.FileWriter;
import java.io.IOException;
import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.iterator.ExtendedIterator;
public final class owlparser {
private OntModel input = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, null);
private OntModel output = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, null);
private  FileWriter out;
private  int i=0;
private OntClass[] Classes=new OntClass[200];
  
public void readfile(String Value){
	  
   input.read(Value);
   
	   }
public OntClass[] GetClasses(){ 
	   ExtendedIterator<OntClass> iter = input.listNamedClasses();
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
		} catch (IOException e1) {
			// TODO Auto-generated catch block
		    return "IOerror";
		}
		try {
		Individual I1 = output.createIndividual( value, klass );

        output.write( out, "RDF/XML" );

	} catch (Exception e) {
		// TODO Auto-generated catch block
		
		return "error";
		
	}
	    return "ok";
	    
	   
	    }
   }

