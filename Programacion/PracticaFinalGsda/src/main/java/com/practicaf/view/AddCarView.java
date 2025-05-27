package com.practicaf.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class AddCarView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			AddCarView frame = new AddCarView();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public AddCarView() {
		setTitle("Add Car");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[89px][86px][89px]", "[20px][20px][20px][20px][23px]"));
		
		textField = new JTextField();
		contentPane.add(textField, "cell 1 0,alignx left,aligny top");
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		contentPane.add(textField_1, "cell 1 1,alignx left,aligny top");
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		contentPane.add(textField_2, "cell 1 2,alignx left,aligny top");
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		contentPane.add(textField_3, "cell 1 3,alignx left,aligny top");
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Aceptar");
		contentPane.add(btnNewButton, "cell 0 4,alignx left,aligny top");
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		contentPane.add(btnNewButton_1, "cell 2 4,alignx left,aligny top");
		
		JLabel lblNewLabel = new JLabel("Marca:");
		contentPane.add(lblNewLabel, "cell 0 0,alignx left,aligny top");
		
		JLabel lblNewLabel_1 = new JLabel("Modelo:");
		contentPane.add(lblNewLabel_1, "cell 0 1,alignx left,aligny top");
		
		JLabel lblNewLabel_2 = new JLabel("Matrícula:");
		contentPane.add(lblNewLabel_2, "cell 0 2,alignx left,aligny top");
		
		JLabel lblNewLabel_3 = new JLabel("Año:");
		contentPane.add(lblNewLabel_3, "cell 0 3,alignx left,aligny top");
	}
}
