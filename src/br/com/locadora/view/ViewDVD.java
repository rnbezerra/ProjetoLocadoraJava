package br.com.locadora.view;

import java.util.HashMap;

import br.com.locadora.model.Filme;
import br.com.locadora.model.Personalidade;
import br.com.locadora.model.Show;

public class ViewDVD {

	public static void mostraFilme(Filme filme, HashMap<String, Personalidade> personalidades, String nomeDiretor) {
		/*
		Se tipo == filme:
		<tipo>;\n
		<Código>;<Nome DVD>;<Área>;<Gênero>;\n
		<Sinopse>;\n
		<Código Personalidade>-<Nome Personalidade>|<Código Personalidade>-<Nome Personalidade>;\n
		<Código Diretor>-<Nome Diretor>;\n
		<Ano>;<Categoria>;
		<Quantidade disponível>;\n
		*/

		StringBuilder mensagem = new StringBuilder();
		mensagem.append("filme;\n")
				.append(String.format("%s;%s;%s;%s;\n", filme.getCodigo(), filme.getTitulo(), filme.getArea(), filme.getGenero()))
				.append(String.format("%s\n", filme.getSinopse() ));
		
		for (String codArtista : filme.getElenco()) {
			mensagem.append(String.format("%s-%s|", codArtista, personalidades.get(codArtista).getNome()));
		}
		
		mensagem.deleteCharAt(mensagem.length()-1);
		mensagem.append(";\n");
		
		mensagem.append(String.format("%s-%s;\n", filme.getDirecao(), nomeDiretor))
				.append(String.format("%s;%s;%s;\n", filme.getAnoLancamento(), filme.getCategoriaAsString(), filme.getCopias() ));
		
		System.out.println(mensagem.toString());
	}
	
	public static void mostraShow(Show show) {
		/*
		Se tipo == show:
		<tipo>;\n
		<Código>;<Nome DVD>;<Área>;<Gênero>;\n
		<Faixas>;\n
		<Artista>;
		<Ano>;<Categoria>;
		<Quantidade disponível>;\n
		*/
		
		StringBuilder mensagem = new StringBuilder();
		mensagem.append("show;\n")
				.append(String.format("%s;%s;%s;%s;\n", show.getCodigo(), show.getTitulo(), show.getArea(), show.getGenero()))
				.append(String.format("%s\n", show.getFaixas() ))
				.append(String.format("%s;%s;%s;%s;\n", show.getArtista(), show.getAnoLancamento(), show.getCategoriaAsString(), show.getCopias() ));
		
		
		System.out.println(mensagem.toString());
	}

	public static void dadoNaoEncontrado() {
		System.out.println("Nenhum DVD encontrado.");
	}
}
