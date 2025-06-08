package com.practicaf.view;

import javax.swing.JFrame;


import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.practicaf.controller.AuthController;
import com.practicaf.controller.IAuthController;
import com.practicaf.model.dto.UserLogInDto;

import javax.swing.JButton;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Font;

public class Login extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUser;
	private JButton btnAccept;
	private JButton btnSignIn;
	private IAuthController auth;
	private SignIn signIn;
	private MainView mainView;
	private JPasswordField textPassword;
	private JLabel lblUserNotFound;

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

	public Login() throws ClassNotFoundException, SQLException, IOException {
		setResizable(false);
		this.auth = new AuthController();
		this.signIn = new SignIn(this);
		this.mainView = new MainView(this);

		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 355, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		btnAccept = new JButton("Aceptar");
		btnAccept.addActionListener(this);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		textPassword = new JPasswordField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnAccept, 6, SpringLayout.SOUTH, textPassword);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnAccept, 0, SpringLayout.EAST, textPassword);
		sl_contentPane.putConstraint(SpringLayout.WEST, textPassword, 54, SpringLayout.WEST, contentPane);
		textPassword.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(textPassword);
		contentPane.add(btnAccept);

		btnSignIn = new JButton("Registrarse");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnSignIn, 6, SpringLayout.SOUTH, textPassword);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnSignIn, 0, SpringLayout.WEST, textPassword);
		btnSignIn.setBackground(SystemColor.menu);
		btnSignIn.setForeground(new Color(0, 0, 255));
		btnSignIn.addActionListener(this);
		contentPane.add(btnSignIn);
		btnSignIn.setBorderPainted(false);

		JLabel lblPassword = new JLabel("Usuario:");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblPassword, -231, SpringLayout.SOUTH, contentPane);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblPassword, 136, SpringLayout.WEST, contentPane);
		contentPane.add(lblPassword);

		JLabel lblContrasea = new JLabel("Contraseña:");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblContrasea, -161, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, textPassword, 6, SpringLayout.SOUTH, lblContrasea);
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblContrasea, 129, SpringLayout.WEST, contentPane);
		contentPane.add(lblContrasea);

		textUser = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.EAST, textPassword, 0, SpringLayout.EAST, textUser);
		sl_contentPane.putConstraint(SpringLayout.NORTH, textUser, 6, SpringLayout.SOUTH, lblPassword);
		sl_contentPane.putConstraint(SpringLayout.WEST, textUser, 54, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textUser, -20, SpringLayout.NORTH, lblContrasea);
		sl_contentPane.putConstraint(SpringLayout.EAST, textUser, -53, SpringLayout.EAST, contentPane);
		textUser.setHorizontalAlignment(SwingConstants.CENTER);
		textUser.setColumns(10);
		contentPane.add(textUser);
		
		lblUserNotFound = new JLabel("Usuario o Contraseña incorrectos");
		lblUserNotFound.setForeground(Color.RED);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblUserNotFound, 45, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblUserNotFound, 0, SpringLayout.EAST, textPassword);
		lblUserNotFound.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserNotFound.setFont(new Font("Arial", Font.BOLD, 11));
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblUserNotFound, 0, SpringLayout.SOUTH, contentPane);
		contentPane.add(lblUserNotFound);
		lblUserNotFound.setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAccept) {
			@SuppressWarnings("deprecation")
			UserLogInDto user = new UserLogInDto(textUser.getText(), textPassword.getText());
			if (auth.login(user)) {
				System.out.println("Acceso concedido");
				lblUserNotFound.setVisible(false);
				this.setVisible(false);
				mainView.viewShow(textUser.getText());
			}else {
				System.out.println("Acceso denegado");
				lblUserNotFound.setVisible(true);
			}
		}
		if (e.getSource() == btnSignIn) {
			this.setVisible(false);
			signIn.run();

		}
	}
	public void clearText() {
		textUser.setText("");
		textPassword.setText("");
	}
}
