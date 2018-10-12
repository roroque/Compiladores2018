
import java.util.Vector;;

public class TesteAnalisadorSintatico 
{
    
    public static void main(String [] args)
    {
        AnalisadorSintatico teste = null;
        
        try
        {
            teste = new AnalisadorSintatico("C:\\Users\\Murilo\\Desktop\\Compiladores\\Compiladores2018\\Testes\\TestesSintaticos\\teste7.txt");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println(""+e.getMessage());
        }
    }
    
}