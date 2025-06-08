package com.practicaf.view;

import javax.swing.*;


import javax.swing.border.EmptyBorder;

import com.practicaf.controller.IMainController;
import com.practicaf.controller.MainController;
import com.practicaf.model.dto.CarResponseDto;
import com.practicaf.model.dto.OwnerDto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.awt.Component;
import java.awt.Font;
import java.awt.Color;

public class ShareCarView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAccept;
	private JButton btnCancel;
	private JComboBox<CarResponseDto> comboSelectCar;
	private JTextField textUuid;
	private IMainController mainController;
	private String userName;
	private Component horizontalGlue;
	private Component horizontalGlue_1;
	private MainView mainView;
	private JLabel lblErrorMessage;

	public ShareCarView(MainView mainView) throws ClassNotFoundException, SQLException, IOException {
		setResizable(false);
		this.mainController = new MainController();
		this.mainView = mainView;

		setTitle("Share Car");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 163);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		lblErrorMessage = new JLabel("NO puedes compartirte a ti mismo un coche");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblErrorMessage, 16, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblErrorMessage, 114, SpringLayout.WEST, contentPane);
		lblErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorMessage.setFont(new Font("Arial", Font.BOLD, 11));
		lblErrorMessage.setForeground(new Color(255, 0, 0));
		contentPane.add(lblErrorMessage);
		lblErrorMessage.setVisible(false);

		JLabel lblNewLabel_1 = new JLabel("Seleccione un coche:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 39, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 12, SpringLayout.WEST, contentPane);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("ID: Usuario");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, 0, SpringLayout.EAST, lblErrorMessage);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(lblNewLabel);

		comboSelectCar = new JComboBox<>();
		sl_contentPane.putConstraint(SpringLayout.NORTH, comboSelectCar, 60, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, comboSelectCar, 12, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, comboSelectCar, 254, SpringLayout.WEST, contentPane);
		comboSelectCar.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(comboSelectCar);
		comboSelectCar.addActionListener(this);

		textUuid = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textUuid, 32, SpringLayout.SOUTH, lblErrorMessage);
		sl_contentPane.putConstraint(SpringLayout.EAST, textUuid, 539, SpringLayout.WEST, contentPane);
		textUuid.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(textUuid);
		textUuid.setColumns(10);

		btnAccept = new JButton("Aceptar");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnAccept, 0, SpringLayout.WEST, textUuid);
		btnAccept.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(btnAccept);
		btnAccept.addActionListener(this);
		btnAccept.setEnabled(false);

		horizontalGlue = Box.createHorizontalGlue();
		sl_contentPane.putConstraint(SpringLayout.WEST, textUuid, 0, SpringLayout.WEST, horizontalGlue);
		sl_contentPane.putConstraint(SpringLayout.NORTH, horizontalGlue, 101, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, horizontalGlue, 292, SpringLayout.WEST, contentPane);
		contentPane.add(horizontalGlue);

		horizontalGlue_1 = Box.createHorizontalGlue();
		sl_contentPane.putConstraint(SpringLayout.NORTH, horizontalGlue_1, 101, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, horizontalGlue_1, 299, SpringLayout.WEST, contentPane);
		contentPane.add(horizontalGlue_1);

		btnCancel = new JButton("Cancelar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnCancel, 8, SpringLayout.SOUTH, textUuid);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnAccept, 0, SpringLayout.NORTH, btnCancel);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnCancel, 0, SpringLayout.EAST, textUuid);
		btnCancel.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCancel.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(btnCancel);
		btnCancel.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == comboSelectCar) {
			System.out.println("Evento de JComboBox disparado");
			System.out.println("Cantidad de elementos: " + comboSelectCar.getItemCount());

			if (comboSelectCar.getSelectedItem() != null) {
				btnAccept.setEnabled(true);
			} else {
				btnAccept.setEnabled(false);
			}
		}
		if (e.getSource() == btnAccept) {
			if (!mainView.getUserUuid().equals(textUuid.getText())) {
				CarResponseDto selectedCar = (CarResponseDto) comboSelectCar.getSelectedItem();
				OwnerDto owner = new OwnerDto(userName, textUuid.getText(), selectedCar);
				if (mainController.addCarOwner(owner)) {
					System.out.println("Propietario agregado");
					lblErrorMessage.setVisible(false);
					clearText();
					this.dispose();
				}else {
					System.out.println("Propietario NO agregado");
				}
			} else {
				lblErrorMessage.setVisible(true);
				System.out.println("No se puede compartir a uno mismo");
			}

		}
		if (e.getSource() == btnCancel) {
			clearText();
			this.dispose();
		}
	}

	public void requestList(String userName) {
		List<CarResponseDto> carResponseDto = mainController.requestCarList(userName);
		comboSelectCar.removeAllItems();
		for (CarResponseDto car : carResponseDto) {
			comboSelectCar.addItem(car);
		}
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void viewShow() {
		requestList(this.userName);
		this.setVisible(true);
	}

	public void clearText() {
		textUuid.setText("");
	}
}
