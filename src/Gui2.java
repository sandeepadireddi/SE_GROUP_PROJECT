import java.awt.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class Gui2 extends JFrame{
	ArrayList<JTextField> textFields = new ArrayList<JTextField>();
		public Gui2(JList list) {
			int rowCnt=list.getModel().getSize();
	
		
			JPanel myPanel = new JPanel();
			myPanel.setLayout(new GridLayout(2*rowCnt,1));
			this.add(myPanel);
			for(int j=0;j<rowCnt;j++){
		              JTextField textField = new JTextField(70);
		              myPanel.add(new JLabel((String) list.getModel().getElementAt(j)));
		              textField.setBounds(100*j,100,200,40);
		              textFields.add(textField);
		              
		              myPanel.add(textField);
		              
		        }
			int result = JOptionPane.showConfirmDialog(null, myPanel, 
		               "FILL THE FORM", JOptionPane.OK_CANCEL_OPTION);
		      if (result == JOptionPane.OK_OPTION) {
		         
			for(int i = 0;i< textFields.size(); i++){
				  System.out.println(textFields.get(i).getText());}
				  
				}
		      
		     
		      }
		public ArrayList<JTextField> GetList(){
			
			return textFields;}
	            
		}
		
		      
		      
