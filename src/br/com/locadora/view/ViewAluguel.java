package br.com.locadora.view;

import java.text.NumberFormat;

import br.com.locadora.model.Cliente;
import br.com.locadora.model.DVD;


public class ViewAluguel {

	public static void mostraAluguelRealizado(Cliente cliente, DVD dvd, double saldo, String dataDevolucao) {
		/*
		DVD Alugado com sucesso:\n
		<C�digo do Cliente>-<Nome do Cliente>\n
		<C�digo do DVD>-<Nome do DVD>\n
		Data de devolu��o:<Data de Devolu��o (formato DD/MM/YYYY)>\n
		Saldo do Cliente: R$<Saldo do cliente>\n
		DVDs dispon�veis: <N�mero deste DVD ainda dispon�veis>\n
		*/		
		
		StringBuilder mensagem = new StringBuilder();
		mensagem.append("DVD Alugado com sucesso:\n")
				.append(String.format("%s-%s\n", cliente.getCodigo(), cliente.getNome()))
				.append(String.format("%s-%s\n", dvd.getCodigo(), dvd.getTitulo()))
				.append(String.format("Data de devolucao: %s\n", dataDevolucao))
				.append(String.format("Saldo do Cliente: %s\n",NumberFormat.getCurrencyInstance().format(saldo)))
				.append(String.format("DVDs dispon�veis: %d\n", dvd.getCopias()));
		System.out.println(mensagem.toString());
	}

	public static void dadoNaoEncontrado() {
		System.out.println("DVD ou Cliente n�o encontrado.");
	}

	public static void copiasIndisponiveis(DVD dvd) {
		System.out.println("N�o h� c�pias dispon�veis do DVD");
	}

}
