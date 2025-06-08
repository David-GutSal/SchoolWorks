package com.practicaf.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import com.practicaf.controller.IMainController;
import com.practicaf.controller.MainController;
import com.practicaf.model.dto.ExpenseDto;

import javax.swing.JButton;
import javax.swing.SpringLayout;
import javax.swing.WindowConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.util.regex.Pattern;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class ExpenseView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textMileage;
	private JTextField textDate;
	private JTextField textDescription;
	private JTextField textImport;
	private JButton btnAccpet;
	private JButton btnCancel;
	private JComboBox<String> comboExpenseType;
	private IMainController mainController;
	private String carPlate;

	/**
	 * Create the frame.
	 * @param comboSelectCar 
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public ExpenseView(String plate) throws ClassNotFoundException, SQLException, IOException {
		this.carPlate = plate;
		this.mainController = new MainController();
		
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		setTitle("Expense");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		comboExpenseType = new JComboBox<String>();
		comboExpenseType.setFont(new Font("Arial", Font.PLAIN, 12));
		sl_contentPane.putConstraint(SpringLayout.NORTH, comboExpenseType, 79, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, comboExpenseType, 30, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, comboExpenseType, 138, SpringLayout.WEST, contentPane);
		comboExpenseType.setModel(new DefaultComboBoxModel<String>(new String[] {"Revision", "Gasolina", "ITV", "Aceite", "Otros"}));
		contentPane.add(comboExpenseType);
		
		textMileage = new JTextField();
		textMileage.setFont(new Font("Arial", Font.PLAIN, 12));
		sl_contentPane.putConstraint(SpringLayout.NORTH, textMileage, 79, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, textMileage, 163, SpringLayout.WEST, contentPane);
		contentPane.add(textMileage);
		textMileage.setColumns(10);
		
		textDate = new JTextField();
		textDate.setFont(new Font("Arial", Font.PLAIN, 12));
		sl_contentPane.putConstraint(SpringLayout.EAST, textMileage, -6, SpringLayout.WEST, textDate);
		sl_contentPane.putConstraint(SpringLayout.NORTH, textDate, 79, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, textDate, 275, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, textDate, 384, SpringLayout.WEST, contentPane);
		contentPane.add(textDate);
		textDate.setColumns(10);
		
		textImport = new JTextField();
		textImport.setFont(new Font("Arial", Font.PLAIN, 12));
		sl_contentPane.putConstraint(SpringLayout.NORTH, textImport, 145, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, textImport, 30, SpringLayout.WEST, contentPane);
		contentPane.add(textImport);
		textImport.setColumns(10);
		
		textDescription = new JTextField();
		textDescription.setFont(new Font("Arial", Font.PLAIN, 12));
		sl_contentPane.putConstraint(SpringLayout.NORTH, textDescription, 145, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, textDescription, 163, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textDescription, 185, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, textDescription, 384, SpringLayout.WEST, contentPane);
		contentPane.add(textDescription);
		textDescription.setColumns(10);
		
		btnAccpet = new JButton("Aceptar");
		btnAccpet.setFont(new Font("Arial", Font.PLAIN, 12));
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnAccpet, 199, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnAccpet, 163, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnAccpet, 271, SpringLayout.WEST, contentPane);
		contentPane.add(btnAccpet);
		btnAccpet.addActionListener(this);
		
		btnCancel = new JButton("Cancelar");
		btnCancel.setFont(new Font("Arial", Font.PLAIN, 12));
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnCancel, 199, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnCancel, 275, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnCancel, 384, SpringLayout.WEST, contentPane);
		contentPane.add(btnCancel);
		btnCancel.addActionListener(this);
		
		JLabel lblExpenseType = new JLabel("Tipo de Gasto*");
		lblExpenseType.setFont(new Font("Arial", Font.PLAIN, 12));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblExpenseType, 59, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblExpenseType, 30, SpringLayout.WEST, contentPane);
		contentPane.add(lblExpenseType);
		
		JLabel lblMileage = new JLabel("Kilometraje aprox.*");
		lblMileage.setFont(new Font("Arial", Font.PLAIN, 12));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblMileage, 59, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblMileage, 163, SpringLayout.WEST, contentPane);
		contentPane.add(lblMileage);
		
		JLabel lblDate = new JLabel("Fecha (aaaa-mm-dd) *");
		lblDate.setFont(new Font("Arial", Font.PLAIN, 12));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblDate, 59, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblDate, 275, SpringLayout.WEST, contentPane);
		contentPane.add(lblDate);
		
		JLabel lblImport = new JLabel("Importe (0.0)*");
		lblImport.setFont(new Font("Arial", Font.PLAIN, 12));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblImport, 125, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblImport, 30, SpringLayout.WEST, contentPane);
		contentPane.add(lblImport);
		
		JLabel lblDescription = new JLabel("Descripción (opcional)");
		lblDescription.setFont(new Font("Arial", Font.PLAIN, 12));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblDescription, 125, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblDescription, 167, SpringLayout.WEST, contentPane);
		contentPane.add(lblDescription);
		
		JLabel lblTitle = new JLabel("Añadiendo gasto");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblTitle, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblTitle, -99, SpringLayout.EAST, contentPane);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 26));
		contentPane.add(lblTitle);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAccpet) {
			if (validateDate() && validateMileage() && validateImport()){
				ExpenseDto expense = new ExpenseDto(comboExpenseType.getSelectedItem().toString(), Integer.parseInt(textMileage.getText()), textDate.getText(), Double.parseDouble(textImport.getText()), textDescription.getText());
				if(mainController.addExpense(carPlate, expense)) {
					System.out.println("Gasto agregado a la base de datos");
					this.dispose();
				}
			}else {
				System.out.println("Datos incorrectos");
			}
		}
		
		if (e.getSource() == btnCancel) {
			this.dispose();
		}
		
	}

	public void viewShow() {
		this.setVisible(true);
	}
	
    private boolean validateDate() {
        String datePattern = "^(\\d{4})-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$";
        return Pattern.matches(datePattern, this.textDate.getText());
    }
    
    private boolean validateMileage() {
        try {
            Integer.parseInt(textMileage.getText());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    private boolean validateImport() {
        String importPattern = "^\\d+(\\.\\d{1,2})?$";
        return Pattern.matches(importPattern, textImport.getText());
    }

}
