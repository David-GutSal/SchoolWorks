package com.practicaf.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.practicaf.controller.IMainController;
import com.practicaf.controller.MainController;
import com.practicaf.model.dto.NewOwner;
import com.practicaf.model.entities.Cars;

import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class ShareCarView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAccept;
	private JButton btnCancel;
	private JComboBox<Cars> comboSelectCar;
	private JTextField textUuid;
	private JTextField textUserName;
	private IMainController mainController;
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public ShareCarView(String userName) throws ClassNotFoundException, SQLException, IOException {
		this.mainController = new MainController();
		this.textUserName = new JTextField(userName);
		
		setTitle("Share Car");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[30px][grow][][][][][grow]", "[20px][][][]"));
		
		JLabel lblNewLabel_1 = new JLabel("Seleccione un coche:");
		contentPane.add(lblNewLabel_1, "cell 0 1 5 1");
		
		JLabel lblNewLabel = new JLabel("ID: Usuario");
		contentPane.add(lblNewLabel, "cell 6 1");
		
		comboSelectCar = new JComboBox<Cars>();
		contentPane.add(comboSelectCar, "cell 0 2 5 1,growx");
		comboSelectCar.addActionListener(this);
		
		textUuid = new JTextField();
		contentPane.add(textUuid, "cell 6 2,growx");
		textUuid.setColumns(10);
		
		btnAccept = new JButton("Aceptar");
		contentPane.add(btnAccept, "flowx,cell 6 3");
		btnAccept.addActionListener(this);
		
		btnCancel = new JButton("Cancelar");
		contentPane.add(btnCancel, "cell 6 3");
		btnCancel.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAccept) {
			Cars selectedCar = (Cars) comboSelectCar.getSelectedItem();
			NewOwner owner = new NewOwner(textUserName.getText(), textUuid.getText(), selectedCar);
			if(mainController.addCarOwner(owner)) {
				System.out.println("Propietario agregado");
				this.dispose();
			}
		}
		if(e.getSource() == btnCancel) {
			this.dispose();
		}
		
	}

}
