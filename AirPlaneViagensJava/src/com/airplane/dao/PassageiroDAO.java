package com.airplane.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.airplane.model.Passageiro;
import com.airplane.utils.Colors;

public class PassageiroDAO {

	private static String sql;

	private final Connection connection;

	public PassageiroDAO(Connection connection) {
		this.connection = connection;
	}

	// CREATE
	public void createPassageiro(Passageiro passageiro) {
		sql = "INSERT INTO passageiro (cpf, nome, rg, telefone) VALUES (?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, passageiro.getCpf());
			stmt.setString(2, passageiro.getNome());
			stmt.setString(3, passageiro.getRg());
			stmt.setString(4, passageiro.getTelefone());

			stmt.executeUpdate();
			System.out.println(Colors.GREEN.get() + "Passageiro criado com sucesso\n" + Colors.RESET.get() + "Nome: "
					+ passageiro.getNome() + "\nCPF: " + passageiro.getCpf());
		} catch (SQLException e) {
			System.out.println(Colors.RED.get() + "[LOG] Nao foi possivel criar o passageiro." + Colors.RESET.get()
					+ "Mensagem: " + e.getMessage());

		}
	}

	// READ
	public void readAllPassageiro() {
		sql = "SELECT * FROM passageiro";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet r = stmt.executeQuery();
			while (r.next()) {
				Passageiro passageiro = new Passageiro();
				passageiro.setId(r.getInt("idPassageiro"));
				passageiro.setCpf(r.getString("cpf"));
				passageiro.setNome(r.getString("nome"));
				passageiro.setRg(r.getString("rg"));
				passageiro.setTelefone(r.getString("telefone"));

				System.out.printf("ID: %d\n cpf: %s\n nome: %s\n rg: %s\n telefone: %s\n", passageiro.getId(),
						passageiro.getCpf(), passageiro.getNome(), passageiro.getRg(),
						passageiro.getTelefone());

			}
			if (!r.next()) {
				System.out.println(Colors.PURPLE_BOLD_BRIGHT.get() + "NAO HA DADOS" + Colors.RESET.get());
			}

		} catch (SQLException e) {
			System.out.println(Colors.RED.get() + "[LOG] Nao foi possivel acessar as informacoes." + Colors.RESET.get()
					+ "Mensagem: " + e.getMessage());
		}
	}

	// UPDATE
	public void updatePassageiro(Passageiro passageiro) {
		sql = "UPDATE passageiro SET cpf = ?, nome = ?, rg = ?, telefone = ? WHERE idPassageiro = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, passageiro.getCpf());
			stmt.setString(2, passageiro.getNome());
			stmt.setString(3, passageiro.getRg());
			stmt.setString(4, passageiro.getTelefone());
			stmt.setInt(5, passageiro.getId());

			stmt.executeUpdate();
			System.out.println(Colors.GREEN.get() + "Passageiro atualizado com sucesso\n" + Colors.RESET.get() + "CPF: "
					+ passageiro.getCpf() + "\nNome: " + passageiro.getNome());

		} catch (SQLException e) {
			System.out.println(Colors.RED.get() + "[LOG] Nao foi possivel atualizar o passageiro." + Colors.RESET.get()
					+ "Mensagem: " + e.getMessage());
		}
	}

	// DELETE
	public void deletePassageiro(int id) {
		sql = "DELETE FROM passageiro WHERE idPassageiro = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);

			stmt.executeUpdate();
			System.out.println(Colors.GREEN.get() + "Passageiro deletado com sucesso!" + Colors.RESET.get());
		} catch (SQLException e) {
			System.out.println(Colors.RED.get() + "Nao foi possivel deletar o Passageiro." + Colors.RESET.get()
					+ "Mensagem: " + e.getMessage());
		}
	}
}
