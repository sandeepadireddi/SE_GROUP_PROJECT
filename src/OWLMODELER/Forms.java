/*
 * GUI which generates forms and collect input for user
 */
package OWLMODELER;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Forms extends JFrame {

	private static final long serialVersionUID = 1L;
	public int flag=0;
	private JScrollPane scrollpane;
	ArrayList<JTextField> form= new ArrayList<JTextField>();
	public Forms(ArrayList<String> Lables) {
		super("INPUT Forms");
		setSize(900, 900);
		setDefaultCloseOperation(EXIT_ON_CLOSE);






		JPanel p = new JPanel();
		p.setSize(600, 400);
		p.setLayout(new GridLayout(0,2,10, 5));
		for (int row = 0;row < Lables.size(); row++) {
			for (int col = 0; col < 2; col++) {

				if (col == 0) {
					p.add(new JLabel( Lables.get(row)));
				} else {
					form.add( new JTextField());
					p.add(form.get(row));

				}

			}


		}
		JButton btnNewButton = new JButton("CreateFile");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				flag=1;
			}
		});
		p.add(btnNewButton);

		scrollpane = new JScrollPane(p);



		if (Lables.size()>30)
		{getContentPane().add(scrollpane, BorderLayout.CENTER);}
		else
		{getContentPane().add(scrollpane, BorderLayout.BEFORE_FIRST_LINE);}

	}

}
