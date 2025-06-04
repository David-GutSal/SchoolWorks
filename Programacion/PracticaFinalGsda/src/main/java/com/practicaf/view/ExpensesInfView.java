package com.practicaf.view;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import com.practicaf.controller.IMainController;
import com.practicaf.controller.MainController;
import com.practicaf.model.dto.CarResponseDto;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JToggleButton;

public class ExpensesInfView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private IMainController mainController;
	private String userName;
	private JTable table;
	private JTextField textBrand;
	private JTextField textModel;
	private JTextField textPlate;
	private JTextField textYear;
	private JComboBox<CarResponseDto> comboSelectCar;
	private JButton btnDeleteCar;
	private JButton btnAddExpense;
	private JButton btnExit;
	private JButton btnAccept;
	private JToggleButton tglbtnEditCar;
	private JScrollPane scrollPane;
	private JComboBox<String> comboSort;
	private MainView mainView;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * 
	 * @param mainView
	 * @param carView
	 * 
	 * @throws IOException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ExpensesInfView(MainView mainView) throws ClassNotFoundException, SQLException, IOException {
		setResizable(false);
		this.mainController = new MainController();
		this.mainView = mainView;

		comboSelectCar = new JComboBox();
		comboSort = new JComboBox();
		btnDeleteCar = new JButton("Eliminar");
		btnExit = new JButton("Salir");
		tglbtnEditCar = new JToggleButton("Editar");
		btnAccept = new JButton("Guardar Cambios");
		btnAddExpense = new JButton("Agregar Gasto");
		table = new JTable();

		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "TipoDeGasto", "Kilometraje", "Fecha",
				"Importe", "Descripci\u00F3n(masx: 55 car\u00E1cteres)" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, Object.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
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

		setTitle("Expenses&Information");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 755, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		sl_contentPane.putConstraint(SpringLayout.NORTH, comboSelectCar, 46, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, comboSelectCar, 15, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, comboSelectCar, -73, SpringLayout.WEST, btnDeleteCar);
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane, 240, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane, -9, SpringLayout.NORTH, btnExit);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnExit, 330, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnExit, 0, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnAddExpense, -11, SpringLayout.NORTH, scrollPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnAddExpense, 0, SpringLayout.EAST, scrollPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane, 340, SpringLayout.EAST, btnDeleteCar);
		contentPane.setLayout(sl_contentPane);

		comboSelectCar.setToolTipText("Seleccione un coche");
		comboSelectCar.addActionListener(this);
		btnDeleteCar.addActionListener(this);
		btnExit.addActionListener(this);
		tglbtnEditCar.addActionListener(this);
		btnAccept.addActionListener(this);
		btnAddExpense.addActionListener(this);

		sl_contentPane.putConstraint(SpringLayout.NORTH, btnDeleteCar, 46, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnDeleteCar, 300, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, table, 11, SpringLayout.SOUTH, btnAddExpense);

		sl_contentPane.putConstraint(SpringLayout.WEST, table, 5, SpringLayout.WEST, comboSelectCar);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, table, -32, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, table, 0, SpringLayout.EAST, btnDeleteCar);

		textBrand = new JTextField();
		textBrand.setEditable(false);
		sl_contentPane.putConstraint(SpringLayout.NORTH, textBrand, 22, SpringLayout.SOUTH, comboSelectCar);
		sl_contentPane.putConstraint(SpringLayout.EAST, textBrand, 0, SpringLayout.EAST, comboSelectCar);
		contentPane.add(textBrand);
		textBrand.setColumns(10);

		textModel = new JTextField();
		textModel.setEditable(false);
		sl_contentPane.putConstraint(SpringLayout.NORTH, textModel, 6, SpringLayout.SOUTH, textBrand);
		sl_contentPane.putConstraint(SpringLayout.EAST, textModel, 0, SpringLayout.EAST, comboSelectCar);
		contentPane.add(textModel);
		textModel.setColumns(10);

		textPlate = new JTextField();
		textPlate.setEditable(false);
		sl_contentPane.putConstraint(SpringLayout.NORTH, textPlate, 6, SpringLayout.SOUTH, textModel);
		sl_contentPane.putConstraint(SpringLayout.EAST, textPlate, 0, SpringLayout.EAST, comboSelectCar);
		contentPane.add(textPlate);
		textPlate.setColumns(10);

		textYear = new JTextField();
		textYear.setEditable(false);
		sl_contentPane.putConstraint(SpringLayout.NORTH, textYear, 6, SpringLayout.SOUTH, textPlate);
		sl_contentPane.putConstraint(SpringLayout.EAST, textYear, 0, SpringLayout.EAST, comboSelectCar);
		contentPane.add(textYear);
		textYear.setColumns(10);

		JLabel lblBrand = new JLabel("Marca:");
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, lblBrand);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblBrand, 0, SpringLayout.NORTH, textBrand);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblBrand, 0, SpringLayout.WEST, comboSelectCar);
		contentPane.add(lblBrand);

		JLabel lblModel = new JLabel("Modelo:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblModel, 0, SpringLayout.NORTH, textModel);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblModel, 0, SpringLayout.WEST, comboSelectCar);
		contentPane.add(lblModel);

		JLabel lblPlate = new JLabel("Matrícula:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblPlate, 0, SpringLayout.NORTH, textPlate);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblPlate, 0, SpringLayout.WEST, comboSelectCar);
		contentPane.add(lblPlate);

		JLabel lblYear = new JLabel("Año:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblYear, 0, SpringLayout.NORTH, textYear);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblYear, 0, SpringLayout.WEST, comboSelectCar);
		contentPane.add(lblYear);

		JLabel lblTitle = new JLabel("Gastos & Información");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblTitle, -6, SpringLayout.NORTH, btnDeleteCar);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblTitle, -216, SpringLayout.EAST, contentPane);
		lblTitle.setFont(new Font("Arial", Font.PLAIN, 25));

		sl_contentPane.putConstraint(SpringLayout.NORTH, comboSort, 1, SpringLayout.NORTH, btnAddExpense);
		sl_contentPane.putConstraint(SpringLayout.EAST, comboSort, 253, SpringLayout.WEST, contentPane);
		comboSort.setModel(new DefaultComboBoxModel<String>(new String[] { "Todos", "Fecha", "Kilometraje" }));

		JLabel lblSort = new JLabel("Ordenar por:");
		sl_contentPane.putConstraint(SpringLayout.WEST, comboSort, 6, SpringLayout.EAST, lblSort);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblSort, 0, SpringLayout.WEST, lblBrand);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblSort, -16, SpringLayout.NORTH, scrollPane);

		sl_contentPane.putConstraint(SpringLayout.NORTH, btnAccept, -1, SpringLayout.NORTH, textYear);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnAccept, 6, SpringLayout.EAST, textBrand);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnAccept, 0, SpringLayout.EAST, btnDeleteCar);
		btnAccept.setVisible(false);

		sl_contentPane.putConstraint(SpringLayout.NORTH, tglbtnEditCar, 6, SpringLayout.SOUTH, lblTitle);
		sl_contentPane.putConstraint(SpringLayout.WEST, tglbtnEditCar, 6, SpringLayout.EAST, comboSelectCar);

		contentPane.add(lblTitle);
		contentPane.add(comboSelectCar);
		contentPane.add(btnDeleteCar);
		contentPane.add(btnExit);
		contentPane.add(btnAddExpense);
		contentPane.add(scrollPane);
		contentPane.add(comboSort);
		contentPane.add(lblSort);
		contentPane.add(tglbtnEditCar);
		contentPane.add(btnAccept);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == comboSelectCar) {
			System.out.println("Evento de JComboBox disparado");

			if (comboSelectCar.getSelectedItem() != null) {
				tglbtnEditCar.setEnabled(true);
				btnDeleteCar.setEnabled(true);
				btnAddExpense.setEnabled(true);
				CarResponseDto selectedCar = (CarResponseDto) comboSelectCar.getSelectedItem();
				textBrand.setText(selectedCar.getBrand());
				textModel.setText(selectedCar.getModel());
				textPlate.setText(selectedCar.getPlate());
				textYear.setText(Integer.toString(selectedCar.getYear()));
			} else {
				tglbtnEditCar.setEnabled(false);
				btnDeleteCar.setEnabled(false);
				btnAddExpense.setEnabled(false);
			}
		}

		if (e.getSource() == btnDeleteCar) {
			System.out.println("Borrar coche de propietario");
			CarResponseDto selectedCar = (CarResponseDto) comboSelectCar.getSelectedItem();
			if (selectedCar != null && mainController.deleteCar(selectedCar, userName)) {
				System.out.println("Coche eliminado");
				viewShow();
			} else {
				System.out.println("Coche NO eliminado");
			}
		}

		if (e.getSource() == tglbtnEditCar) {

			boolean isEditing = tglbtnEditCar.isSelected();
			textBrand.setEditable(isEditing);
			textModel.setEditable(isEditing);
			textPlate.setEditable(isEditing);
			textYear.setEditable(isEditing);

			if (isEditing) {
				btnAccept.setVisible(true);
			} else {
				btnAccept.setVisible(false);
			}
		}

		if (e.getSource() == btnAccept) {
			String oldPlate = textPlate.getText();
			try {
				CarResponseDto editedCar = new CarResponseDto(textBrand.getText(), textModel.getText(),
						textPlate.getText(), Integer.parseInt(textYear.getText()));

				if (mainController.editCar(editedCar, oldPlate)) {
					System.out.println("Coche editado");
					mainView.updateList(userName);
					viewShow();
				} else {
					System.out.println("Coche no editado");
				}
				textBrand.setEditable(false);
				textModel.setEditable(false);
				textPlate.setEditable(false);
				textYear.setEditable(false);
				btnAccept.setVisible(false);
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
			System.out.println("Añadir gasto");

			String tipoDeGasto = "Ejemplo";
			String kilometraje = "1000";
			String fecha = "2023-10-01";
			String importe = "150";
			String descripcion = "ereeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee";

			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.addRow(new Object[] { tipoDeGasto, kilometraje, fecha, importe, descripcion });
		}
	}

	public void requestList(String userName) {
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

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void viewShow() {
		requestList(this.userName);
		this.setVisible(true);
	}
}
