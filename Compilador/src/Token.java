
public class Token {
	
	public String Lexema;
	
	public ESimbolo Simbolo;
	
	public int Linha;
	
	public Boolean Valido;

	public String getLexema() {
		return Lexema;
	}

	public void setLexema(String lexema) {
		Lexema = lexema;
	}

	public ESimbolo getSimbolo() {
		return Simbolo;
	}

	public void setSimbolo(ESimbolo simbolo) {
		Simbolo = simbolo;
	}

	public int getLinha() {
		return Linha;
	}

	public void setLinha(int linha) {
		Linha = linha;
	}

	public Token() {
		super();
		Lexema = "";
		Simbolo = ESimbolo.Null;
		Linha = 0;
		Valido = false;
	}

}
