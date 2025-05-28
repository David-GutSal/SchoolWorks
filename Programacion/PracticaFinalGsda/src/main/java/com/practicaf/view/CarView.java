package com.practicaf.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.practicaf.controller.IMainController;
import com.practicaf.controller.MainController;
import com.practicaf.model.entities.AddCar;

import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

public class CarView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textBrand;
	private JTextField textModel;
	private JTextField textPlate;
	private JTextField textYear;
	private JButton btnAccept;
	private JButton btnCancel;
	private JTextField userName;
	private IMainController mainController;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public CarView(String userName) throws ClassNotFoundException, SQLException, IOException {
		this.mainController = new MainController();
		this.userName = new JTextField(userName);
		
		
		setTitle("Car Information");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		textBrand = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textBrand, 12, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, textBrand, 108, SpringLayout.WEST, contentPane);
		contentPane.add(textBrand);
		textBrand.setColumns(10);

		textModel = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textModel, 39, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, textModel, 108, SpringLayout.WEST, contentPane);
		contentPane.add(textModel);
		textModel.setColumns(10);

		textPlate = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textPlate, 66, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, textPlate, 108, SpringLayout.WEST, contentPane);
		contentPane.add(textPlate);
		textPlate.setColumns(10);

		textYear = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textYear, 93, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, textYear, 108, SpringLayout.WEST, contentPane);
		contentPane.add(textYear);
		textYear.setColumns(10);

		btnAccept = new JButton("Aceptar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnAccept, 120, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnAccept, 12, SpringLayout.WEST, contentPane);
		contentPane.add(btnAccept);
		btnAccept.addActionListener(this);

		btnCancel = new JButton("Cancelar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnCancel, 120, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnCancel, 201, SpringLayout.WEST, contentPane);
		contentPane.add(btnCancel);
		btnCancel.addActionListener(this);

		JLabel lblNewLabel = new JLabel("Marca:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 12, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 12, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Modelo:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 39, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 12, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Matrícula:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 66, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 12, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Año:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 93, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_3, 12, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_3);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAccept) {
			AddCar car = new AddCar(textBrand.getText(), textModel.getText(), textPlate.getText(), textYear.getText(), userName.getText());
			if (mainController.addCar(car)) {
				System.out.println("Coche agregado");
				this.dispose();
			}

		}
		if(e.getSource() == btnCancel) {
			this.dispose();
		}

	}

    public void setUserName(String userName) {
        this.userName.setText(userName);
    }
}
