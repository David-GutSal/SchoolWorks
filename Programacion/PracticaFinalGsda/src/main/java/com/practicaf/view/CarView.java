package com.practicaf.view;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.practicaf.controller.IMainController;
import com.practicaf.controller.MainController;
import com.practicaf.model.dto.CarCreateDto;

import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import java.awt.Font;
import java.awt.Color;

public class CarView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textBrand;
	private JTextField textModel;
	private JTextField textPlate;
	private JTextField textYear;
	private JButton btnAccept;
	private JButton btnCancel;
	private JTextField textUserName;
	private IMainController mainController;
	private MainView mainView;
	private JLabel lblErrorMessage;

	public CarView(MainView mainView) throws ClassNotFoundException, SQLException, IOException {
		setResizable(false);
		this.mainController = new MainController();
		this.textUserName = new JTextField();
		this.mainView = mainView;

		setTitle("Adding Car");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		textBrand = new JTextField();
		textBrand.setFont(new Font("Arial", Font.PLAIN, 12));
		sl_contentPane.putConstraint(SpringLayout.NORTH, textBrand, 12, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, textBrand, 108, SpringLayout.WEST, contentPane);
		contentPane.add(textBrand);
		textBrand.setColumns(10);

		textModel = new JTextField();
		textModel.setFont(new Font("Arial", Font.PLAIN, 12));
		sl_contentPane.putConstraint(SpringLayout.NORTH, textModel, 39, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, textModel, 108, SpringLayout.WEST, contentPane);
		contentPane.add(textModel);
		textModel.setColumns(10);

		textPlate = new JTextField();
		textPlate.setFont(new Font("Arial", Font.PLAIN, 12));
		sl_contentPane.putConstraint(SpringLayout.NORTH, textPlate, 66, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, textPlate, 108, SpringLayout.WEST, contentPane);
		contentPane.add(textPlate);
		textPlate.setColumns(10);

		textYear = new JTextField();
		textYear.setFont(new Font("Arial", Font.PLAIN, 12));
		sl_contentPane.putConstraint(SpringLayout.NORTH, textYear, 93, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, textYear, 108, SpringLayout.WEST, contentPane);
		contentPane.add(textYear);
		textYear.setColumns(10);

		btnAccept = new JButton("Aceptar");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnAccept, -23, SpringLayout.SOUTH, contentPane);
		btnAccept.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(btnAccept);
		btnAccept.addActionListener(this);

		btnCancel = new JButton("Cancelar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnCancel, 0, SpringLayout.NORTH, btnAccept);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnCancel, -10, SpringLayout.EAST, contentPane);
		btnCancel.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(btnCancel);
		btnCancel.addActionListener(this);

		JLabel lblNewLabel = new JLabel("Marca:");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnAccept, 0, SpringLayout.WEST, lblNewLabel);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 12, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 12, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Modelo:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 39, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 12, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Matrícula:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 66, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 12, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Año:");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 93, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_3, 12, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_3);
		
		lblErrorMessage = new JLabel("Datos inválidos");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblErrorMessage, 0, SpringLayout.WEST, textBrand);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblErrorMessage, 0, SpringLayout.SOUTH, contentPane);
		lblErrorMessage.setFont(new Font("Arial", Font.BOLD, 11));
		lblErrorMessage.setForeground(Color.RED);
		contentPane.add(lblErrorMessage);
		lblErrorMessage.setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAccept) {
			try {
				CarCreateDto car = new CarCreateDto(textBrand.getText(), textModel.getText(), textPlate.getText(),
						Integer.parseInt(textYear.getText()), textUserName.getText());
				if (validateData(car)) {
					lblErrorMessage.setVisible(false);
					if (mainController.carCreateDto(car)) {
						System.out.println("Coche agregado");
						mainView.updateList(textUserName.getText());
						this.dispose();
						clearText();
					} else {
						System.out.println("Coche NO agregado");
					}
				}else {
					lblErrorMessage.setVisible(true);
				}

			} catch (NumberFormatException i) {
				System.out.println("El texto introducido no es un número entero válido.");
			}

		}
		if (e.getSource() == btnCancel) {
			this.dispose();
		}

	}

	public void setUserName(String userName) {
		this.textUserName.setText(userName);
	}

	public void clearText() {
		textBrand.setText("");
		textModel.setText("");
		textPlate.setText("");
		textYear.setText("");
	}

	public boolean validateData(CarCreateDto car) {
		if ((car.getBrand().length()) <= 11 && car.getModel().length() <= 11 && car.getPlate().length() <= 7
				&& car.getYear() <= 9999) {
			return true;
		}
		return false;
	}
}
