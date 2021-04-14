package com.suam.av1;

import javax.swing.JOptionPane;

public class Principal {
	public static void main(String[] args) {
		Empresa empresa = new Empresa();
		Funcionario funcionario = new Funcionario();
		Cliente cliente = new Cliente();
		String opcao;
		do {
			opcao = JOptionPane.showInputDialog(Menu());
			if (opcao.equals("1")) {
				empresa.nome = JOptionPane.showInputDialog("Digite o nome da empresa: ");
				empresa.cnpj = JOptionPane.showInputDialog("Digite o CNPJ da empresa: ");
			}
			if (opcao.equals("2")) {

			}
			if (opcao.equals("3")) {

			}
		} while (opcao != "1");

		// clube.presidente = presidente;
		// clube.enderecoClube = endereco;
	}

	public static String Menu() {
		String menu = "";
		menu += "=================================" + "\n";
		menu += "1 - Criar empresa" + "\n";
		menu += "2 - Associar cliente à empresa" + "\n";
		menu += "3 - Associar funcionário à empresa" + "\n";
		menu += "4 - Apresentar informacoes da empresa" + "\n";
		menu += "5 - Listar clientes da empresa" + "\n";
		menu += "6 - Listar funcionários da empresa" + "\n";
		menu += "7 - Sair do sistema" + "\n";
		menu += "=================================" + "\n";
		return menu;
	}
}
