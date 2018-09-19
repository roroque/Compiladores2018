import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class LeitorDeArquivo {
    private int caracter;
    InputStreamReader leituracaracteres;

    public LeitorDeArquivo(String path) throws IOException {
        FileInputStream abertura = new FileInputStream(path); 
        this.leituracaracteres = new InputStreamReader(abertura); 
    }

    public int leituraCaracter()
    {
        try
        {
            if(this.caracter != -1)
            {
                this.caracter = leituracaracteres.read(); //retorna um inteiro que representa o caracter
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