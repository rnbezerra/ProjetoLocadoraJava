package dataIO;

import java.io.*;


public class DiretorImportacao {
/*O metodo dadosDiretor abre o arquivo diretor.txt e extrai os seguintes campos utilizando um valor de 
 * 1 - 4 como parametro:
 * 
 * 1 - Codigo do diretor
 * 2 - Nome do diretor
 * 3 - Sexo do diretor
 * 4 - Codigo de filmes dirigidos
 * 
 * */
public static String dadosDiretor(int opcao){
		
		File dir = new File("C:\\importacao");
		File arq = new File(dir, "diretor.txt");
		
		try{
			
			FileReader fileReader = new FileReader(arq);
			
			String[] linhaDoArquivo = new BufferedReader(fileReader).readLine().split(";");
			switch (opcao) {
			case 1:
				String codigoDir = linhaDoArquivo[0];
				return codigoDir;
			
			case 2:
				String NomeDir = linhaDoArquivo[1];
				return NomeDir;
				
			case 3:
				String sexoDir = linhaDoArquivo[2];
				return sexoDir;
				
			case 4:
				String filmesDir = linhaDoArquivo[3];
				return filmesDir;
								
			default:
				System.out.println("Escolha um valor entre 1-4");
				break;
			}
			
			}catch(IOException e){
				
				e.getStackTrace();
				System.out.println("Erro em obter o código");
				
			}
		return null;
	} 
	
	public static void main(String[] args) {
		
		
		System.out.println(dadosDiretor(1));
		// TODO Auto-generated method stub

	}

}
