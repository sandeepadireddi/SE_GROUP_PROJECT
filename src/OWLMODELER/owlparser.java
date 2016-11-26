/*
 * This  class holds methods for parsing for RDF file using jena ap
 * 
 */

package OWLMODELER;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.ontology.OntProperty;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.iterator.ExtendedIterator;
public final class owlparser {
	private static final ArrayList<OntProperty> AllProperties = new ArrayList<OntProperty>();
	private  ArrayList<OntProperty> Properties =new ArrayList<OntProperty>();
	private OntModel input = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_TRANS_INF, null);
	private OntModel output = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_TRANS_INF, null);
	private  FileWriter out;
	private String FileAddr;

	private ArrayList<OntClass> Classes=new ArrayList<OntClass>();
	private ArrayList<OntClass> SubClasses=new ArrayList<OntClass>();

	public void readfile(String Value){
		FileAddr=Value;
		input.read(Value);                                               /*reading to input file*/

	}

	public ArrayList<OntClass> GetClasses(){                            /*method for listing classes*/
		ExtendedIterator<OntClass> iter = input.listNamedClasses();
		while ( iter.hasNext()){

			Classes.add(iter.next());
		}
		return Classes;
	}

	public void AddClasses(String value)                              /*method to add selected classes*/
	{
		output.createClass(value);
	}

	public ArrayList<OntProperty> GetAllProperties(){                 /*method to list all properties from input*/
		ExtendedIterator<OntProperty> iter = input.listAllOntProperties();
		while (iter.hasNext()){
			AllProperties.add(iter.next());
		}
		return AllProperties;
	}

	public ArrayList<OntClass> GetSubClasses(OntClass klass){         /*list subclass of class*/

		ExtendedIterator<OntClass> iter = klass.listSubClasses(false);
		while ( iter.hasNext()){

			SubClasses.add(iter.next());
		}
		return SubClasses;
	}

	public ArrayList<OntProperty> GetProperties(OntClass klass)      /*list properties of selected class*/
	{
		ExtendedIterator <OntProperty> iter = klass.listDeclaredProperties(true);			
		while ( iter.hasNext()){

			Properties.add(iter.next());
		}
		return Properties;
	}

	public void AddClassInstance(OntClass klass,String value){

		output.createIndividual( value, klass );                   /*adding instances */

	}

	public void AddPropertyInstance(OntProperty property,String value){

		output.createIndividual( value, property );

	}

	public void FileWrite()                                   /*Writing Output to the file*/
	{
		File file = new File(FileAddr.substring(0,FileAddr.length()-4)+"_output.rdf");
		try {
			file.createNewFile();
		} catch (IOException e1) {

			e1.printStackTrace();
		}
		try {
			out = new FileWriter( FileAddr.substring(0,FileAddr.length()-4)+"_output.rdf" ,true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		output.write( out, "RDF/XML" );
	}
	public void AddProperties(OntProperty value) {           /*adding properties to output*/

		output.createObjectProperty(value.getURI());

	}
}

