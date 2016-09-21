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
		              //myPanel.add(Box.createVerticalStrut(155));// add the fields into the panel
		              //pack(); I think it wouldn't be needed
		        }
			int result = JOptionPane.showConfirmDialog(null, myPanel, 
		               "FILL THE FORM", JOptionPane.OK_CANCEL_OPTION);
		      if (result == JOptionPane.OK_OPTION) {
		         
			for(int i = 0;i< textFields.size(); i++){
				  System.out.println(textFields.get(i).getText());}
				  
				}
		      
		      //String fileAddr=JOptionPane.showInputDialog("Enter File Address");  
		      }
		public ArrayList<JTextField> GetList(){
			
			return textFields;}
	            
		}
		
		      
		      
			
		
			
		/*	for(int i = 0;i< textFields.size(); i++){
  fields[i] = textFields.get(i).getValue();
}s
		 * JTextField xField = new JTextField(5);
		      JTextField yField = new JTextField(5);

		      JPanel myPanel = new JPanel();
		      myPanel.add(new JLabel("x:"));
		      myPanel.add(xField);
		      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
		      myPanel.add(new JLabel("y:"));
		      myPanel.add(yField);

		      int result = JOptionPane.showConfirmDialog(null, myPanel, 
		               "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
		      if (result == JOptionPane.OK_OPTION) {
		         System.out.println("x value: " + xField.getText());
		         System.out.println("y value: " + yField.getText());
			}
			*/
			
			

