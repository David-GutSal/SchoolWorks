package com.practicaf.view;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.practicaf.controller.IMainController;
import com.practicaf.controller.MainController;
import com.practicaf.model.dto.CarResponseDto;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;

public class MainView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel_1;
	private JButton btnAddCar;
	private JButton btnShareCar;
	private JButton btnExpense_Information;
	private JButton btnLogOut;
	private DefaultListModel<CarResponseDto> listModel;
	private JList<CarResponseDto> carList;
	private Login login;
	private CarView carView;
	private ShareCarView shareCarView;
	private ExpensesInfView expensesInfView;
	private IMainController mainController;
	private JTextField textUuid;

	/**
	 * Launch the application.
	 * 
	 * @param string
	 * @param userName
	 * @throws IOException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */

	public MainView(Login login) throws ClassNotFoundException, SQLException, IOException {
		setResizable(false);
		this.login = login;
		this.mainController = new MainController();
		this.carView = new CarView(this);
		this.shareCarView = new ShareCarView();
		this.expensesInfView = new ExpensesInfView(this);

		listModel = new DefaultListModel<>();
		carList = new JList<>(listModel);

		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JLabel lblTitle = new JLabel("Menú Principal");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 25));

		lblNewLabel_1 = new JLabel("Mis coches");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

		btnAddCar = new JButton("Añadir coche");
		btnAddCar.addActionListener(this);

		btnShareCar = new JButton("Compartir coche");
		btnShareCar.addActionListener(this);

		btnExpense_Information = new JButton("Gastos & Información");
		btnExpense_Information.addActionListener(this);

		btnLogOut = new JButton("Cerrar sesion");
		
		textUuid = new JTextField();
		textUuid.setBackground(SystemColor.menu);
		textUuid.setEditable(false);
		textUuid.setForeground(new Color(192, 192, 192));
		textUuid.setColumns(10);
		
		JLabel lblUuid = new JLabel("ID:");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 441, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnLogOut))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnAddCar, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnShareCar, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnExpense_Information, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(carList, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))))
					.addGap(27))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblUuid)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textUuid, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(199, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUuid)
						.addComponent(textUuid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addComponent(lblTitle)
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnAddCar)
							.addGap(62)
							.addComponent(btnShareCar)
							.addGap(56)
							.addComponent(btnExpense_Information))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(carList, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)))
					.addGap(31)
					.addComponent(btnLogOut)
					.addGap(24))
		);
		contentPane.setLayout(gl_contentPane);
		btnLogOut.addActionListener(this);

	}

	public void viewShow(String userName) {
		this.carView.setUserName(userName);
		this.shareCarView.setUserName(userName);
		this.expensesInfView.setUserName(userName);
		this.textUuid.setText(mainController.requestUuid(userName));
		updateList(userName);
		this.setVisible(true);
	}

	public void updateList(String userName) {
		List<CarResponseDto> carResponseDto = mainController.requestCarList(userName);
		listModel.clear();
		listModel.addAll(carResponseDto);
		System.out.println( "Numero de coches" + listModel.getSize());
		
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
			shareCarView.viewShow();
		}
		if (e.getSource() == btnExpense_Information) {
			System.out.println("Menu: Gastos e información");
			expensesInfView.viewShow();
			this.setVisible(false);
		}

	}
}
