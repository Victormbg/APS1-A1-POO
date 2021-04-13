package com.suam.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JDesktopPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.suam.av1.Empresa;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrincipalView extends JFrame {
	ArrayList<Empresa> ListaEmp;

	public void LoadTableEmp() {
		DefaultTableModel modelo = new DefaultTableModel(new Object[] { "Nome", "cnpj" }, 0);
		tbl_emp.setModel(modelo);

		for (int i = 0; i < ListaEmp.size(); i++) {
			Object linha[] = new Object[] { ListaEmp.get(i).getNome(), ListaEmp.get(i).getCnpj() };
			modelo.addRow(linha);
		}
	}

	private JPanel contentPane;
	private JTable tbl_emp;
	private JTextField c_emp_nome;
	private JTextField c_emp_cnpj;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalView frame = new PrincipalView();
					frame.setVisible(true);
					frame.setIconImage(Toolkit.getDefaultToolkit().getImage("img\\iconeVictor.png"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public PrincipalView() {
		ListaEmp = new ArrayList();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 408, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setToolTipText("");
		tabbedPane.setBounds(0, 0, 392, 321);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Empresa", null, panel, null);

		tbl_emp = new JTable();
		tbl_emp.setCellSelectionEnabled(true);
		tbl_emp.setEnabled(false);
		tbl_emp.setShowVerticalLines(false);
		tbl_emp.setShowHorizontalLines(false);
		tbl_emp.setShowGrid(false);
		tbl_emp.setBounds(10, 40, 367, 78);
		tbl_emp.setBorder(
				new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.DARK_GRAY, Color.BLACK, Color.DARK_GRAY));
		tbl_emp.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		tbl_emp.setForeground(new Color(255, 255, 255));
		tbl_emp.setBackground(new Color(0, 0, 0));
		tbl_emp.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "Cnpj" }) {
			boolean[] columnEditables = new boolean[] { false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tbl_emp.getColumnModel().getColumn(0).setResizable(false);
		tbl_emp.getColumnModel().getColumn(0).setPreferredWidth(120);
		tbl_emp.getColumnModel().getColumn(1).setResizable(false);
		tbl_emp.getColumnModel().getColumn(1).setPreferredWidth(120);
		panel.setLayout(null);
		panel.add(tbl_emp);

		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(20, 15, 46, 14);
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		lblNewLabel.setForeground(Color.WHITE);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Cnpj");
		lblNewLabel_1.setBounds(207, 15, 39, 14);
		lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		lblNewLabel_1.setForeground(Color.WHITE);
		panel.add(lblNewLabel_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 0, 0));
		panel_3.setBounds(10, 159, 367, 123);
		panel_3.setBorder(new TitledBorder(
				new BevelBorder(BevelBorder.LOWERED, new Color(64, 64, 64), new Color(192, 192, 192),
						new Color(128, 128, 128), new Color(128, 128, 128)),
				"Empresa", TitledBorder.LEFT, TitledBorder.TOP, null, Color.WHITE));
		panel_3.setToolTipText("Dados");
		panel.add(panel_3);
		panel_3.setLayout(null);
		panel_3.setOpaque(false);

		JButton btn_emp_salvar = new JButton("Salvar");
		btn_emp_salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Empresa E = new Empresa(c_emp_nome.getText(), c_emp_cnpj.getText());
				ListaEmp.add(E);
				LoadTableEmp();
			}
		});
		btn_emp_salvar.setForeground(Color.WHITE);
		btn_emp_salvar.setBackground(new Color(0, 128, 0));
		btn_emp_salvar.setBounds(87, 91, 111, 23);
		panel_3.add(btn_emp_salvar);

		JLabel lblNewLabel_4 = new JLabel("Nome:");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(10, 29, 43, 14);
		panel_3.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Cnpj:");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(10, 62, 43, 14);
		panel_3.add(lblNewLabel_5);

		c_emp_nome = new JTextField();
		c_emp_nome.setBounds(58, 27, 299, 20);
		panel_3.add(c_emp_nome);
		c_emp_nome.setColumns(10);

		c_emp_cnpj = new JTextField();
		c_emp_cnpj.setBounds(58, 60, 299, 20);
		panel_3.add(c_emp_cnpj);
		c_emp_cnpj.setColumns(10);

		JButton btn_emp_cancelar = new JButton("Cancelar");
		btn_emp_cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_emp_salvar.setEnabled(false);
				btn_emp_cancelar.setEnabled(false);
				c_emp_nome.setEnabled(false);
				c_emp_cnpj.setEnabled(false);
			}
		});
		btn_emp_cancelar.setBackground(new Color(255, 0, 0));
		btn_emp_cancelar.setForeground(Color.WHITE);
		btn_emp_cancelar.setBounds(210, 91, 111, 23);
		panel_3.add(btn_emp_cancelar);

		JButton btn_emp_editar = new JButton("Editar");
		btn_emp_editar.setBounds(138, 129, 108, 23);
		panel.add(btn_emp_editar);
		btn_emp_editar.setForeground(Color.WHITE);
		btn_emp_editar.setBackground(new Color(128, 128, 0));

		JButton btn_emp_novo = new JButton("Novo");
		btn_emp_novo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c_emp_nome.setText("");
				c_emp_cnpj.setText("");

				btn_emp_salvar.setEnabled(true);
				btn_emp_cancelar.setEnabled(true);
				c_emp_nome.setEnabled(true);
				c_emp_cnpj.setEnabled(true);
			}
		});
		btn_emp_salvar.setEnabled(false);
		btn_emp_cancelar.setEnabled(false);
		c_emp_nome.setEnabled(false);
		c_emp_cnpj.setEnabled(false);
		btn_emp_novo.setBounds(20, 129, 108, 23);
		panel.add(btn_emp_novo);
		btn_emp_novo.setForeground(Color.WHITE);
		btn_emp_novo.setBackground(new Color(0, 128, 128));

		JButton btn_emp_excluir = new JButton("Excluir");
		btn_emp_excluir.setBounds(256, 129, 109, 23);
		panel.add(btn_emp_excluir);
		btn_emp_excluir.setForeground(Color.WHITE);
		btn_emp_excluir.setBackground(new Color(128, 0, 0));

		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon("img\\oi.jpg"));
		lblNewLabel_6.setBounds(-13, -10, 400, 303);
		panel.add(lblNewLabel_6);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Funcionario", null, panel_1, null);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Cliente", null, panel_2, null);
		panel_2.setLayout(null);
	}
}