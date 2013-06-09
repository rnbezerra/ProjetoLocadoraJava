package br.com.locadora.view;

import java.text.NumberFormat;

import br.com.locadora.model.Cliente;
import br.com.locadora.model.HistoricoLocacao;

public class ViewCliente {
	
	public static void mostraCliente(Cliente cliente) {
		/*
		<Código>;<Nome do cliente>\n
		<CPF>\n
		<Endereço>\n
		<CEP>\n
		<Telefone>\n
		<Tipo de cliente>\n
		<Saldo atual>\n 
		<Código DVD>-<Nome DVD>-<Data Aluguel>-<Data Devolução*>\n
		*/
		
		StringBuilder mensagem = new StringBuilder();
		mensagem.append(String.format("%s;%s\n", cliente.getCodigo(), cliente.getNome()))
				.append(String.format("%s\n", cliente.getCpf() ))
				.append(String.format("%s\n", cliente.getEndereco() ))
				.append(String.format("%s\n", cliente.getCep() ))
				.append(String.format("%s\n", cliente.getTelefone() ))
				.append(String.format("%s\n", cliente.getStatusAsString() ))
				.append(String.format("%s\n", "0" ));
		
		for (int i = 0 ; i < cliente.getHistoricoLocacao().size(); i++) {
			
		}
		
		System.out.println(mensagem.toString());
	}

	public static void dadoNaoEncontrado() {
		System.out.println("Nenhum Cliente encontrado.");
	}

}
