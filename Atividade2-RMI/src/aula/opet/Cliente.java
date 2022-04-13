package aula.opet;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Random;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws RemoteException, NotBoundException {
		final String HOST = "localhost";
		final int PORT = 1097;
		Registry registry;

		registry = LocateRegistry.getRegistry(HOST, PORT);

		Pessoa pservice = (Pessoa) registry.lookup(Pessoa.class.getSimpleName());
		Calculadora calcservice = (Calculadora) registry.lookup(Calculadora.class.getSimpleName());

		System.out.println("Resultado: " + pservice.getHello());
		Random random = new Random();
		for (int i = 0; i < 5; i++) {
			int max=110;
			int min=10;
			int idade = random.nextInt(max + 1 - min) + min;
			System.out.printf("Pessoa de %d = %s \n ",idade, pservice.getFaixa(idade));	
		}

		final double vldolar = 4.68;
		final double vleuro = 5.09;
		double vlreal = 10.00;

		System.out.printf("Real para dolar R$ %.2f = U$ R$ %.2f \n", vlreal, calcservice.RealToDolar(vlreal, vldolar));
		System.out.printf("Euro para Real EU$ %.2f = R$ %.2f \n", vleuro, calcservice.RealToEuro(vlreal, vleuro));

		try (Scanner input = new Scanner(System.in)) {
			System.out.print("Entre com o valor de A: ");
			int a = input.nextInt();
			System.out.print("Entre com o valor de B: ");
			int b = input.nextInt();

			System.out.printf("Resultado: %d x %d =%d \n", a, b, calcservice.Multiplica(a, b));
			System.out.printf("Resultado: %d - %d =%d \n", a, b, calcservice.Subtrai(a, b));
			System.out.printf("Resultado: %d / %d =%.2f \n ", a, b, calcservice.Divid(a, b));
		}

	}

}
