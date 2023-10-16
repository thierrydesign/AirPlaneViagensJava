package br.com.airplane.model;

import java.util.List;

public class Passageiro {

	private int id;
	private String cpf;
	private String nome;
	private String rg;
	private String telefone;

	public Passageiro(int id, String cpf, String nome, String rg, String telefone) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.rg = rg;
		this.telefone = telefone;
	}
	
	public Passageiro() {
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void add(List<Passageiro> passageiro) {
	
		
	}
	
	
	
	
}
