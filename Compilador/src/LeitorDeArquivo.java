import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeitorDeArquivo {

	private String UrlArquivo;
	private String ConteudoArquivo;
	public int CaracterAtual;
	public Boolean FimDeArquivo;
	
	public void AbrirArquivo() {
		try(BufferedReader br = new BufferedReader(new FileReader(UrlArquivo))) {
		    ConteudoArquivo = br.toString();
		    
		} catch (FileNotFoundException e) {
			//se realizar a exceçao mostrar arquivo em branco
			ConteudoArquivo = "";
		} catch (IOException e) {
			//se realizar a exceçao mostrar arquivo em branco
			ConteudoArquivo = "";
		}
		
	}
	
	public void ComecarLeitura() {
		
		CaracterAtual = 0;
		FimDeArquivo = false;
		
	}
	
	public String LerCaracter() {	
		String StringAtual = "";
		
		if(CaracterAtual < ConteudoArquivo.length()) {
			StringAtual = "" + ConteudoArquivo.charAt(CaracterAtual);
		}else {
			FimDeArquivo = true;
		}
		
		return StringAtual;
	}
	
	
	
	
	
	
}
