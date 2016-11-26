/*
 * GUI for listing class and properties with Menu option
 */
package OWLMODELER;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
@SuppressWarnings("serial")
public  class SelectionMenu extends JFrame {

	private JList leftlist;
	public JList rightlist;
	public int Case=0;
	private JButton movebutton;
	private JButton movebutton_1;
	String value="";
	@SuppressWarnings("unchecked")
	public SelectionMenu(Object[] label){

		super("Select From Below");
		setBounds(100, 100, 550, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		getContentPane().setLayout(null);
		Arrays.sort(label);
		leftlist=new JList(label);
		leftlist.setVisibleRowCount(5);
		leftlist.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		JScrollPane scrollPane = new JScrollPane(leftlist);
		scrollPane.setBounds(25, 49, 190, 353);
		getContentPane().add(scrollPane);

		movebutton=new JButton("Conform");
		movebutton.setBounds(241, 158, 99, 25);
		movebutton.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						rightlist.setListData(leftlist.getSelectedValuesList().toArray());
					}
				}
				);
		getContentPane().add(movebutton);

		rightlist=new JList();
		rightlist.setVisibleRowCount(5);
		rightlist.setFixedCellWidth(150);
		rightlist.setFixedCellHeight(15);
		rightlist.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		JScrollPane scrollPane_1 = new JScrollPane(rightlist);
		scrollPane_1.setBounds(354, 49, 167, 353);
		getContentPane().add(scrollPane_1);

		movebutton_1=new JButton("Generate Form");
		movebutton_1.setBounds(193, 490, 140, 25);
		movebutton_1.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						Case=2;
					}
				}
				);

		getContentPane().add(movebutton_1);
		JButton btnAddClass = new JButton("ADD Classes");
		btnAddClass.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						Case=1;
					}
				}
				);;
				btnAddClass.setBounds(31, 490, 137, 25);
				getContentPane().add(btnAddClass);

				JButton btnAddProperties = new JButton("ADD Properties");
				btnAddProperties.addActionListener(
						new ActionListener(){
							public void actionPerformed(ActionEvent event){
								Case=3;
							}
						}
						);
				btnAddProperties.setBounds(360, 490, 167, 25);
				getContentPane().add(btnAddProperties);

	}








}

