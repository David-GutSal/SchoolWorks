package com.practicaf.view;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.practicaf.controller.AuthController;
import com.practicaf.controller.IAuthController;
import com.practicaf.model.dto.UserSignInDto;

import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

public class SignIn extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUser;
	private JTextField textPassword;
	private JButton btnAccept;
	private JButton btnCancel;
	private IAuthController auth;
	private Login login;

	public void run() {
		try {
			SignIn frame = new SignIn(login);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public SignIn(Login login) throws ClassNotFoundException, SQLException, IOException {
		setResizable(false);
		this.auth = new AuthController();
		this.login = login;

		setTitle("Sign In");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 244, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 102, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 12, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel);

		textUser = new JTextField();
		textUser.setFont(new Font("Arial", Font.PLAIN, 12));
		sl_contentPane.putConstraint(SpringLayout.NORTH, textUser, 123, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, textUser, 12, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, textUser, 207, SpringLayout.WEST, contentPane);
		textUser.setColumns(10);
		contentPane.add(textUser);

		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setFont(new Font("Arial", Font.PLAIN, 12));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblContrasea, 187, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblContrasea, 12, SpringLayout.WEST, contentPane);
		contentPane.add(lblContrasea);

		textPassword = new JTextField();
		textPassword.setFont(new Font("Arial", Font.PLAIN, 12));
		sl_contentPane.putConstraint(SpringLayout.NORTH, textPassword, 208, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, textPassword, 12, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, textPassword, 207, SpringLayout.WEST, contentPane);
		textPassword.setColumns(10);
		contentPane.add(textPassword);

		btnAccept = new JButton("Aceptar");
		btnAccept.setFont(new Font("Arial", Font.PLAIN, 12));
		sl_contentPane.putConstraint(SpringLayout.WEST, btnAccept, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnAccept, -10, SpringLayout.SOUTH, contentPane);
		btnAccept.addActionListener(this);
		contentPane.add(btnAccept);

		btnCancel = new JButton("Cancelar");
		btnCancel.setFont(new Font("Arial", Font.PLAIN, 12));
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnCancel, 0, SpringLayout.NORTH, btnAccept);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnCancel, 0, SpringLayout.EAST, contentPane);
		btnCancel.addActionListener(this);
		contentPane.add(btnCancel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAccept) {
			UserSignInDto user = new UserSignInDto(textUser.getText(), textPassword.getText(), "");
			if (auth.register(user)) {
				System.out.println("Usuario agregado");
				clearText();
				this.dispose();
				login.setVisible(true);
			}
		} else if (e.getSource() == btnCancel) {
			this.dispose();
			login.setVisible(true);
		}
	}
	
	public void clearText() {
		textUser.setText("");
		textPassword.setText("");
	}
}
