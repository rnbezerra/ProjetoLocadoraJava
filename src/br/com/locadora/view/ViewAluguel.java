package br.com.locadora.view;

import java.text.NumberFormat;

import br.com.locadora.model.Cliente;
import br.com.locadora.model.DVD;


public class ViewAluguel {

	public static void mostraAluguelRealizado(Cliente cliente, DVD dvd, double saldo, String dataDevolucao) {
		/*
		DVD Alugado com sucesso:\n
		<Código do Cliente>-<Nome do Cliente>\n
		<Código do DVD>-<Nome do DVD>\n
		Data de devolução:<Data de Devolução (formato DD/MM/YYYY)>\n
		Saldo do Cliente: R$<Saldo do cliente>\n
		DVDs disponíveis: <Número deste DVD ainda disponíveis>\n
		*/		
		
		StringBuilder mensagem = new StringBuilder();
		mensagem.append("DVD Alugado com sucesso:\n")
				.append(String.format("%s-%s\n", cliente.getCodigo(), cliente.getNome()))
				.append(String.format("%s-%s\n", dvd.getCodigo(), dvd.getTitulo()))
				.append(String.format("Data de devolucao: %s\n", dataDevolucao))
				.append(String.format("Saldo do Cliente: %s\n",NumberFormat.getCurrencyInstance().format(saldo)))
				.append(String.format("DVDs disponíveis: %d\n", dvd.getCopias()));
		System.out.println(mensagem.toString());
	}

	public static void dadoNaoEncontrado() {
		System.out.println("DVD ou Cliente não encontrado.");
	}

	public static void copiasIndisponiveis(DVD dvd) {
		System.out.println("Não há cópias disponíveis do DVD");
	}

}
