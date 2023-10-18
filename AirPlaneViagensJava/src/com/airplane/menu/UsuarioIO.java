package com.airplane.menu;

import java.sql.Connection;
import java.util.Scanner;

import com.airplane.dao.UsuarioDAO;
import com.airplane.database.DatabaseConnection;
import com.airplane.model.Usuario;
import com.airplane.utils.Colors;

public class UsuarioIO {

	static Connection connection = DatabaseConnection.createConnection();
	static UsuarioDAO usuarioDAO = new UsuarioDAO(connection);

	public static int SubMenuUsuario(Scanner scanner) {
		int option = Integer.MAX_VALUE;
		do {
			System.out.println("MENU USUARIOO\n" + "1 - cadastrar\n" + "2 - Listar\n" + "3 - Atualizar\n" + "4 - Deletar"
					+ "\n0 - Sair");

			option = scanner.nextInt();
			switch (option) {
			case 1:
				scanner.nextLine();
				Usuario usuario = new Usuario();
				System.out.println("Digite o seu Login: ");
				usuario.setLogin(scanner.nextLine());
				System.out.println("Digite o seu nome ");
				usuario.setNome(scanner.nextLine());
				System.out.println("Digite a sua Senha: ");
				usuario.setSenha(scanner.nextLine());
			
				usuarioDAO.createUsuario(usuario);

				break;
			case 2:
				usuarioDAO.readAllUsuario();
				break;
			case 3:
				
				Usuario usuarioAtualizado = new Usuario();
				System.out.println("Digite o ID do Usuario a ser atualizado: ");
				usuarioAtualizado.setId(scanner.nextInt());
				System.out.println("Digite o seu login: ");
				usuarioAtualizado.setLogin(scanner.nextLine());
				System.out.println("Digite o seu nome ");
				usuarioAtualizado.setNome(scanner.nextLine());
				System.out.println("Digite a sua senha: ");
				usuarioAtualizado.setSenha(scanner.nextLine());
				
				usuarioDAO.updateUsuario(usuarioAtualizado);
				
				break;
			case 4:
				System.out.println("Digite o ID do Usuario a ser " + Colors.RED.get() + "DELETADO" + Colors.RESET.get());
				int id = scanner.nextInt();
				usuarioDAO.deleteUsuario(id);

				break;
			default:
				System.out.println("Digite uma opcao valida");
			}

		} while (option != 0);

		return option;
	}
	
}
