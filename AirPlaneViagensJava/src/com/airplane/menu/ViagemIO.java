package com.airplane.menu;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.airplane.dao.ViagemDAO;
import com.airplane.database.DatabaseConnection;
import com.airplane.model.Viagem;
import com.airplane.utils.Colors;

public class ViagemIO {
	static Connection connection = DatabaseConnection.createConnection();
	static ViagemDAO viagemDAO = new ViagemDAO(connection);

	public static int SubMenuViagem(Scanner scanner) {
		int option = Integer.MAX_VALUE;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		do {
			System.out.println("MENU VIAGEM\n" + "1 - cadastrar\n" + "2 - Listar\n" + "3 - Atualizar\n"
					+ "4 - Deletar" + "\n0 - Sair");

			option = scanner.nextInt();
			switch (option) {
			case 1:
				scanner.nextLine();
				Viagem viagem = new Viagem();
				System.out.println("Digite a data e horario da viagem no formato dd/MM/yyyy HH:mm:ss");
				String dataEhoraViagem = scanner.nextLine();
				viagem.setDataViagem(LocalDateTime.parse(dataEhoraViagem, formatter));
				System.out.println("Digite a data e horario da reserva no formato dd/MM/yyyy HH:mm:ss");
				String dataEhoraReserva = scanner.nextLine();
				viagem.setHoraPartida(LocalDateTime.parse(dataEhoraReserva, formatter));
				System.out.println("Digite o destino: ");
				viagem.setDestino(scanner.nextLine());
				System.out.println("Digite a origem: ");
				viagem.setOrigem(scanner.nextLine());

				viagemDAO.createViagem(viagem);
				break;
			case 2:
				viagemDAO.readAllViagem();
				break;
			case 3:
				Viagem viagemAtualizado = new Viagem();
				System.out.println("Digite o ID do Atendimento a ser atualizado: ");
				viagemAtualizado.setIdViagem(scanner.nextInt());
				scanner.nextLine();
				System.out.println("Digite a data e horario da viagem no formato dd/MM/yyyy HH:mm:ss");
				String dataEhoraViagemAtualizado = scanner.nextLine();
				viagemAtualizado.setDataViagem(LocalDateTime.parse(dataEhoraViagemAtualizado, formatter));
				System.out.println("Digite a data e horario da reserva no formato dd/MM/yyyy HH:mm:ss");
				String dataEhoraReservaAtualizado = scanner.nextLine();
				viagemAtualizado.setHoraPartida(LocalDateTime.parse(dataEhoraReservaAtualizado, formatter));
				System.out.println("Digite a origem: ");
				viagemAtualizado.setDestino(scanner.nextLine());
				System.out.println("Digite o destino: ");
				viagemAtualizado.setOrigem(scanner.nextLine());

				viagemDAO.updateViagem(viagemAtualizado);
				break;
			case 4:
				System.out.println(
						"Digite o ID da Viagem a ser " + Colors.RED.get() + "DELETADO" + Colors.RESET.get());
				int idViagem = scanner.nextInt();
				viagemDAO.deleteViagem(idViagem);

				break;
			default:
				System.out.println("Digite uma opcao valida");

			}

		} while (option != 0);

		return option;
	}
}
