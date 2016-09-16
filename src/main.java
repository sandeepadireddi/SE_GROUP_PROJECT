
import java.io.IOException;
import java.util.Iterator;





import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;

import org.apache.jena.rdf.model.ModelFactory;


import org.apache.jena.util.iterator.ExtendedIterator;

public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		OntModel base = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, null);
	   // OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_MICRO_RULE_INF, null);

	  //  String NS = "http://www.abc.com/abcportal/abc.owl" + "#";
   String[] a=new String[200] ;
   int i=0;
	base.read("C:/Users/sandeep/Desktop/js game/output.rdf");
	    ExtendedIterator<OntClass> iter = base.listClasses();
	    //System.out.println(iter.getClass().getName());
	    while ( iter.hasNext()){
	    	a[i]=iter.next().toString();
	    	if(a[i].indexOf("#") >= 0)
	        { System.out.println( "######################################################################## " );
	    		System.out.println(a[i]);
	    		  System.out.println( "######################################################################## " );
	        OntClass plass = base.getOntClass( a[i] );
		    for (Iterator pp = plass.listSubClasses(); pp.hasNext(); ) {
		      OntClass c = (OntClass) pp.next();
		      System.out.println( "------------------------------------------------------------------------" );
		      //System.out.println(c.getClass().getName());
		      System.out.println( c.getLocalName() + " " );
		      System.out.println( "------------------------------------------------------------------------" );
		    }
		  
	        }
	    }
	    
	}}

	


