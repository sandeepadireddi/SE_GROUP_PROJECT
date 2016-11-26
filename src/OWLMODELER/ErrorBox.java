/*
 * Error Gui To display errors 
 */
package OWLMODELER;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ErrorBox  extends JFrame{

	public ErrorBox (ArrayList<String> list)
	{JScrollPane scrollpane = new JScrollPane(); 
	list.add(0,"INPUTS");
	list.add(list.size(),"ARE NOT VALID");
	JList<String> Error = new JList(list.toArray());
	scrollpane = new JScrollPane(Error);

	JPanel panel = new JPanel(); 
	panel.add(scrollpane);

	scrollpane.getViewport().add( Error);
	JOptionPane.showMessageDialog(null, scrollpane, "Error List",  
			JOptionPane.PLAIN_MESSAGE);	
	}


}
