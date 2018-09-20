
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
		String operador = "" + caracter;
		if (caracter == '=') {
			lerCaracter();
			return new Token("sig", operador, linha);
		}
		if (caracter == '>') {
			lerCaracter();
			if (caracter == '=') {
				operador = operador + caracter;
				lerCaracter();
				return new Token("smaiorig", operador, linha);
			}
			return new Token("smaior", operador, linha);
		}
		if (caracter == '<') {
			lerCaracter();
			if (caracter == '=') {
				operador = operador + caracter;
				lerCaracter();
				return new Token("smenorig", operador, linha);
			}
			return new Token("smenor", operador, linha);
		}
		lerCaracter();
		if (caracter == '=') {
			operador = operador + caracter;
			lerCaracter();
			return new Token("sdif", operador, linha);
		}
		return null;
	}

	private Token trataOperadorAritmético() {
		String atribuicao = "" + caracter;

		if (caracter == '+') {

			lerCaracter();
			return new Token("smais", atribuicao, linha); // tirar comentário quando a classe token estiver pronta
		} else if (caracter == '-') {

			lerCaracter();
			return new Token("smenos", atribuicao, linha); // tirar comentário quando a classe token estiver //
															// pronta
		}

		else {
			lerCaracter();
			return new Token("smult", atribuicao, linha); // tirar comentário quando a classe token estiver pronta
		}
	}

	private Token trataAtribuicao() {
		String atribuicao = "" + caracter;
		lerCaracter();

		if (caracter == '=') {
			atribuicao = atribuicao + '=';
			lerCaracter();
			return new Token("sdoispontos", atribuicao, linha); // tirar comentário quando a classe token estiver
																// pronta
		}
		return new Token("sdoispontos", atribuicao, linha);
	}

	private Token trataIdentificadorEPalavraReservada() {
		String id = "";
		do {
			id = id + caracter;
			lerCaracter();

		} while (Character.isDigit(caracter) || Character.isLetter(caracter));

		switch (id) {
		case "programa":
			return new Token( "sprograma", id, linha );
		case "inicio":
			return new Token( "sinicio", id, linha );
		case "fim":
			return new Token( "sfim", id, linha );
		case "procedimento":
			return new Token( "sprocedimento", id, linha );
		case "funcao":
			return new Token( "sfuncao", id, linha);
		case "se":
			return new Token( "sse", id, linha );
		case "entao":
			return new Token( "sentao", id, linha );
		case "senao":
			return new Token( "ssenao", id, linha );
		case "enquanto":
			return new Token( "senquanto", id, linha );
		case "faca":
			return new Token( "sfaca", id, linha );
		case "escreva":
			return new Token( "sescreva", id, linha );
		case "leia":
			return new Token( "sleia", id, linha );
		case "var":
			return new Token( "svar", id, linha );
		case "inteiro":
			return new Token( "sinteiro", id, linha );
		case "booleano":
			return new Token( "sbooleano", id, linha );
		case "identificador":
			return new Token( "sidentificador", id, linha );
		case "div":
			return new Token( "sdiv", id, linha );
		case "e":
			return new Token( "se", id, linha );
		case "ou":
			return new Token( "sou", id, linha );
		case "nao":
			return new Token( "snao", id, linha );
		}

		return null;
	}

	private Token trataPontuacao() {
		String atribuicao = "" + caracter;
		if (caracter == ';') {
			lerCaracter();
			return new Token("sponto_virgula", atribuicao, linha);
		}
		if (caracter == '(') {
			lerCaracter();
			return new Token("sabre_parenteses", atribuicao, linha);
		}
		if (caracter == ')') {
			lerCaracter();
			return new Token("sfecha_parenteses", atribuicao, linha);
		}
		if (caracter == ',') {
			lerCaracter();
			return new Token("svirgula", atribuicao, linha);
		}
		if (caracter == '.') {
			lerCaracter();
			return new Token("sponto", atribuicao, linha);
		}

		return null;
	}

	private Token trataDigito() {
		String num = "";
		do {
			num = num + caracter;
			lerCaracter();
		} while (Character.isDigit(caracter));
		return new Token("snumero", num, linha);

	}

	public void lerCaracter() {
		leituraDoArquivo = arquivo.leituraCaracter();
		if (leituraDoArquivo != -1) {
			caracter = (char) leituraDoArquivo;
		}
	}
}
