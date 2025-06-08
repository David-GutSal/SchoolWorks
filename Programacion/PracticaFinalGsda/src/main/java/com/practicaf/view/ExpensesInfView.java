package com.practicaf.view;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Color;

import com.practicaf.controller.IMainController;
import com.practicaf.controller.MainController;
import com.practicaf.model.dto.CarResponseDto;
import com.practicaf.model.dto.ExpenseDto;

public class ExpensesInfView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private String userName;
	private CarResponseDto selectedCar;
	private IMainController mainController;
	private MainView mainView;
	private ExpenseView expenseView;
	private JPanel contentPane;
	private JLabel lblMin;
	private JLabel lblMax;
	private JTextField textBrand;
	private JTextField textModel;
	private JTextField textPlate;
	private JTextField textMinimum;
	private JTextField textYear;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField textMaximum;
	private JToggleButton tglbtnEditCar;
	private JButton btnAddExpense;
	private JButton btnAccept;
	private JButton btnDeleteCar;
	private JButton btnAcceptFilter;
	private JButton btnExit;
	private JComboBox<String> comboFilter;
	private JComboBox<CarResponseDto> comboSelectCar;

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ExpensesInfView(MainView mainView) throws ClassNotFoundException, SQLException, IOException {
		setTitle("Expenses & Information");
		this.mainController = new MainController();
		this.mainView = mainView;

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
		contentPane.setBackground(Color.WHITE);

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		JLabel lblSelecCar = new JLabel("Seleccione un coche:");
		lblSelecCar.setFont(new Font("Arial", Font.BOLD, 12));
		lblSelecCar.setForeground(Color.DARK_GRAY);
		contentPane.add(lblSelecCar);

		comboSelectCar = new JComboBox<CarResponseDto>();
		sl_contentPane.putConstraint(SpringLayout.WEST, lblSelecCar, 0, SpringLayout.WEST, comboSelectCar);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblSelecCar, -2, SpringLayout.NORTH, comboSelectCar);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblSelecCar, -5, SpringLayout.EAST, comboSelectCar);
		sl_contentPane.putConstraint(SpringLayout.WEST, comboSelectCar, 70, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, comboSelectCar, -280, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, comboSelectCar, -464, SpringLayout.EAST, contentPane);
		contentPane.add(comboSelectCar);
		comboSelectCar.addActionListener(this);
		comboSelectCar.setFont(new Font("Arial", Font.PLAIN, 12));

		btnDeleteCar = new JButton("Eliminar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnDeleteCar, 0, SpringLayout.NORTH, comboSelectCar);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnDeleteCar, -278, SpringLayout.EAST, contentPane);
		contentPane.add(btnDeleteCar);
		btnDeleteCar.addActionListener(this);
		btnDeleteCar.setFont(new Font("Arial", Font.PLAIN, 12));

		JLabel lblBrand = new JLabel("Marca:");
		lblBrand.setFont(new Font("Arial", Font.PLAIN, 12));
		lblBrand.setForeground(Color.DARK_GRAY);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblBrand, 5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblBrand, -256, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblBrand, -610, SpringLayout.EAST, contentPane);
		contentPane.add(lblBrand);

		textBrand = new JTextField();
		textBrand.setFont(new Font("Arial", Font.PLAIN, 12));
		sl_contentPane.putConstraint(SpringLayout.WEST, textBrand, 70, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textBrand, -253, SpringLayout.SOUTH, contentPane);
		contentPane.add(textBrand);
		textBrand.setColumns(10);

		JLabel lblModel = new JLabel("Modelo:");
		lblModel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblModel.setForeground(Color.DARK_GRAY);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblModel, 5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblModel, -230, SpringLayout.SOUTH, contentPane);
		contentPane.add(lblModel);

		textModel = new JTextField();
		textModel.setFont(new Font("Arial", Font.PLAIN, 12));
		sl_contentPane.putConstraint(SpringLayout.EAST, lblModel, -6, SpringLayout.WEST, textModel);
		sl_contentPane.putConstraint(SpringLayout.WEST, textModel, 70, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textModel, -227, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, textModel, 0, SpringLayout.EAST, textBrand);
		contentPane.add(textModel);
		textModel.setColumns(10);

		JLabel lblPlate = new JLabel("Matrícula:");
		lblPlate.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPlate.setForeground(Color.DARK_GRAY);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblPlate, 5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblPlate, -204, SpringLayout.SOUTH, contentPane);
		contentPane.add(lblPlate);

		textPlate = new JTextField();
		textPlate.setFont(new Font("Arial", Font.PLAIN, 12));
		sl_contentPane.putConstraint(SpringLayout.EAST, lblPlate, -6, SpringLayout.WEST, textPlate);
		sl_contentPane.putConstraint(SpringLayout.WEST, textPlate, 70, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textPlate, -201, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, textPlate, 0, SpringLayout.EAST, textBrand);
		contentPane.add(textPlate);
		textPlate.setColumns(10);

		JLabel lblYear = new JLabel("Año:");
		lblYear.setFont(new Font("Arial", Font.PLAIN, 12));
		lblYear.setForeground(Color.DARK_GRAY);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblYear, 5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblYear, -178, SpringLayout.SOUTH, contentPane);
		contentPane.add(lblYear);

		textYear = new JTextField();
		textYear.setFont(new Font("Arial", Font.PLAIN, 12));
		sl_contentPane.putConstraint(SpringLayout.EAST, lblYear, -6, SpringLayout.WEST, textYear);
		sl_contentPane.putConstraint(SpringLayout.WEST, textYear, 70, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textYear, -175, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, textYear, 0, SpringLayout.EAST, textBrand);
		contentPane.add(textYear);
		textYear.setColumns(10);

		comboFilter = new JComboBox<String>();
		comboFilter.setFont(new Font("Arial", Font.PLAIN, 12));
		comboFilter.setModel(new DefaultComboBoxModel<String>(new String[] { "Todos", "Fecha", "Kilometraje" }));
		sl_contentPane.putConstraint(SpringLayout.WEST, comboFilter, 70, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, comboFilter, -147, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, comboFilter, -504, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, textBrand, 0, SpringLayout.EAST, comboFilter);
		contentPane.add(comboFilter);
		comboFilter.addActionListener(this);

		textMinimum = new JTextField();
		textMinimum.setFont(new Font("Arial", Font.PLAIN, 12));
		sl_contentPane.putConstraint(SpringLayout.NORTH, textMinimum, 0, SpringLayout.NORTH, comboFilter);
		contentPane.add(textMinimum);
		textMinimum.setColumns(10);

		btnAccept = new JButton("Guardar Cambios");
		sl_contentPane.putConstraint(SpringLayout.EAST, btnAccept, -324, SpringLayout.EAST, contentPane);
		btnAccept.setFont(new Font("Arial", Font.PLAIN, 12));
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnAccept, -4, SpringLayout.NORTH, lblPlate);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnAccept, 47, SpringLayout.EAST, textPlate);
		contentPane.add(btnAccept);
		btnAccept.addActionListener(this);

		btnAddExpense = new JButton("Agregar Gasto");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnAddExpense, 711, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnAddExpense, -22, SpringLayout.EAST, contentPane);
		btnAddExpense.setFont(new Font("Arial", Font.PLAIN, 12));
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnAddExpense, -1, SpringLayout.NORTH, comboFilter);
		contentPane.add(btnAddExpense);
		btnAddExpense.addActionListener(this);

		table = new JTable();
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "TipoDeGasto", "Kilometraje", "Fecha",
				"Importe", "Descripción (máx: 55 caracteres)" }) {
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, Object.class, String.class };

			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(400);

		scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		table.setFillsViewportHeight(true);

		contentPane.add(scrollPane);

		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane, 221, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane, 70, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane, 0, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane, -22, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, table, 221, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, table, 70, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, table, 0, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, table, -22, SpringLayout.EAST, contentPane);

		JLabel lblFilter = new JLabel("Filtrar por:");
		lblFilter.setFont(new Font("Arial", Font.PLAIN, 12));
		lblFilter.setForeground(Color.DARK_GRAY);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblFilter, 4, SpringLayout.NORTH, comboFilter);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblFilter, 0, SpringLayout.WEST, lblBrand);
		contentPane.add(lblFilter);

		lblMin = new JLabel("Min:");
		sl_contentPane.putConstraint(SpringLayout.WEST, textMinimum, 7, SpringLayout.EAST, lblMin);
		lblMin.setFont(new Font("Arial", Font.PLAIN, 12));
		lblMin.setForeground(Color.DARK_GRAY);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblMin, 3, SpringLayout.NORTH, comboFilter);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblMin, 0, SpringLayout.EAST, comboSelectCar);
		contentPane.add(lblMin);

		lblMax = new JLabel("Max:");
		sl_contentPane.putConstraint(SpringLayout.EAST, textMinimum, -18, SpringLayout.WEST, lblMax);
		lblMax.setFont(new Font("Arial", Font.PLAIN, 12));
		lblMax.setForeground(Color.DARK_GRAY);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnDeleteCar, 0, SpringLayout.WEST, lblMax);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblMax, -335, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblMax, 3, SpringLayout.NORTH, comboFilter);
		contentPane.add(lblMax);

		tglbtnEditCar = new JToggleButton("Editar");
		tglbtnEditCar.setFont(new Font("Arial", Font.PLAIN, 12));
		sl_contentPane.putConstraint(SpringLayout.NORTH, tglbtnEditCar, 0, SpringLayout.NORTH, comboSelectCar);
		sl_contentPane.putConstraint(SpringLayout.WEST, tglbtnEditCar, 20, SpringLayout.EAST, comboSelectCar);
		contentPane.add(tglbtnEditCar);
		tglbtnEditCar.addActionListener(this);

		textMaximum = new JTextField();
		textMaximum.setFont(new Font("Arial", Font.PLAIN, 12));
		sl_contentPane.putConstraint(SpringLayout.NORTH, textMaximum, 0, SpringLayout.NORTH, comboFilter);
		sl_contentPane.putConstraint(SpringLayout.WEST, textMaximum, 6, SpringLayout.EAST, lblMax);
		sl_contentPane.putConstraint(SpringLayout.EAST, textMaximum, 75, SpringLayout.EAST, lblMax);
		textMaximum.setColumns(10);
		contentPane.add(textMaximum);

		btnAcceptFilter = new JButton("Buscar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnAcceptFilter, -1, SpringLayout.NORTH, comboFilter);
		btnAcceptFilter.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(btnAcceptFilter);
		btnAcceptFilter.addActionListener(this);

		btnExit = new JButton("Salir");
		btnExit.setFont(new Font("Arial", Font.PLAIN, 12));
		sl_contentPane.putConstraint(SpringLayout.WEST, btnExit, 0, SpringLayout.WEST, lblBrand);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnExit, 0, SpringLayout.SOUTH, table);
		contentPane.add(btnExit);
		btnExit.addActionListener(this);

		JLabel lblTitle_p1 = new JLabel("Gastos");
		lblTitle_p1.setFont(new Font("Arial", Font.BOLD, 28));
		lblTitle_p1.setForeground(Color.BLACK);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblTitle_p1, 318, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblTitle_p1, -6, SpringLayout.NORTH, lblSelecCar);
		contentPane.add(lblTitle_p1);

		JLabel lblTitle_p2 = new JLabel("&");
		lblTitle_p2.setFont(new Font("Arial", Font.BOLD, 28));
		lblTitle_p2.setForeground(Color.BLACK);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblTitle_p2, 0, SpringLayout.NORTH, lblTitle_p1);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblTitle_p2, 6, SpringLayout.EAST, lblTitle_p1);
		contentPane.add(lblTitle_p2);

		JLabel lblTitle_p3 = new JLabel("Información");
		lblTitle_p3.setFont(new Font("Arial", Font.BOLD, 28));
		lblTitle_p3.setForeground(Color.BLACK);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblTitle_p3, 0, SpringLayout.NORTH, lblTitle_p1);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblTitle_p3, 6, SpringLayout.EAST, lblTitle_p2);
		contentPane.add(lblTitle_p3);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnAcceptFilter, -6, SpringLayout.WEST, horizontalStrut);
		sl_contentPane.putConstraint(SpringLayout.NORTH, horizontalStrut, 0, SpringLayout.NORTH, comboFilter);
		sl_contentPane.putConstraint(SpringLayout.EAST, horizontalStrut, -6, SpringLayout.WEST, btnAddExpense);
		contentPane.add(horizontalStrut);

		comboFilter.setSelectedItem("Todos");
		handleFilterSelection("Todos");
		comboFilter.setSelectedItem("Todos");
		

		setEditingMode(false);
		tglbtnEditCar.setSelected(false);
		tglbtnEditCar.setEnabled(false);
		btnAccept.setVisible(false);
	}

	private void handleFilterSelection(String selectedFilter) {
		if (selectedFilter.equals("Todos")) {
			textMinimum.setVisible(false);
			textMaximum.setVisible(false);
			lblMin.setVisible(false);
			lblMax.setVisible(false);
			btnAcceptFilter.setVisible(false);
			textMinimum.setText("");
			textMaximum.setText("");
			CarResponseDto selectedCar = (CarResponseDto) comboSelectCar.getSelectedItem();
			requestExpenseList(selectedCar, selectedFilter, textMinimum.getText(), textMaximum.getText());
		} else {
			textMinimum.setVisible(true);
			textMaximum.setVisible(true);
			lblMin.setVisible(true);
			lblMax.setVisible(true);
			btnAcceptFilter.setVisible(true);
		}
	}

	private void setEditingMode(boolean isEditing) {
		textBrand.setEditable(isEditing);
		textModel.setEditable(isEditing);
		textPlate.setEditable(isEditing);
		textYear.setEditable(isEditing);
		btnAccept.setVisible(isEditing);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == comboSelectCar) {
			if (comboSelectCar.getSelectedItem() != null) {
				tglbtnEditCar.setEnabled(true);
				btnDeleteCar.setEnabled(true);
				btnAddExpense.setEnabled(true);
				this.selectedCar = (CarResponseDto) comboSelectCar.getSelectedItem();
				textBrand.setText(selectedCar.getBrand());
				textModel.setText(selectedCar.getModel());
				textPlate.setText(selectedCar.getPlate());
				textYear.setText(Integer.toString(selectedCar.getYear()));

				setEditingMode(false);
				tglbtnEditCar.setSelected(false);
				requestExpenseList(selectedCar, "Todos", "", "");

			} else {
				tglbtnEditCar.setEnabled(false);
				btnDeleteCar.setEnabled(false);
				btnAddExpense.setEnabled(false);
				clearCarTextFields();
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				setEditingMode(false);
				tglbtnEditCar.setSelected(false);
			}
		}

		if (e.getSource() == comboFilter) {
			String selectedFilter = (String) comboFilter.getSelectedItem();
			handleFilterSelection(selectedFilter);
		}

		if (e.getSource() == btnAcceptFilter) {
			String selectedFilter = (String) comboFilter.getSelectedItem();
			CarResponseDto selectedCar = (CarResponseDto) comboSelectCar.getSelectedItem();
			requestExpenseList(selectedCar, selectedFilter, textMinimum.getText(), textMaximum.getText());
		}

		if (e.getSource() == btnDeleteCar) {
			CarResponseDto selectedCar = (CarResponseDto) comboSelectCar.getSelectedItem();
			if (selectedCar != null && mainController.deleteCar(selectedCar, userName)) {
				viewShow();
			} else {
				System.out.println("Coche NO eliminado");
			}
		}

		if (e.getSource() == tglbtnEditCar) {
			boolean isEditing = tglbtnEditCar.isSelected();
			setEditingMode(isEditing);
		}

		if (e.getSource() == btnAccept) {
			String oldPlate = textPlate.getText();
			try {
				CarResponseDto editedCar = new CarResponseDto(textBrand.getText(), textModel.getText(),
						textPlate.getText(), Integer.parseInt(textYear.getText()));

				if (mainController.editCar(editedCar, oldPlate)) {
					mainView.updateList(userName);
					viewShow();
				} else {
					System.out.println("Coche no editado");
				}
				setEditingMode(false);
				tglbtnEditCar.setSelected(false);
			} catch (NumberFormatException i) {
				System.out.println("Algo salió mal");
			}
		}

		if (e.getSource() == btnExit) {
			mainView.updateList(userName);
			mainView.setVisible(true);
			this.dispose();
		}

		if (e.getSource() == btnAddExpense) {
			CarResponseDto selectedCar = (CarResponseDto) comboSelectCar.getSelectedItem();
			try {
				this.expenseView = new ExpenseView(selectedCar.getPlate());
			} catch (ClassNotFoundException | IOException | SQLException e1) {
				e1.printStackTrace();
			}
			expenseView.viewShow();

		}
	}

	private void clearCarTextFields() {
		textBrand.setText("");
		textModel.setText("");
		textPlate.setText("");
		textYear.setText("");
	}

	public void requestCarList(String userName) {
		List<CarResponseDto> carResponseDto = mainController.requestCarList(userName);
		comboSelectCar.removeAllItems();
		for (CarResponseDto car : carResponseDto) {
			comboSelectCar.addItem(car);
		}

		if (comboSelectCar.getItemCount() == 0) {
			tglbtnEditCar.setEnabled(false);
			btnDeleteCar.setEnabled(false);
			btnAddExpense.setEnabled(false);
		} else {
			tglbtnEditCar.setEnabled(true);
			btnDeleteCar.setEnabled(true);
			btnAddExpense.setEnabled(true);
		}
	}

	public void requestExpenseList(CarResponseDto selectedCar, String selectedFilter, String textMin, String textMax) {
		if (selectedCar != null) {
			List<ExpenseDto> expenseList = mainController.requestExpenses(selectedCar, selectedFilter, textMin, textMax);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			for (ExpenseDto expense : expenseList) {
				model.addRow(new Object[] { expense.getExpenseType(), expense.getMileage() + " km", expense.getDate(),
						expense.getAmount() + "€", expense.getDescription() });
			}
		}
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void viewShow() {
		requestCarList(this.userName);
		requestExpenseList(this.selectedCar, "Todos", "", "");
		this.setVisible(true);
	}
}

