package br.com.airplane.model;

import java.util.Date;
import java.util.List;

public class Viagem {

	private int id;
	private Date dataViagem;
	private Date horaPartida;
	private String origem;
	private String destino;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDataViagem() {
		return dataViagem;
	}
	public void setDataViagem(Date dataViagem) {
		this.dataViagem = dataViagem;
	}
	public Date getHoraPartida() {
		return horaPartida;
	}
	public void setHoraPartida(Date horaPartida) {
		this.horaPartida = horaPartida;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public void add(List<Viagem> viagens) {
		
		
	}
	
	
	
}
