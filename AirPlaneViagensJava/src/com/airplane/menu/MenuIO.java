package com.airplane.menu;

import java.util.Scanner;

import com.airplane.utils.Colors;

public class MenuIO {

	
	public static int menu(Scanner scanner) {
		System.out.println(Colors.CYAN_BOLD.get() + "Escolha uma opcao de 1 - 4\n" + Colors.RESET.get()
		+ "1 - Viagem\n" + "2 - Usuario\n" + "3 - Passageiro\n" + "4 - Sair");
		
		
		return scanner.nextInt();
		
	}
	
	
}
