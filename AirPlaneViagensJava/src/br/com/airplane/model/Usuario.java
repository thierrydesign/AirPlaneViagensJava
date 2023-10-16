package br.com.airplane.model;

import java.util.List;

public class Usuario {
	
	private int id;
	private String login;
	private String nome;
	private String senha;


	public Usuario(int id, String login, String nome, String senha) {
		super();
		this.id = id;
		this.login = login;
		this.nome = nome;
		this.senha = senha;
	}
	
	
	public Usuario() {
		
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}


	public void add(List<Usuario> usuario) {
		
		
	}
	
	

}
