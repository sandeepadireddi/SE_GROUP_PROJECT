/*
 * GUi to borwse input file 
 */
package OWLMODELER;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FileChooser {

	public JFrame frame;
	private final JPanel panel = new JPanel();
	private JTextField textField;
	public String addr=null;
	File selectedFile;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public FileChooser() {

		frame = new JFrame();
		frame.setBounds(300, 200, 550, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, -10, 550, 103);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblOwlModeler = new JLabel("OWL MODELER");
		lblOwlModeler.setFont(new Font("Courier", Font.BOLD, 21));
		lblOwlModeler.setBounds(12, 13, 163, 29);
		panel.add(lblOwlModeler);

		JLabel lblInputTheRdf = new JLabel("Input the RDF file from your system");
		lblInputTheRdf.setBounds(10, 54, 310, 15);
		panel.add(lblInputTheRdf);

		textField = new JTextField();
		textField.setFont(new Font("Courier", Font.PLAIN, 12));
		textField.setBounds(12, 135, 374, 32);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnBrowse = new JButton("Browse");
		btnBrowse.setBounds(419, 138, 117, 39);
		frame.getContentPane().add(btnBrowse);
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String userDir = System.getProperty("user.home");

				JFileChooser fileChooser = new JFileChooser(userDir);
				int returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					selectedFile = fileChooser.getSelectedFile();
					textField.setText(selectedFile.getAbsolutePath());
				}
			}
		});
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(262, 223, 124, 39);
		frame.getContentPane().add(btnOk);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				addr=textField.getText();
			}
		});
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setToolTipText("");
		btnCancel.setBounds(419, 223, 117, 39);
		frame.getContentPane().add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				frame.dispose();
			}
		});
	}
}
