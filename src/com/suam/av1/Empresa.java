package com.suam.av1;

import java.util.ArrayList;

public class Empresa {
	public String nome;
	public String cnpj;
	ArrayList<Funcionario> ListaFunc;
	ArrayList<Cliente> ListaCli;
	
	public Empresa() {
		ListaFunc = new ArrayList();
		ListaCli = new ArrayList();
		
	}
	public Empresa(String nome,String cnpj) {
		this.nome = nome;
		this.cnpj = cnpj;
		ListaFunc = new ArrayList();
		ListaCli = new ArrayList();
	}
	public ArrayList<Funcionario> getListaFunc() {
		return ListaFunc;
	}
	public void setListaFunc(ArrayList<Funcionario> listaFunc) {
		ListaFunc = listaFunc;
	}
	public ArrayList<Cliente> getListaCli() {
		return ListaCli;
	}
	public void setListaCli(ArrayList<Cliente> listaCli) {
		ListaCli = listaCli;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public void addFunc(Funcionario F) {
		F.setEmp(this);
		ListaFunc.add(F);
	}
	public void addCli(Cliente C) {
		C.setEmp(this);
		ListaCli.add(C);
	}
}
