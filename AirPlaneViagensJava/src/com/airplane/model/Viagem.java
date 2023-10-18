package com.airplane.model;

import java.time.LocalDateTime;

public class Viagem {

	private int idViagem;
	private LocalDateTime dataViagem;
	private LocalDateTime horaPartida;
	private String origem;
	private String destino;
	
	
	public int getIdViagem() {
		return idViagem;
	}
	public void setIdViagem(int idViagem) {
		this.idViagem = idViagem;
	}
	public LocalDateTime getDataViagem() {
		return dataViagem;
	}
	public void setDataViagem(LocalDateTime dataViagem) {
		this.dataViagem = dataViagem;
	}
	public LocalDateTime getHoraPartida() {
		return horaPartida;
	}
	public void setHoraPartida(LocalDateTime horaPartida) {
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

	
}
