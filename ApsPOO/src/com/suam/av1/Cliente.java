package com.suam.av1;

public class Cliente {
	public String nome;
	public int idade;
	private Empresa Emp;
	
	public Cliente() {
		
	}
	public Cliente(String nome,int idade) {
		this.nome = nome;
		this.idade = idade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public Empresa getEmp() {
		return Emp;
	}
	public void setEmp(Empresa Emp) {
		this.Emp = Emp;
	}
}
