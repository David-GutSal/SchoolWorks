package com.practicaf.view;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.practicaf.controller.AuthController;
import com.practicaf.controller.IAuthController;
import com.practicaf.model.entities.UserLogIn;

import javax.swing.JButton;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class Login extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textPassword;
	private JTextField textUser;
	private JButton btnAccept;
	private JButton btnCancel;
	private JButton btnSignIn;
	private IAuthController auth;
	private SignIn signIn;
	private MainView mainView;

	/**
	 * Launch the application.
	 */

	public void run() {
		try {
			Login frame = new Login();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */

	public Login() throws ClassNotFoundException, SQLException, IOException {
		this.auth = new AuthController();
		this.signIn = new SignIn();
		this.mainView = new MainView(this, "");

		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 355, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		btnCancel = new JButton("Salir");

		btnAccept = new JButton("Aceptar");
		SpringLayout sl_contentPane = new SpringLayout();
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnCancel, 0, SpringLayout.NORTH, btnAccept);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnCancel, -10, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnAccept, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnAccept, -10, SpringLayout.SOUTH, contentPane);
		contentPane.setLayout(sl_contentPane);
		btnAccept.addActionListener(this);
		btnCancel.addActionListener(this);
		contentPane.add(btnCancel);
		contentPane.add(btnAccept);

		btnSignIn = new JButton("Registrarce");
		btnSignIn.setForeground(new Color(0, 0, 255));
		sl_contentPane.putConstraint(SpringLayout.WEST, btnSignIn, 120, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnSignIn, -59, SpringLayout.SOUTH, contentPane);
		btnSignIn.addActionListener(this);
		contentPane.add(btnSignIn);

		JLabel lblPassword = new JLabel("Usuario:");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblPassword, 102, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblPassword, -241, SpringLayout.SOUTH, contentPane);
		contentPane.add(lblPassword);

		JLabel lblContrasea = new JLabel("Contraseña:");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblContrasea, 0, SpringLayout.WEST, lblPassword);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblContrasea, -171, SpringLayout.SOUTH, contentPane);
		contentPane.add(lblContrasea);

		textPassword = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textPassword, 6, SpringLayout.SOUTH, lblContrasea);
		sl_contentPane.putConstraint(SpringLayout.WEST, textPassword, 0, SpringLayout.WEST, lblPassword);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textPassword, -53, SpringLayout.NORTH, btnSignIn);
		sl_contentPane.putConstraint(SpringLayout.EAST, textPassword, -94, SpringLayout.EAST, contentPane);
		contentPane.add(textPassword);
		textPassword.setColumns(10);

		textUser = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textUser, 6, SpringLayout.SOUTH, lblPassword);
		sl_contentPane.putConstraint(SpringLayout.WEST, textUser, 0, SpringLayout.WEST, lblPassword);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textUser, -20, SpringLayout.NORTH, lblContrasea);
		sl_contentPane.putConstraint(SpringLayout.EAST, textUser, 0, SpringLayout.EAST, textPassword);
		textUser.setColumns(10);
		contentPane.add(textUser);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAccept) {
			UserLogIn user = new UserLogIn(textUser.getText(), textPassword.getText());
			if (auth.login(user)) {
				System.out.println("Acceso concedido");
				this.setVisible(false);
				mainView.viewStart(textUser.getText());
				
			}else {
				System.out.println("Acceso denegado");
			}
		} else if (e.getSource() == btnSignIn) {
			signIn.run();

		} else if (e.getSource() == btnCancel) {
			this.dispose();
		}
	}
	
}
