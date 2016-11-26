package OWLMODELER;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.apache.commons.validator.UrlValidator;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntProperty;

@SuppressWarnings("deprecation")
public class App {
	owlparser Owl=new owlparser();

	private UrlValidator urlvalidator=new UrlValidator();
	private HashMap<String, OntClass> mapClasses = new HashMap<String, OntClass>();
	private HashMap<String, OntProperty> mapProperties = new HashMap<String, OntProperty>();
	private ArrayList<String> Label= new ArrayList<String>();
	private ArrayList<String> FormLabels= new ArrayList<String>();
	public void InputFile()/*read input file and get list of classes and properties */
	{
		FileChooser inputframe=new FileChooser();
		inputframe.frame.setVisible(true);
		while(inputframe.addr==null)
		{System.out.println("waiting for user input");}

		try{
			Owl.readfile(inputframe.addr);
			inputframe.frame.dispose();

			ArrayList<OntClass> Classes = Owl.GetClasses();
			ArrayList<OntProperty> AllProperties = Owl.GetAllProperties();
			for (int i=0;i<Classes.size();i++)

			{
				mapClasses.put(Classes.get(i).toString().substring(Classes.get(i).toString().indexOf("#")), Classes.get(i));
				Label.add(Classes.get(i).toString().substring(Classes.get(i).toString().indexOf("#")));

			}
			for (int i=0;i<AllProperties.size();i++)
			{
				mapProperties.put(AllProperties.get(i).toString().substring(AllProperties.get(i).toString().indexOf("#")),AllProperties.get(i));
				Label.add(AllProperties.get(i).toString().substring(AllProperties.get(i).toString().indexOf("#")));

			}


		}

		catch(Exception e)
		{System.out.println(e);
		JOptionPane.showMessageDialog(null, "Enter a valid RDF File");
		inputframe.frame.dispose();

		InputFile();
		}
		Menu();
	}

	public void Menu()/*this method redirect data into required method */
	{ SelectionMenu frame=new SelectionMenu(Label.toArray());
	while(frame.Case==0)
	{System.out.println("Waiting for user input");}
	if(frame.Case==1)
	{AddClasses(frame.rightlist);
	frame.dispose();
	Menu();

	}
	if(frame.Case==2)
	{CreateForms(frame.rightlist);
	frame.dispose();
	Menu();
	}
	if(frame.Case==3)
	{AddProperties(frame.rightlist);
	frame.dispose();
	Menu();
	}

	}

	private void AddClasses(JList list) { /*sends classes to owl parser to add class into file*/

		ArrayList <String> ErrorList=new ArrayList<String>() ;
		for(int i=0;i<list.getModel().getSize();i++)
		{ try{Owl.AddClasses(mapClasses.get((String) list.getModel().getElementAt(i)).toString());


		}catch(Exception e)
		{ ErrorList.add((String) list.getModel().getElementAt(i));
		}}
		if(ErrorList.size()==0 && list.getModel().getSize()!=0)
		{
			Owl.FileWrite();
			JOptionPane.showMessageDialog(null, "Classes added sucessfully");

		}

		else
		{
			JOptionPane.showMessageDialog(null, "Error in adding classes");
		}



	}

	private void AddProperties(JList list) { /*sends properties to owl parser to add properties into file*/
		ArrayList <String> ErrorList=new ArrayList<String>() ;
		for(int i=0;i<list.getModel().getSize();i++)
		{ try{Owl.AddProperties(mapProperties.get((String) list.getModel().getElementAt(i)));


		}catch(Exception e)
		{ 
			ErrorList.add((String) list.getModel().getElementAt(i));
		}}
		if(ErrorList.size()==0 && list.getModel().getSize()>0 )
		{
			Owl.FileWrite();
			JOptionPane.showMessageDialog(null, "Properties added sucessfully");

		}

		else
		{
			new ErrorBox(ErrorList);
		}




	}


	public void CreateForms(JList<?> list) /*gives input for forms GUI*/
	{
		for(int i=0;i<list.getModel().getSize();i++)
		{
			ArrayList<OntClass> SubClasses = Owl.GetSubClasses(mapClasses.get((String) list.getModel().getElementAt(i)));
			FormLabels.add((String) list.getModel().getElementAt(i));
			for(int j=0;j<SubClasses.size();j++)
			{

				FormLabels.add(SubClasses.get(j).toString().substring(SubClasses.get(j).toString().indexOf("#")));


			}


		}
		for (int i=0;i<FormLabels.size();i++)
		{
			ArrayList<OntProperty> properties=new ArrayList<OntProperty>();
			if(mapClasses.get((String) FormLabels.get(i))!=null)
			{properties = Owl.GetProperties(mapClasses.get((String) FormLabels.get(i)));
			for(int j=0;j<properties.size();j++)
			{FormLabels.add(j+i+1,properties.get(j).toString().substring(properties.get(j).toString().indexOf("#")));}

			}}
		Forms frame=new Forms(FormLabels);
		frame.setVisible(true); 

		while(frame.flag == 0)
		{System.out.println("Waiting for user input");}

		AddInstance(FormLabels,frame.form);
		FormLabels.clear();
		frame.dispose();

	}

	private void AddInstance(ArrayList<String> Lables, ArrayList<JTextField> form)/* Sends instances to  owl parser to add to outputfile*/

	{   

		ArrayList <String> ErrorList=new ArrayList<String>() ;
		for (int i=0;i<form.size();i++)
		{

			if (urlvalidator.isValid(form.get(i).getText())) {


				try{
					Owl.AddClassInstance(mapClasses.get((String)Lables.get(i)), form.get(i).getText());
				}
				catch(Exception e)
				{
					Owl.AddPropertyInstance(mapProperties.get((String)Lables.get(i)), form.get(i).getText());}


			}
			else {
				ErrorList.add((String)Lables.get(i)+",");
			}}
		if(ErrorList.size()==0)
		{
			Owl.FileWrite();
		}

		else
		{
			new ErrorBox(ErrorList);

		}



	}
}
