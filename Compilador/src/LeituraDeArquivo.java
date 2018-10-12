//classe com a fun��o de ler um arquivo fonte

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class LeituraDeArquivo {
    private int caracter;
    InputStreamReader leituracaracteres;

    public LeituraDeArquivo(String path) throws IOException {
        FileInputStream abertura = new FileInputStream(path); //abertura seria o objeto respons�vel pela abertura do arquivo
        this.leituracaracteres = new InputStreamReader(abertura); //leitura de caracteres
    }

    public int leituraCaracter()
    {
        try
        {
            if(this.caracter != -1)
            {
                this.caracter = leituracaracteres.read(); //m�todo read que retorna um inteiro que representa o caracter 
                return caracter;
            }
            else
            {
                return caracter;
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage()); 
        }
        return 0;
    }
}