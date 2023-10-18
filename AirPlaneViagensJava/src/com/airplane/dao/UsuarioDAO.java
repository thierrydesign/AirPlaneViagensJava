package com.airplane.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.airplane.model.Usuario;
import com.airplane.utils.Colors;

public class UsuarioDAO {

	private static String sql;

	private final Connection connection;

	public UsuarioDAO(Connection connection) {
		this.connection = connection;
	}

	// CREATE
	public void createUsuario(Usuario usuario) {
		sql = "INSERT INTO usuario (login, nome, senha) VALUES (?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getNome());
			stmt.setString(3, usuario.getSenha());

			stmt.executeUpdate();
			System.out.println(Colors.GREEN.get() + "Usuario criado com sucesso\n" + Colors.RESET.get() + "Login: "
					+ usuario.getLogin() + "\nNome: " + usuario.getNome());
		} catch (SQLException e) {
			System.out.println(Colors.RED.get() + "[LOG] Nao foi possivel criar o Usuario." + Colors.RESET.get()
					+ "Mensagem: " + e.getMessage());

		}
	}

	// READ
	public void readAllUsuario() {
		sql = "SELECT * FROM usuario";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet r = stmt.executeQuery();
			while (r.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(r.getInt("idUsuario"));
				usuario.setLogin(r.getString("login"));
				usuario.setNome(r.getString("nome"));
				usuario.setSenha(r.getString("senha"));

				System.out.printf("ID: %d\n login: %s\n nome: %s\n senha: %s\n", usuario.getId(),
						usuario.getLogin(), usuario.getNome(), usuario.getSenha());

			}
			if (!r.next()) {
				System.out.println(Colors.PURPLE_BOLD_BRIGHT.get() + "HÁ DADOS" + Colors.RESET.get());
			}

		} catch (SQLException e) {
			System.out.println(Colors.RED.get() + "[LOG] Nao foi possivel acessar as informacoes." + Colors.RESET.get()
					+ "Mensagem: " + e.getMessage());
		}
	}

	// UPDATE
	public void updateUsuario(Usuario usuario) {
		sql = "UPDATE usuario SET login = ?, nome = ?, senha = ? WHERE idUsuario = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getNome());
			stmt.setString(3, usuario.getSenha());
			stmt.setInt(4, usuario.getId());

			stmt.executeUpdate();
			System.out.println(Colors.GREEN.get() + "Usuario atualizado com sucesso\n" + Colors.RESET.get() + "Login: "
					+ usuario.getLogin() + "\nNome: " + usuario.getNome());

		} catch (SQLException e) {
			System.out.println(Colors.RED.get() + "[LOG] Nao foi possivel atualizar o usuario." + Colors.RESET.get()
					+ "Mensagem: " + e.getMessage());
		}
	}

	// DELETE
	public void deleteUsuario(int id) {
		sql = "DELETE FROM usuario WHERE idUsuario = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);

			stmt.executeUpdate();
			System.out.println(Colors.GREEN.get() + "Usuario deletado com sucesso!" + Colors.RESET.get());
		} catch (SQLException e) {
			System.out.println(Colors.RED.get() + "Nao foi possivel deletar o Usuario." + Colors.RESET.get()
					+ "Mensagem: " + e.getMessage());
		}
	}
	
}
