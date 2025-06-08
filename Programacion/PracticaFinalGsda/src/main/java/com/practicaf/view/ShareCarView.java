package com.practicaf.view;

import javax.swing.*;

import javax.swing.border.EmptyBorder;

import com.practicaf.controller.IMainController;
import com.practicaf.controller.MainController;
import com.practicaf.model.dto.CarResponseDto;
import com.practicaf.model.dto.OwnerDto;

import net.miginfocom.swing.MigLayout;

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
	private Component horizontalStrut;
	private Component horizontalGlue;
	private Component horizontalGlue_1;
	private Component horizontalStrut_1;
	private MainView mainView;
	private JLabel lblErrorMessage;

	public ShareCarView(MainView mainView) throws ClassNotFoundException, SQLException, IOException {
		setResizable(false);
		this.mainController = new MainController();
		this.mainView = mainView;

		setTitle("Share Car");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 163);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[30px][grow][][][][][grow]", "[20px][][][]"));
		
		lblErrorMessage = new JLabel("NO puedes compartirte a ti mismo un coche");
		lblErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorMessage.setFont(new Font("Arial", Font.BOLD, 11));
		lblErrorMessage.setForeground(new Color(255, 0, 0));
		contentPane.add(lblErrorMessage, "cell 3 0 4 1");
		lblErrorMessage.setVisible(false);

		JLabel lblNewLabel_1 = new JLabel("Seleccione un coche:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_1, "cell 0 1 5 1");

		JLabel lblNewLabel = new JLabel("ID: Usuario");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(lblNewLabel, "cell 6 1");

		comboSelectCar = new JComboBox<>();
		comboSelectCar.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(comboSelectCar, "cell 0 2 5 1,growx");
		comboSelectCar.addActionListener(this);

		textUuid = new JTextField();
		textUuid.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(textUuid, "cell 6 2,growx");
		textUuid.setColumns(10);

		btnAccept = new JButton("Aceptar");
		btnAccept.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(btnAccept, "flowx,cell 6 3,alignx left");
		btnAccept.addActionListener(this);
		btnAccept.setEnabled(false);

		horizontalStrut = Box.createHorizontalStrut(20);
		contentPane.add(horizontalStrut, "cell 6 3,alignx right");

		horizontalGlue = Box.createHorizontalGlue();
		contentPane.add(horizontalGlue, "cell 6 3");

		horizontalGlue_1 = Box.createHorizontalGlue();
		contentPane.add(horizontalGlue_1, "cell 6 3");

		horizontalStrut_1 = Box.createHorizontalStrut(20);
		contentPane.add(horizontalStrut_1, "cell 6 3");

		btnCancel = new JButton("Cancelar");
		btnCancel.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCancel.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(btnCancel, "cell 6 3,alignx right");
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
			if (!mainView.getUserUuid().equals(textUuid.getText()) ) {
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
