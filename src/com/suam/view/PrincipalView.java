package com.suam.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.suam.av1.Cliente;
import com.suam.av1.Empresa;
import com.suam.av1.Funcionario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.sound.sampled.Line;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("unchecked")
public class PrincipalView extends JFrame {
	ArrayList<Empresa> ListaEmp;
	ArrayList<Funcionario> ListaFunc;
	ArrayList<Cliente> ListaCli;
	String modoEmp = new String();
	String modoFunc = new String();
	
	
	public void LoadTableEmp() {
		DefaultTableModel modelo = new DefaultTableModel(new Object[] { "Nome", "cnpj" }, 0);
		tbl_emp.setModel(modelo);

		for (int i = 0; i < ListaEmp.size(); i++) {
			Object linha[] = new Object[] { ListaEmp.get(i).getNome(), ListaEmp.get(i).getCnpj() };
			modelo.addRow(linha);
			
			
		}
		
		LoadCbEmp();
		LoadCbCli();
	}
	
	public void LoadTableFunc() {
		DefaultTableModel modelo = new DefaultTableModel(new Object[] { "Nome", "Idade","Empresa" }, 0);
		tbl_func.setModel(modelo);

		for (int i = 0; i < ListaFunc.size(); i++) {
			Object linha[] = new Object[] { ListaFunc.get(i).getNome(),
											ListaFunc.get(i).getIdade(),
											ListaFunc.get(i).getEmp().getNome()};
			modelo.addRow(linha);
		}
	}

	public void LoadTableCli() {
		DefaultTableModel modelo = new DefaultTableModel(new Object[] { "Nome", "Idade","Empresa" }, 0);
		tbl_cli.setModel(modelo);

		for (int i = 0; i < ListaCli.size(); i++) {
			Object linha[] = new Object[] { ListaCli.get(i).getNome(),
											ListaCli.get(i).getIdade(),
											ListaCli.get(i).getEmp().getNome()};
			modelo.addRow(linha);
		}
	}
	
	public void LoadCbEmp() {
		cb_func_emp.removeAllItems();
		cb_func_emp.addItem("Selecione");
		
		for (int i = 0; i < ListaEmp.size(); i++) {
			cb_func_emp.addItem(ListaEmp.get(i).getNome());
			cb_cli_emp.addItem(ListaEmp.get(i).getNome());
		}
	}
	
	public void LoadCbCli() {
		cb_cli_emp.removeAllItems();
		cb_cli_emp.addItem("Selecione");
		
		for (int i = 0; i < ListaEmp.size(); i++) {
			cb_cli_emp.addItem(ListaEmp.get(i).getNome());
		}
	}
	

	private JPanel contentPane = new JPanel();
	private JTable tbl_emp = new JTable();;
	private JTextField c_emp_nome = new JTextField();
	private JTextField c_emp_cnpj = new JTextField();
	private JButton btn_emp_salvar = new JButton();
	private JButton btn_emp_cancelar = new JButton();
	private JButton btn_emp_novo = new JButton();
	private JButton btn_emp_editar = new JButton();
	private JButton btn_emp_excluir = new JButton();
	
	private JTable tbl_func = new JTable();;
	private JTextField  c_func_nome = new JTextField();
	private JTextField c_func_idade = new JTextField();
	private JButton btn_func_salvar = new JButton();
	private JButton btn_func_cancelar = new JButton();
	private JButton btn_func_novo = new JButton();
	private JButton btn_func_editar = new JButton();
	private JButton btn_func_excluir = new JButton();
	private JComboBox cb_func_emp= new JComboBox();
	
	private JTable tbl_cli = new JTable();;
	private JTextField  c_cli_nome = new JTextField();
	private JTextField c_cli_idade = new JTextField();
	private JButton btn_cli_salvar = new JButton();
	private JButton btn_cli_cancelar = new JButton();
	private JButton btn_cli_novo = new JButton();
	private JButton btn_cli_editar = new JButton();
	private JButton btn_cli_excluir = new JButton();
	private JComboBox cb_cli_emp = new JComboBox();	

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
		ListaFunc = new ArrayList();
		ListaCli = new ArrayList();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 408, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setToolTipText("");
		tabbedPane.setBounds(0, 0, 392, 344);
		contentPane.add(tabbedPane);

		JPanel Empresa_tblEmpresa = new JPanel();
		tabbedPane.addTab("Empresa", null, Empresa_tblEmpresa, null);

		tbl_emp = new JTable();
		tbl_emp.setColumnSelectionAllowed(true);
		tbl_emp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = tbl_emp.getSelectedRow();
				if(index>=0 && index<ListaEmp.size()) {
					Empresa E = ListaEmp.get(index);
					c_emp_nome.setText(E.getNome());
					c_emp_cnpj.setText(E.cnpj);
				}
			}
		});
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
		Empresa_tblEmpresa.setLayout(null);
		Empresa_tblEmpresa.add(tbl_emp);

		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(20, 15, 46, 14);
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		lblNewLabel.setForeground(Color.WHITE);
		Empresa_tblEmpresa.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Cnpj");
		lblNewLabel_1.setBounds(207, 15, 39, 14);
		lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		lblNewLabel_1.setForeground(Color.WHITE);
		Empresa_tblEmpresa.add(lblNewLabel_1);

		JPanel DadosEmpresa = new JPanel();
		DadosEmpresa.setBackground(new Color(255, 0, 0));
		DadosEmpresa.setBounds(10, 159, 367, 123);
		DadosEmpresa.setBorder(new TitledBorder(
				new BevelBorder(BevelBorder.LOWERED, new Color(64, 64, 64), new Color(192, 192, 192),
						new Color(128, 128, 128), new Color(128, 128, 128)),
				"Empresa", TitledBorder.LEFT, TitledBorder.TOP, null, Color.WHITE));
		DadosEmpresa.setToolTipText("Dados");
		Empresa_tblEmpresa.add(DadosEmpresa);
		DadosEmpresa.setLayout(null);
		DadosEmpresa.setOpaque(false);

		JButton btn_emp_salvar = new JButton("Salvar");
		btn_emp_salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(modoEmp.equals("Novo")) {
					
				int index = tbl_emp.getRowCount();
				
				if(index == 1) {
					JOptionPane.showConfirmDialog(null,
							"Já possui empresa cadastrada",
			                "Erro",
			                JOptionPane.DEFAULT_OPTION,
			                JOptionPane.PLAIN_MESSAGE);
				}
				else
				{
					Empresa E = new Empresa(c_emp_nome.getText(), c_emp_cnpj.getText());
					ListaEmp.add(E);
					
					JOptionPane.showConfirmDialog(null,
							"Empresa cadastrada com sucesso",
			                "Sucesso",
			                JOptionPane.DEFAULT_OPTION,
			                JOptionPane.PLAIN_MESSAGE);
					
				
				}
				ativarBotaoS();
				}
				if(modoEmp.equals("Editar")){
					int index = tbl_emp.getSelectedRow();
					ListaEmp.get(index).setNome(c_emp_nome.getText());
					ListaEmp.get(index).setCnpj(c_emp_cnpj.getText());
					
					JOptionPane.showConfirmDialog(null,
							"Empresa editada com sucesso",
			                "Sucesso",
			                JOptionPane.DEFAULT_OPTION,
			                JOptionPane.PLAIN_MESSAGE);
				}
				LoadTableEmp();
				c_emp_cnpj.setText("");
				c_emp_nome.setText("");
				
			}
		});
		btn_emp_salvar.setForeground(Color.WHITE);
		btn_emp_salvar.setBackground(new Color(0, 128, 0));
		btn_emp_salvar.setBounds(87, 91, 111, 23);
		DadosEmpresa.add(btn_emp_salvar);

		JLabel lblNewLabel_4 = new JLabel("Nome:");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(10, 29, 43, 14);
		DadosEmpresa.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Cnpj:");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(10, 62, 43, 14);
		DadosEmpresa.add(lblNewLabel_5);

		c_emp_nome = new JTextField();
		c_emp_nome.setBounds(58, 27, 299, 20);
		DadosEmpresa.add(c_emp_nome);
		c_emp_nome.setColumns(10);

		c_emp_cnpj = new JTextField();
		c_emp_cnpj.setBounds(58, 60, 299, 20);
		DadosEmpresa.add(c_emp_cnpj);
		c_emp_cnpj.setColumns(10);

		JButton btn_emp_cancelar = new JButton("Cancelar");
		btn_emp_cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c_emp_cnpj.setText("");
				c_emp_nome.setText("");	
				modoEmp = "Cancelar";
				ativarBotaoC();
			}
		});
		btn_emp_cancelar.setBackground(new Color(255, 0, 0));
		btn_emp_cancelar.setForeground(Color.WHITE);
		btn_emp_cancelar.setBounds(210, 91, 111, 23);
		DadosEmpresa.add(btn_emp_cancelar);

		JButton btn_emp_editar = new JButton("Editar");
		btn_emp_editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modoEmp = "Editar";
				ativarBotaoE();
			}
		});
		btn_emp_editar.setBounds(138, 129, 108, 23);
		Empresa_tblEmpresa.add(btn_emp_editar);
		btn_emp_editar.setForeground(Color.WHITE);
		btn_emp_editar.setBackground(new Color(128, 128, 0));

		JButton btn_emp_novo = new JButton("Novo");
		btn_emp_novo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modoEmp = "Novo";
				c_emp_cnpj.setText("");
				c_emp_nome.setText("");
				ativarBotaoN();
			}
		});
		btn_emp_novo.setBounds(20, 129, 108, 23);
		Empresa_tblEmpresa.add(btn_emp_novo);
		btn_emp_novo.setForeground(Color.WHITE);
		btn_emp_novo.setBackground(new Color(0, 128, 128));

		JButton btn_emp_excluir = new JButton("Excluir");
		btn_emp_excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = tbl_emp.getSelectedRow();
				if(index>=0 && index<ListaEmp.size()) {
					ListaEmp.remove(index);
				}
				LoadTableEmp();
				c_emp_cnpj.setText("");
				c_emp_nome.setText("");
				cb_func_emp.removeAllItems();
				cb_func_emp.addItem(" Não há empresa cadastrada");
				cb_cli_emp.removeAllItems();
				cb_cli_emp.addItem(" Não há empresa cadastrada");
				JOptionPane.showConfirmDialog(null,
						"OPS! Empresa foi excluída",
		                "*o*",
		                JOptionPane.DEFAULT_OPTION,
		                JOptionPane.PLAIN_MESSAGE);
				
			}
		});
		btn_emp_excluir.setBounds(256, 129, 109, 23);
		Empresa_tblEmpresa.add(btn_emp_excluir);
		btn_emp_excluir.setForeground(Color.WHITE);
		btn_emp_excluir.setBackground(new Color(128, 0, 0));

		JLabel fundo = new JLabel("New label");
		fundo.setBackground(Color.BLACK);
		fundo.setIcon(new ImageIcon("img\\oi.jpg"));
		fundo.setBounds(0, 0, 411, 334);
		Empresa_tblEmpresa.add(fundo);

		JPanel Funcionario = new JPanel();
		tabbedPane.addTab("Funcionario", null, Funcionario, null);
		Funcionario.setLayout(null);
		
		JPanel TabFuncionario = new JPanel();
		TabFuncionario.setLayout(null);
		TabFuncionario.setBounds(0, 0, 387, 316);
		Funcionario.add(TabFuncionario);
		
		tbl_func = new JTable();
		tbl_func.setShowGrid(false);
		tbl_func.setShowHorizontalLines(false);
		tbl_func.setShowVerticalLines(false);
		tbl_func.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Idade", "Empresa"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tbl_func.getColumnModel().getColumn(0).setPreferredWidth(120);
		tbl_func.getColumnModel().getColumn(1).setPreferredWidth(46);
		tbl_func.getColumnModel().getColumn(2).setPreferredWidth(120);
		tbl_func.setForeground(Color.WHITE);
		tbl_func.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		tbl_func.setColumnSelectionAllowed(true);
		tbl_func.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.DARK_GRAY, Color.BLACK, Color.DARK_GRAY));
		tbl_func.setBackground(Color.BLACK);
		tbl_func.setBounds(10, 40, 367, 78);
		TabFuncionario.add(tbl_func);
		
		JLabel lblNewLabel_3 = new JLabel("Empresa");
		lblNewLabel_3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(268, 15, 70, 14);
		TabFuncionario.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Nome");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		lblNewLabel_2.setBounds(20, 15, 46, 14);
		TabFuncionario.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Idade");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(183, 15, 39, 14);
		TabFuncionario.add(lblNewLabel_1_1);
		
		JPanel DadosFunc = new JPanel();
		DadosFunc.setLayout(null);
		DadosFunc.setToolTipText("Dados");
		DadosFunc.setOpaque(false);
		DadosFunc.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, new Color(64, 64, 64), new Color(192, 192, 192), new Color(128, 128, 128), new Color(128, 128, 128)), "Dados", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(255, 255, 255)));
		DadosFunc.setBackground(Color.RED);
		DadosFunc.setBounds(10, 159, 367, 147);
		TabFuncionario.add(DadosFunc);
		
		JLabel lblNewLabel_4_1 = new JLabel("Nome:");
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblNewLabel_4_1.setBounds(10, 29, 43, 14);
		DadosFunc.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("Idade:");
		lblNewLabel_5_1.setForeground(Color.WHITE);
		lblNewLabel_5_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblNewLabel_5_1.setBounds(10, 56, 43, 14);
		DadosFunc.add(lblNewLabel_5_1);
		
		c_func_nome = new JTextField();
		c_func_nome.setColumns(10);
		c_func_nome.setBounds(58, 27, 299, 20);
		DadosFunc.add(c_func_nome);
		
		c_func_idade = new JTextField();
		c_func_idade.setColumns(10);
		c_func_idade.setBounds(58, 54, 299, 20);
		DadosFunc.add(c_func_idade);
		
		JButton btn_func_salvar = new JButton("Salvar");
		btn_func_salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = cb_func_emp.getSelectedIndex();
				if(index==0) {
					JOptionPane.showConfirmDialog(null,
							"Voce deve selecionar uma empresa",
			                "Erro",
			                JOptionPane.DEFAULT_OPTION,
			                JOptionPane.PLAIN_MESSAGE);
				}else {
					Funcionario F = new Funcionario();
					F.setIdade(Integer.parseInt(c_func_idade.getText()));
					F.setNome(c_func_nome.getText());
					F.setEmp(ListaEmp.get(index-1));
					ListaFunc.add(F);
					ListaEmp.get(index-1).addFunc(F);
					
					JOptionPane.showConfirmDialog(null,
							"Funcionário cadastrado com sucesso",
			                "Sucesso",
			                JOptionPane.DEFAULT_OPTION,
			                JOptionPane.PLAIN_MESSAGE);
					
				}
				LoadTableFunc();
				c_func_idade.setText("");
				c_func_nome.setText("");
				cb_func_emp.setSelectedIndex(0);
				
			}
		});

		btn_func_salvar.setBounds(86, 113, 111, 23);
		DadosFunc.add(btn_func_salvar);
		btn_func_salvar.setForeground(Color.WHITE);
		btn_func_salvar.setBackground(new Color(0, 128, 0));
		
		btn_func_cancelar = new JButton("Cancelar");
		btn_func_cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_func_cancelar.setBounds(207, 113, 111, 23);
		DadosFunc.add(btn_func_cancelar);
		btn_func_cancelar.setForeground(Color.WHITE);
		btn_func_cancelar.setBackground(Color.RED);
		
		JLabel lblNewLabel_6 = new JLabel("Empresa");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(10, 87, 64, 14);
		DadosFunc.add(lblNewLabel_6);
		
		cb_func_emp = new JComboBox();
		cb_func_emp.setForeground(new Color(255, 255, 255));
		cb_func_emp.setBackground(new Color(0, 0, 0));
		cb_func_emp.setModel(new DefaultComboBoxModel(new String[] {"  Nao há empresa cadastrada"}));
		cb_func_emp.setBounds(68, 84, 289, 22);
		DadosFunc.add(cb_func_emp);
		
		JButton btn_func_editar = new JButton("Editar");
		btn_func_editar.setForeground(Color.WHITE);
		btn_func_editar.setBackground(new Color(128, 128, 0));
		btn_func_editar.setBounds(138, 129, 108, 23);
		TabFuncionario.add(btn_func_editar);
		
		JButton btn_func_novo = new JButton("Novo");
		btn_func_novo.setForeground(Color.WHITE);
		btn_func_novo.setBackground(new Color(0, 128, 128));
		btn_func_novo.setBounds(20, 129, 108, 23);
		TabFuncionario.add(btn_func_novo);
		
		JButton btn_func_excluir = new JButton("Excluir");
		btn_func_excluir.setForeground(Color.WHITE);
		btn_func_excluir.setBackground(new Color(128, 0, 0));
		btn_func_excluir.setBounds(256, 129, 109, 23);
		TabFuncionario.add(btn_func_excluir);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon("img\\oi.jpg"));
		lblNewLabel_7.setBounds(-16, -13, 413, 350);
		TabFuncionario.add(lblNewLabel_7);

		JPanel Cliente = new JPanel();
		tabbedPane.addTab("Cliente", null, Cliente, null);
		Cliente.setLayout(null);
		
		JPanel TabCliente = new JPanel();
		TabCliente.setLayout(null);
		TabCliente.setBounds(0, 0, 387, 316);
		Cliente.add(TabCliente);
		
		tbl_cli = new JTable();
		tbl_cli.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Idade", "Empresa"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tbl_cli.getColumnModel().getColumn(0).setPreferredWidth(120);
		tbl_cli.getColumnModel().getColumn(1).setPreferredWidth(50);
		tbl_cli.getColumnModel().getColumn(2).setPreferredWidth(120);
		tbl_cli.setShowVerticalLines(false);
		tbl_cli.setShowHorizontalLines(false);
		tbl_cli.setShowGrid(false);
		tbl_cli.setForeground(Color.WHITE);
		tbl_cli.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		tbl_cli.setColumnSelectionAllowed(true);
		tbl_cli.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.DARK_GRAY, Color.BLACK, Color.DARK_GRAY));
		tbl_cli.setBackground(Color.BLACK);
		tbl_cli.setBounds(10, 40, 367, 78);
		TabCliente.add(tbl_cli);
		
		JLabel lblNewLabel_3_1 = new JLabel("Empresa");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblNewLabel_3_1.setBounds(268, 15, 70, 14);
		TabCliente.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Nome");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(20, 15, 46, 14);
		TabCliente.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Idade");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		lblNewLabel_1_1_1.setBounds(183, 15, 39, 14);
		TabCliente.add(lblNewLabel_1_1_1);
		
		JPanel DadosCli = new JPanel();
		DadosCli.setLayout(null);
		DadosCli.setToolTipText("Dados");
		DadosCli.setOpaque(false);
		DadosCli.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, new Color(64, 64, 64), new Color(192, 192, 192), new Color(128, 128, 128), new Color(128, 128, 128)), "Dados", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(255, 255, 255)));
		DadosCli.setBackground(Color.RED);
		DadosCli.setBounds(10, 159, 367, 147);
		TabCliente.add(DadosCli);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Nome:");
		lblNewLabel_4_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblNewLabel_4_1_1.setBounds(10, 29, 43, 14);
		DadosCli.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Idade:");
		lblNewLabel_5_1_1.setForeground(Color.WHITE);
		lblNewLabel_5_1_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblNewLabel_5_1_1.setBounds(10, 56, 43, 14);
		DadosCli.add(lblNewLabel_5_1_1);
		
		c_cli_nome = new JTextField();
		c_cli_nome.setColumns(10);
		c_cli_nome.setBounds(58, 27, 299, 20);
		DadosCli.add(c_cli_nome);
		
		c_cli_idade = new JTextField();
		c_cli_idade.setColumns(10);
		c_cli_idade.setBounds(58, 54, 299, 20);
		DadosCli.add(c_cli_idade);
		
		JButton btn_cli_salvar = new JButton("Salvar");
		btn_cli_salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = cb_cli_emp.getSelectedIndex();
				if(index == 0) {
					JOptionPane.showConfirmDialog(null,
							"Voce deve selecionar uma empresa",
			                "Erro",
			                JOptionPane.DEFAULT_OPTION,
			                JOptionPane.PLAIN_MESSAGE);
				}else {
					Cliente C = new Cliente();
					C.setIdade(Integer.parseInt(c_cli_idade.getText()));
					C.setNome(c_cli_nome.getText());
					C.setEmp(ListaEmp.get(index-1));
					ListaCli.add(C);
					ListaEmp.get(index-1).addCli(C);
					
					JOptionPane.showConfirmDialog(null,
							"Cliente cadastrado com sucesso",
			                "Sucesso",
			                JOptionPane.DEFAULT_OPTION,
			                JOptionPane.PLAIN_MESSAGE);
				}
				LoadTableCli();
				c_cli_idade.setText("");
				c_cli_nome.setText("");
				cb_cli_emp.setSelectedIndex(0);
			}
		});
		btn_cli_salvar.setForeground(Color.WHITE);
		btn_cli_salvar.setBackground(new Color(0, 128, 0));
		btn_cli_salvar.setBounds(86, 113, 111, 23);
		DadosCli.add(btn_cli_salvar);
		
		JButton btn_cli_cancelar = new JButton("Cancelar");
		btn_cli_cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_cli_cancelar.setForeground(Color.WHITE);
		btn_cli_cancelar.setBackground(Color.RED);
		btn_cli_cancelar.setBounds(207, 113, 111, 23);
		DadosCli.add(btn_cli_cancelar);
		
		cb_cli_emp = new JComboBox();
		cb_cli_emp.setModel(new DefaultComboBoxModel(new String[] {"  Nao há empresa cadastrada"}));
		cb_cli_emp.setForeground(Color.WHITE);
		cb_cli_emp.setBackground(Color.BLACK);
		cb_cli_emp.setBounds(68, 84, 289, 22);
		DadosCli.add(cb_cli_emp);
		
		JLabel lblNewLabel_6_1 = new JLabel("Empresa");
		lblNewLabel_6_1.setForeground(Color.WHITE);
		lblNewLabel_6_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblNewLabel_6_1.setBounds(10, 87, 64, 14);
		DadosCli.add(lblNewLabel_6_1);
		
		JButton btn_cli_editar = new JButton("Editar");
		btn_cli_editar.setForeground(Color.WHITE);
		btn_cli_editar.setBackground(new Color(128, 128, 0));
		btn_cli_editar.setBounds(138, 129, 108, 23);
		TabCliente.add(btn_cli_editar);
		
		JButton btn_cli_novo = new JButton("Novo");
		btn_cli_novo.setForeground(Color.WHITE);
		btn_cli_novo.setBackground(new Color(0, 128, 128));
		btn_cli_novo.setBounds(20, 129, 108, 23);
		TabCliente.add(btn_cli_novo);
		
		JButton btn_cli_excluir = new JButton("Excluir");
		btn_cli_excluir.setForeground(Color.WHITE);
		btn_cli_excluir.setBackground(new Color(128, 0, 0));
		btn_cli_excluir.setBounds(256, 129, 109, 23);
		TabCliente.add(btn_cli_excluir);
		
		JLabel lblNewLabel_7_1 = new JLabel("New label");
		lblNewLabel_7_1.setIcon(new ImageIcon("img\\oi.jpg"));
		lblNewLabel_7_1.setBounds(-16, -13, 413, 350);
		TabCliente.add(lblNewLabel_7_1);
		desativarBotao();
		}
	
	private void desativarBotao() {
		c_emp_nome.setEnabled(false);
		c_emp_cnpj.setEnabled(false);
		btn_emp_novo.setEnabled(true);
		btn_emp_salvar.setEnabled(false);
		btn_emp_cancelar.setEnabled(false);
		btn_emp_editar.setEnabled(false);	
		btn_emp_excluir.setEnabled(false);
	}
	private void ativarBotaoN() {
		c_emp_nome.setEnabled(true);
		c_emp_cnpj.setEnabled(true);
		btn_emp_salvar.setEnabled(true);
		btn_emp_cancelar.setEnabled(true);
		btn_emp_editar.setEnabled(true);	
		btn_emp_excluir.setEnabled(true);
		btn_emp_novo.setEnabled(false);
		
	}
	private void ativarBotaoC() {
		btn_emp_salvar.setEnabled(false);
		btn_emp_cancelar.setEnabled(false);
		c_emp_nome.setEnabled(false);
		c_emp_cnpj.setEnabled(false);
		btn_emp_editar.setEnabled(false);	
		btn_emp_excluir.setEnabled(false);
		btn_emp_novo.setEnabled(true);
		
	}
	private void ativarBotaoE() {
		btn_emp_salvar.setEnabled(true);
		btn_emp_cancelar.setEnabled(true);
		c_emp_nome.setEnabled(true);
		c_emp_cnpj.setEnabled(true);
		btn_emp_editar.setEnabled(true);	
		btn_emp_excluir.setEnabled(true);
		btn_emp_novo.setEnabled(false);
		
	}
	private void ativarBotaoS() {
		btn_emp_salvar.setEnabled(false);
		btn_emp_cancelar.setEnabled(false);
		c_emp_nome.setEnabled(false);
		c_emp_cnpj.setEnabled(false);
		btn_emp_editar.setEnabled(true);	
		btn_emp_excluir.setEnabled(true);
		btn_emp_novo.setEnabled(false);
		
	}
	
}