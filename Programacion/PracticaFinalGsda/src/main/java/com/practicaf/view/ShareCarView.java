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

	public ShareCarView() throws ClassNotFoundException, SQLException, IOException {
		this.mainController = new MainController();

		setTitle("Share Car");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 163);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[30px][grow][][][][][grow]", "[20px][][][]"));

		JLabel lblNewLabel_1 = new JLabel("Seleccione un coche:");
		contentPane.add(lblNewLabel_1, "cell 0 1 5 1");

		JLabel lblNewLabel = new JLabel("ID: Usuario");
		contentPane.add(lblNewLabel, "cell 6 1");

		comboSelectCar = new JComboBox<>();
		contentPane.add(comboSelectCar, "cell 0 2 5 1,growx");
		comboSelectCar.addActionListener(this);

		textUuid = new JTextField();
		contentPane.add(textUuid, "cell 6 2,growx");
		textUuid.setColumns(10);

		btnAccept = new JButton("Aceptar");
		contentPane.add(btnAccept, "flowx,cell 6 3,alignx left");
		btnAccept.addActionListener(this);
		
		horizontalStrut = Box.createHorizontalStrut(20);
		contentPane.add(horizontalStrut, "cell 6 3,alignx right");
		
		horizontalGlue = Box.createHorizontalGlue();
		contentPane.add(horizontalGlue, "cell 6 3");
		
		horizontalGlue_1 = Box.createHorizontalGlue();
		contentPane.add(horizontalGlue_1, "cell 6 3");
		
		horizontalStrut_1 = Box.createHorizontalStrut(20);
		contentPane.add(horizontalStrut_1, "cell 6 3");

		btnCancel = new JButton("Cancelar");
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
	        CarResponseDto selectedCar = (CarResponseDto) comboSelectCar.getSelectedItem();
	        OwnerDto owner = new OwnerDto(userName, textUuid.getText(), selectedCar);
	        if (mainController.addCarOwner(owner)) {
	            System.out.println("Propietario agregado");
	            this.dispose();
	        }
	    }
	    if (e.getSource() == btnCancel) {
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
}
