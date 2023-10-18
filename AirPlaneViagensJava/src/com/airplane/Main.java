package com.airplane;

import java.util.Scanner;

import com.airplane.menu.ViagemIO;
import com.airplane.menu.MenuIO;
import com.airplane.menu.PassageiroIO;
import com.airplane.menu.UsuarioIO;
import com.airplane.utils.Colors;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int option = 0;

		do {

			option = MenuIO.menu(scanner);

			switch (option) {
			case 1:
				ViagemIO.SubMenuViagem(scanner);
				break;
			case 2:
				UsuarioIO.SubMenuUsuario(scanner);
				break;
			case 3:
				PassageiroIO.SubMenuPassageiro(scanner);
				break;
			default:
				System.out.println(Colors.RED.get() + "Você saiu da sessão!" + Colors.RED.get());

			}

		} while (option != 4);
		scanner.close();

	}

}
