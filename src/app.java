
//import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFileChooser;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.jena.ontology.OntClass;
class app{
	public static void main(String[] args){
		ArrayList<JTextField> intance = new ArrayList<JTextField>();
		OntClass[] Classes=new OntClass[10000];
		owlparser OwlParser=new owlparser();
		String[] Value=new String[100];
		String errori="";
		int i=0;
		Map<String, OntClass> map = new HashMap<String, OntClass>();
		  
		String fileAddr=JOptionPane.showInputDialog("Enter File Address");
		OwlParser.readfile(fileAddr);
		Classes=OwlParser.GetClasses();
		
		while ( Classes[i]!=null)
		  { System.out.println(Classes[i]);
			  map.put(Classes[i].toString().substring(Classes[i].toString().indexOf("#")), Classes[i]);
			  Value[i]=Classes[i].toString().substring(Classes[i].toString().indexOf("#"));
			  
			  i=i+1;
		 }
		
		
		
		//JOptionPane.showMessageDialog(null,"File Addr is "+fileAddr,"title",JOptionPane.PLAIN_MESSAGE);
		if (fileAddr!=null)
		{	Gui go=new Gui(Value);
		go.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		go.setSize(500,300);
		while(go.flag==0)
		{go.setVisible(true);}
		go.dispose();
		{
        Gui2 go1=new Gui2(go.rightlist);
		go1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		go1.setSize(500,300);
		while(go1.GetList().isEmpty()==true)
		{ }
		intance=go1.GetList();
		
		for(i=0;i<intance.size();i++)
		{errori=OwlParser.AddInstance(map.get((String) go.rightlist.getModel().getElementAt(i)), intance.get(i).getText());
		System.out.println(errori);}
		
		}
	}
} 
}