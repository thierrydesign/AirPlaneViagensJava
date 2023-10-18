package com.airplane.menu;

import java.sql.Connection;
import java.util.Scanner;

import com.airplane.dao.PassageiroDAO;
import com.airplane.database.DatabaseConnection;
import com.airplane.model.Passageiro;
import com.airplane.utils.Colors;

public class PassageiroIO {

	static Connection connection = DatabaseConnection.createConnection();
	static PassageiroDAO passageiroDAO = new PassageiroDAO(connection);

	public static int SubMenuPassageiro(Scanner scanner) {
		int option = Integer.MAX_VALUE;
		do {
			System.out.println("MENU PASSAGEIRO\n" + "1 - cadastrar\n" + "2 - Listar\n" + "3 - Atualizar\n" + "4 - Deletar"
					+ "\n0 - Sair");

			option = scanner.nextInt();
			switch (option) {
			case 1:
				scanner.nextLine();
				Passageiro passageiro = new Passageiro();
				System.out.println("Digite o seu CPF: ");
				passageiro.setCpf(scanner.nextLine());
				System.out.println("Digite o seu nome ");
				passageiro.setNome(scanner.nextLine());
				System.out.println("Digite o seu RG: ");
				passageiro.setRg(scanner.nextLine());
				System.out.println("Digite o telefone: ");
				passageiro.setTelefone(scanner.nextLine());
			
				passageiroDAO.createPassageiro(passageiro);

				break;
			case 2:
				passageiroDAO.readAllPassageiro();
				break;
			case 3:
				
				Passageiro passageiroAtualizado = new Passageiro();
				System.out.println("Digite o ID do Passageiro a ser atualizado: ");
				passageiroAtualizado.setId(scanner.nextInt());
				System.out.println("Digite o seu CPF: ");
				passageiroAtualizado.setCpf(scanner.nextLine());
				System.out.println("Digite o seu nome ");
				passageiroAtualizado.setNome(scanner.nextLine());
				System.out.println("Digite o seu RG: ");
				passageiroAtualizado.setRg(scanner.nextLine());
				System.out.println("Digite o telefone: ");
				passageiroAtualizado.setTelefone(scanner.nextLine());
				
				passageiroDAO.updatePassageiro(passageiroAtualizado);
				
				break;
			case 4:
				System.out.println("Digite o ID do Passageiro a ser " + Colors.RED.get() + "DELETADO" + Colors.RESET.get());
				int id = scanner.nextInt();
				passageiroDAO.deletePassageiro(id);

				break;
			default:
				System.out.println("Digite uma opcao valida");

			}

		} while (option != 0);

		return option;
	}
	
}
