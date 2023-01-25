package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import entidades.Locadora;

public class Programa1 {
	public static void main(String args[]) {
		Scanner num = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locadora loc = new Locadora();
		try {
			System.out.println("Entre com os dados do aluguel");
			System.out.print("Modelo do carro: ");
			loc.setModelo(num.next());
			System.out.print("Insira a data de retirada (dd/MM/yyyy): ");
			loc.setRetirada(sdf.parse(num.next()));
			System.out.print("Insira a data de retorno (dd/MM/yyyy): ");
			loc.setRetorno(sdf.parse(num.next()));
			System.out.print("Insira o preco por hora: ");
			loc.setPrecoH(num.nextDouble());
			System.out.print("Insira o preco por dia: ");
			loc.setPrecoD(num.nextDouble());

			System.out.println("FATURA: ");
			System.out.println("Pagamento basico: " + loc.pBasico());
			System.out.println("Imposto: " + loc.imposto());
			System.out.println("Pagamento total: " + loc.pTotal());
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Erro inesperado");
		} finally {
			num.close();
		}
	}
}