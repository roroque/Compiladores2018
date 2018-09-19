
import java.util.Vector;

public class AnalisadorLexical {

	LeitorDeArquivo arquivo;
	char caracter;
	int linha = 1, leituraDoArquivo = 0, aux = 0;

	Vector<Token> listaDeTokens;
	Erro erro = new Erro();

	public AnalisadorLexical(String urlArquivo) throws Exception {
		
		listaDeTokens = new Vector<Token>();
		Token token = null;

		arquivo = new LeitorDeArquivo(urlArquivo);
		lerCaracter();

		while (leituraDoArquivo != -1) {

			if (caracter == '}' || caracter == '@' || caracter == '%' || caracter == '#' || caracter == '$'
					|| caracter == 'ˆ' || caracter == '&' || caracter == '?' || caracter == '/' || caracter == '|'
					|| caracter == '`' || caracter == '[' || caracter == ']' || caracter == 'ˆ') {
				System.out.println("caracter invalido é " + caracter);
				erro.erroLexico(linha, 1);
			}

			if (caracter == '{') {
				aux = linha;
				while (caracter != '}') {

					if (caracter == '\n') {
						linha++;
					}
					lerCaracter();
					if (leituraDoArquivo == -1)
						erro.erroLexico(aux, 2);
				}
			}

			if (Character.isWhitespace(caracter)) { // verifique se o caracter é um espaço
				if (caracter == '\n') {
					linha++;
				}
				lerCaracter();
				continue;
			}

			if (caracter == 'p')
				System.out.println("f");

			token = proximoToken(); // verifica as condições de análise();
			if (token == null)
				erro.erroLexico(linha, 1);
			listaDeTokens.add(token);
		}
	}

	private Token proximoToken() {
		if (Character.isDigit(caracter))
			return trataDigito();
		if (Character.isLetter(caracter))
			return trataIdentificadorEPalavraReservada();
		if (caracter == ':')
			return trataAtribuicao();
		if (caracter == '+' || caracter == '-' || caracter == '*')
			return trataOperadorAritmético();
		if (caracter == '>' || caracter == '<' || caracter == '=' || caracter == '!')
			return trataOperadorRelacional();

		return trataPontuacao();
	}

	public Vector<Token> pegaTokens() {
		return listaDeTokens;
	}

	public Token pegaToken(int i) {
		return listaDeTokens.get(i);
	}

	private Token trataOperadorRelacional() {
		// TODO Auto-generated method stub
		return null;
	}

	private Token trataOperadorAritmético() {
		String atribuicao = "" + caracter;

		if (caracter == '+') {

			lerCaracter();
			return new Token(/* "smais", atribuicao, linha */); // tirar comentário quando a classe token estiver pronta
		} else if (caracter == '-') {

			lerCaracter();
			return new Token(/* "smenos", atribuicao, linha */); // tirar comentário quando a classe token estiver													// pronta
		}

		else {
			lerCaracter();
			return new Token(/* "smult", atribuicao, linha */); // tirar comentário quando a classe token estiver pronta
		}
	}

	private Token trataAtribuicao() {
		String atribuicao = "" + caracter;
		lerCaracter();

		if (caracter == '=') {
			atribuicao = atribuicao + '=';
			lerCaracter();
			return new Token(/* "sdoispontos", atribuicao, linha */); // tirar comentário quando a classe token estiver
																		// pronta
		}
		return new Token(/* "sdoispontos", atribuicao, linha */);
	}

	private Token trataIdentificadorEPalavraReservada() {
		// TODO Auto-generated method stub
		return null;
	}

	private Token trataPontuacao() {
		String atribuicao = "" + caracter;
		if (caracter == ';') {
			lerCaracter();
			return new Token(/*"sponto_virgula", atribuicao, linha*/);
		}
		if (caracter == '(') {
			lerCaracter();
			return new Token(/*"sabre_parenteses", atribuicao, linha*/);
		}
		if (caracter == ')') {
			lerCaracter();
			return new Token(/*"sfecha_parenteses", atribuicao, linha*/);
		}
		if (caracter == ',') {
			lerCaracter();
			return new Token(/*"svirgula", atribuicao, linha*/);
		}
		if (caracter == '.') {
			lerCaracter();
			return new Token(/*"sponto", atribuicao, linha*/);
		}
		
		return null;
	}

	private Token trataDigito() {
		String num = "";
		do {
			num = num + caracter;
			lerCaracter();
		} while (Character.isDigit(caracter));
		return new Token(/* "snumero", num, linha */); // quando estiver com os parametros corretos na classe token, é
														// só tirar o comentário

	}

	public void lerCaracter() {
		leituraDoArquivo = arquivo.leituraCaracter();
		if (leituraDoArquivo != -1) {
			caracter = (char) leituraDoArquivo;
		}
	}
}
