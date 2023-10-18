package com.airplane.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.airplane.model.Viagem;

public class ViagemDAO {

	private static String sql;

	private final Connection connection;

	public ViagemDAO(Connection connection) {
		this.connection = connection;
	}

	// CREATE
	public void createViagem(Viagem viagem) {
		sql = "INSERT INTO Viagem (dataViagem,horaPartida,origem,destino) VALUES (?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			
			Timestamp sqlViagem = Timestamp.valueOf(viagem.getDataViagem());
			Timestamp sqlPartida = Timestamp.valueOf(viagem.getHoraPartida());
			stmt.setTimestamp(1, sqlViagem);
			stmt.setTimestamp(2, sqlPartida);
			

			stmt.setString(3, viagem.getOrigem());
			stmt.setString(4, viagem.getDestino());

			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	// READ
	public void readAllViagem() {
		sql = "SELECT * FROM viagem";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet r = stmt.executeQuery();
			while (r.next()) {
				Viagem viagem = new Viagem();

				viagem.setIdViagem(r.getInt("idViagem"));
				viagem.setDataViagem(r.getTimestamp("dataViagem").toLocalDateTime());
				viagem.setHoraPartida(r.getTimestamp("horaPartida").toLocalDateTime());
				viagem.setOrigem(r.getString("origem"));
				viagem.setDestino(r.getString("destino"));
				

				System.out.println("ID Viagem: " + viagem.getIdViagem() + "\nData Viagem: "
						+ viagem.getDataViagem() + "\nHora Partida: "
						+ viagem.getHoraPartida() + "\nOrigem: " + viagem.getOrigem()
						+ "\nDestino: " + viagem.getDestino());

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	// UPDATE
	public void updateViagem(Viagem viagem) {
		sql = "UPDATE Viagem SET dataViagem = ?,horaPartida = ?,origem = ? WHERE idViagem = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			
			Timestamp sqlViagem = Timestamp.valueOf(viagem.getDataViagem());
			Timestamp sqlPartida = Timestamp.valueOf(viagem.getHoraPartida());
			stmt.setTimestamp(1, sqlViagem);
			stmt.setTimestamp(2, sqlPartida);
			

			stmt.setString(3, viagem.getOrigem());
			stmt.setString(4, viagem.getDestino());

			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	// DELETE
	public void deleteViagem(int id) {
		sql = "DELETE FROM viagem WHERE idViagem = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
