

import java.util.Vector;

public class TesteAnalisadorLexical {

	public static void main(String[] args) {
		
		Vector<Token> lista;
		AnalisadorLexical teste = null;
		try {
			teste = new AnalisadorLexical("C:\\Users\\Murilo\\Desktop\\Compiladores\\Compiladores2018\\Testes\\TestesLexicos\\teste7.txt");
			lista = teste.pegaTokens();
			for (int i = 0; i < lista.size(); i++) {
				System.out.println(lista.get(i)+"\n");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
