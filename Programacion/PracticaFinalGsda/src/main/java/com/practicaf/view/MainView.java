package com.practicaf.view;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.practicaf.model.entities.AddCar;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.SpringLayout;

public class MainView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAddCar;
	private JButton btnShareCar;
	private JButton btnExpense_Information;
	private JButton btnLogOut;
	private JList<AddCar> carList;
	private Login login;
	private JLabel lblNewLabel_1;
	private CarView carView;

	/**
	 * Launch the application.
	 * @param string 
	 * @param userName 
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */

	public MainView(Login login, String userName) throws ClassNotFoundException, SQLException, IOException {
		this.login = login;
		this.carView = new CarView(userName);
		
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		JLabel lblNewLabel = new JLabel("Menú Principal");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 45, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, 446, SpringLayout.WEST, contentPane);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		contentPane.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("Mis coches");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 106, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 266, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_1, 446, SpringLayout.WEST, contentPane);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_1);

		carList = new JList<AddCar>();
		sl_contentPane.putConstraint(SpringLayout.NORTH, carList, 126, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, carList, 266, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, carList, 313, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, carList, 446, SpringLayout.WEST, contentPane);
		contentPane.add(carList);

		btnAddCar = new JButton("Añadir coche");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnAddCar, 126, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnAddCar, 5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnAddCar, 177, SpringLayout.WEST, contentPane);
		contentPane.add(btnAddCar);
		btnAddCar.addActionListener(this);

		btnShareCar = new JButton("Compartir coche");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnShareCar, 211, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnShareCar, 5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnShareCar, 177, SpringLayout.WEST, contentPane);
		contentPane.add(btnShareCar);
		btnShareCar.addActionListener(this);

		btnExpense_Information = new JButton("Gastos & Información");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnExpense_Information, 290, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnExpense_Information, 5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnExpense_Information, 177, SpringLayout.WEST, contentPane);
		contentPane.add(btnExpense_Information);
		btnExpense_Information.addActionListener(this);

		btnLogOut = new JButton("Cerrar sesion");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnLogOut, 344, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnLogOut, 177, SpringLayout.WEST, contentPane);
		contentPane.add(btnLogOut);
		btnLogOut.addActionListener(this);

	}

	public void setUserName(String userName) {
		 this.carView.setUserName(userName);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnLogOut) {
			this.setVisible(false);
			login.setVisible(true);
		}
		if(e.getSource() == btnAddCar) {
			System.out.println("Menu: Agregar coche");
			carView.setVisible(true);
		}
		if(e.getSource() == btnShareCar) {
			System.out.println("Menu: Compartir coche");
		}
		if(e.getSource() == btnExpense_Information) {
			System.out.println("Menu: Gastos e información");
		}

	}

}
