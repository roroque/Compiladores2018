
import java.util.Vector;

public class TesteAnalisadorLexical {

	public static void main(String[] args) {
		
		Vector<Token> lista = null;
		AnalisadorLexical teste = null;
		try {
			teste = new AnalisadorLexical("iremos passar o caminho do arquivo aqui");
			for (int i = 0; i < lista.size(); i++) {
				System.out.println(lista.get(i)+"\n");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}