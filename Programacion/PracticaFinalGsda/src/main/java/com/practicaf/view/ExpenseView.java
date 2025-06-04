package com.practicaf.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.Font;

public class ExpenseView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textMileage;
	private JTextField textDate;
	private JTextField textDescription;
	private JTextField textImport;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExpenseView frame = new ExpenseView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ExpenseView() {
		setTitle("Expense");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JComboBox comboExpenseType = new JComboBox();
		sl_contentPane.putConstraint(SpringLayout.NORTH, comboExpenseType, 79, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, comboExpenseType, 30, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, comboExpenseType, 138, SpringLayout.WEST, contentPane);
		comboExpenseType.setModel(new DefaultComboBoxModel(new String[] {"Revición", "Gasolina", "ITV", "Aceite", "Otros"}));
		contentPane.add(comboExpenseType);
		
		textMileage = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textMileage, 79, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, textMileage, 163, SpringLayout.WEST, contentPane);
		contentPane.add(textMileage);
		textMileage.setColumns(10);
		
		textDate = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.EAST, textMileage, -6, SpringLayout.WEST, textDate);
		sl_contentPane.putConstraint(SpringLayout.NORTH, textDate, 79, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, textDate, 275, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, textDate, 384, SpringLayout.WEST, contentPane);
		contentPane.add(textDate);
		textDate.setColumns(10);
		
		textImport = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textImport, 145, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, textImport, 30, SpringLayout.WEST, contentPane);
		contentPane.add(textImport);
		textImport.setColumns(10);
		
		textDescription = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textDescription, 145, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, textDescription, 163, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textDescription, 185, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, textDescription, 384, SpringLayout.WEST, contentPane);
		contentPane.add(textDescription);
		textDescription.setColumns(10);
		
		JButton btnAccpet = new JButton("Aceptar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnAccpet, 199, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnAccpet, 163, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnAccpet, 271, SpringLayout.WEST, contentPane);
		contentPane.add(btnAccpet);
		
		JButton btnCancel = new JButton("Cancelar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnCancel, 199, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnCancel, 275, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnCancel, 384, SpringLayout.WEST, contentPane);
		contentPane.add(btnCancel);
		
		JLabel lblExpenseType = new JLabel("Tipo de Gasto*");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblExpenseType, 59, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblExpenseType, 30, SpringLayout.WEST, contentPane);
		contentPane.add(lblExpenseType);
		
		JLabel lblMileage = new JLabel("Kilometraje*");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblMileage, 59, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblMileage, 163, SpringLayout.WEST, contentPane);
		contentPane.add(lblMileage);
		
		JLabel lblDate = new JLabel("Fecha (dd/mm/aaaa) *");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblDate, 59, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblDate, 275, SpringLayout.WEST, contentPane);
		contentPane.add(lblDate);
		
		JLabel lblImport = new JLabel("Importe*");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblImport, 125, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblImport, 30, SpringLayout.WEST, contentPane);
		contentPane.add(lblImport);
		
		JLabel lblDescription = new JLabel("Descripción (opcional)");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblDescription, 125, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblDescription, 167, SpringLayout.WEST, contentPane);
		contentPane.add(lblDescription);
		
		JLabel lblNewLabel = new JLabel("Añadiendo gasto");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, -99, SpringLayout.EAST, contentPane);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		contentPane.add(lblNewLabel);
	}

}
