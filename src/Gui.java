
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
public  class Gui extends JFrame {
	
	private JList leftlist;
	public JList rightlist;
	public int flag=0;
	private JButton movebutton;
	private static String[] foods ={"file1", "file2", "file3", "file4","file5","file6","file7"};
   String value="";
	public Gui(String[] foods){
		
		super("Select From Below");
		setLayout(new FlowLayout());
		
		leftlist=new JList(foods);
		leftlist.setVisibleRowCount(5);
		leftlist.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		add(new JScrollPane(leftlist));
		JButton button = new JButton("Select File");
	    button.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent ae) {
	        JFileChooser fileChooser = new JFileChooser();
	        int returnValue = fileChooser.showOpenDialog(null);
	        if (returnValue == JFileChooser.APPROVE_OPTION) {
	          File selectedFile = fileChooser.getSelectedFile();
	          System.out.println(selectedFile.getName());
	        }
	      }
	    });
		movebutton=new JButton("CHECK");
		movebutton.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						rightlist.setListData(leftlist.getSelectedValuesList().toArray());
					}
				}
				);
		add(movebutton);
		
		rightlist=new JList();
		rightlist.setVisibleRowCount(5);
		rightlist.setFixedCellWidth(150);
		rightlist.setFixedCellHeight(15);
		rightlist.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		add(new JScrollPane(rightlist));
		
		movebutton=new JButton("Generate Form");
		movebutton.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
					flag=1;
					}
				}
				);
		add(movebutton);
		
		}
	
		//super("Select From Below");
	
		
	

}
	
