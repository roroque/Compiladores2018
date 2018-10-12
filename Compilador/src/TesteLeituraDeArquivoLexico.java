
import java.io.IOException;

public class TesteLeituraDeArquivoLexico {
    
    public static void main(String [] args)
    {
        int caracterLido = 0;
        LeituraDeArquivo leitor = null;
        try 
        {
            leitor = new LeituraDeArquivo("/Users/babugia/Documents/teste1.txt");
        } 
        catch (IOException ex) {}
        do
        {
            caracterLido = leitor.leituraCaracter();
            if(caracterLido != -1)
                System.out.println(""+(char)caracterLido);
        }
        while(caracterLido != -1);
    }
}
