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

public class SignIn extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUser;
	private JTextField textPassword;
	private JButton btnAccept;
	private JButton btnCancel;
	private IAuthController auth;

	/**
	 * Launch the application.
	 */

	public void run() {
		try {
			SignIn frame = new SignIn();
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

	public SignIn() throws ClassNotFoundException, SQLException, IOException {
		this.auth = new AuthController();

		setTitle("Sign In");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 244, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		JLabel lblNewLabel = new JLabel("Usuario:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 102, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 12, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel);

		textUser = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textUser, 123, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, textUser, 12, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, textUser, 207, SpringLayout.WEST, contentPane);
		textUser.setColumns(10);
		contentPane.add(textUser);

		JLabel lblContrasea = new JLabel("Contraseña:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblContrasea, 187, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblContrasea, 12, SpringLayout.WEST, contentPane);
		contentPane.add(lblContrasea);

		textPassword = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textPassword, 208, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, textPassword, 12, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, textPassword, 207, SpringLayout.WEST, contentPane);
		textPassword.setColumns(10);
		contentPane.add(textPassword);

		btnAccept = new JButton("Aceptar");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnAccept, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnAccept, -10, SpringLayout.SOUTH, contentPane);
		btnAccept.addActionListener(this);
		contentPane.add(btnAccept);

		btnCancel = new JButton("Cancelar");
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
				this.dispose();
			}
		} else if (e.getSource() == btnCancel) {
			this.dispose();
		}
	}
}
