package dataIO;

import java.io.*;

public class AtorArtistaImportacao {

	/*O metodo dadosDiretor abre o arquivo diretor.txt e extrai os seguintes campos utilizando um valor de 
	 * 1 - 6 como parametro:
	 * 
	 * 1 - Codigo do ator
	 * 2 - Primeiro nome do ator
	 * 3 - Nome completo do ator
	 * 4 - Sexo ator
	 * 5 - Data nascimento ator
	 * 6 - Codigo dos filmes atuados
	 * 
	 * */
	public static String dadosDiretor(int opcao){
			
			File dir = new File("C:\\importacao");
			File arq = new File(dir, "atorArtista.txt");
			
			try{
				
				FileReader fileReader = new FileReader(arq);
				
				String[] linhaDoArquivo = new BufferedReader(fileReader).readLine().split(";");
				switch (opcao) {
				case 1:
					String codigoAtor = linhaDoArquivo[0];
					return codigoAtor;
				
				case 2:
					String pNomeAtor = linhaDoArquivo[1];
					return pNomeAtor;
					
				case 3:
					String nomeCompAtor = linhaDoArquivo[2];
					return nomeCompAtor;
					
				case 4:
					String sexoAtor = linhaDoArquivo[3];
					return sexoAtor;
					
				case 5:
					String nascAtor = linhaDoArquivo[4];
					return nascAtor;
				
				case 6:
					String codFilmesAtor = linhaDoArquivo[5];
					return codFilmesAtor;
					
				default:
					System.out.println("Escolha um valor entre 1-6");
					break;
				}
				
				
				}catch(IOException e){
					
					e.getStackTrace();
					System.out.println("Erro ao obter o código");
					
				}
			return null;
		} 

	
	
	
	public static void main(String[] args) {
		
		System.out.println(dadosDiretor(6));
		// TODO Auto-generated method stub

	}

}
