package com.practicaf.view;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.practicaf.controller.IMainController;
import com.practicaf.controller.MainController;
import com.practicaf.model.entities.AddCar;
import com.practicaf.model.entities.Cars;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.SpringLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MainView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel_1;
	private JButton btnAddCar;
	private JButton btnShareCar;
	private JButton btnExpense_Information;
	private JButton btnLogOut;
	private DefaultListModel<Cars> listModel;
	private JList<Cars> carList;
	private Login login;
	private CarView carView;
	private ShareCarView shareCarView;
	private IMainController mainController;

	/**
	 * Launch the application.
	 * 
	 * @param string
	 * @param userName
	 * @throws IOException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */

	public MainView(Login login, String userName) throws ClassNotFoundException, SQLException, IOException {
		this.login = login;
		this.mainController = new MainController();
		this.carView = new CarView(this, userName);
		this.shareCarView = new ShareCarView(userName);

		listModel = new DefaultListModel<>();
		carList = new JList<>(listModel);

		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Menú Principal");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));

		lblNewLabel_1 = new JLabel("Mis coches");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

		btnAddCar = new JButton("Añadir coche");
		btnAddCar.addActionListener(this);

		btnShareCar = new JButton("Compartir coche");
		btnShareCar.addActionListener(this);

		btnExpense_Information = new JButton("Gastos & Información");
		btnExpense_Information.addActionListener(this);

		btnLogOut = new JButton("Cerrar sesion");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 441, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(177)
							.addComponent(btnLogOut))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnAddCar, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnShareCar, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnExpense_Information, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(carList, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(45)
					.addComponent(lblNewLabel)
					.addGap(31)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnAddCar)
							.addGap(62)
							.addComponent(btnShareCar)
							.addGap(56)
							.addComponent(btnExpense_Information))
						.addComponent(carList, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addComponent(btnLogOut))
		);
		contentPane.setLayout(gl_contentPane);
		btnLogOut.addActionListener(this);

	}

	public void viewStart(String userName) {
		this.carView.setUserName(userName);
		actualizarLista(userName);
		this.setVisible(true);
	}
	
	public void actualizarLista(String userName) {
		List<Cars> cars = mainController.requestCarList(userName);
		listModel.clear();
		listModel.addAll(cars);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLogOut) {
			this.setVisible(false);
			login.setVisible(true);
		}
		if (e.getSource() == btnAddCar) {
			System.out.println("Menu: Agregar coche");
			carView.setVisible(true);
			
		}
		if (e.getSource() == btnShareCar) {
			System.out.println("Menu: Compartir coche");
			shareCarView.setVisible(true);
		}
		if (e.getSource() == btnExpense_Information) {
			System.out.println("Menu: Gastos e información");
		}

	}

}
