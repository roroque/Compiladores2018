
public class Token {
	
    private final String simbolo;
    private final String lexema;
    private final int linha;
    
    public Token(String simbolo, String lexema, int linha) {
        this.simbolo = simbolo;
        this.lexema = lexema;
        this.linha = linha;
    }
    public String getSimbolo(){
        return simbolo;
    }
     
    public String getLexema(){
        return lexema;
    }
    
    public int getLinha(){
        return linha;
    }
    
    public String toString(){
        return "Símbolo\t: "+simbolo+"\nLexema\t: "+lexema+"\nLinha\t: "+linha;
    }
    public static int simboloToCode(String simbolo)
    {
        try
        {
            switch (simbolo)
            {
            //Caso seja um inversor de sinal
            case "sinv" :
                 return 0;   
            case "sprograma":
                return 1;
            case "sinicio":
                return 2;
            case "sfim":
                return 3;
            case "sprocedimento":
                return 4;
            case "sfuncao":
                return 5;
            case "sse":
                return 6;
            case "sentao":
                return 7;
            case "ssenao":
                return 8;
            case "senquanto":
                return 9;
            case "sfaca":
                return 10;
            case "satribuicao":
                return 11;
            case "sescreva":
                return 12;
            case "sleia":
                return 13;
            case "svar":
                return 14;
            case "sinteiro":
                return 15;
            case "sbooleano":
                return 16;
            case "sidentificador":
                return 17;
            case "snumero":
                return 18;
            case "sponto":
                return 19;
            case "sponto_virgula":
                return 20;
            case "svirgula":
                return 21;
            case "sabre_parenteses":
                return 22;
            case "sfecha_parenteses":
                return 23;
            case "smaior":
                return 24;
            case "smaiorig":
                return 25;
            case "sig":
                return 26;
            case "smenor":
                return 27;
            case "smenorig":
                return 28;
            case "sdif":
                return 29;
            case "smais":
                return 30;
            case "smenos":
                return 31;
            case "smult":
                return 32;
            case "sdiv":
                return 33;
            case "se":
                return 34;
            case "sou":
                return 35;
            case "snao":
                return 36;
            case "sdoispontos":
                return 37;
            case "sverdadeiro":
                return 38;
            case "sfalso":
                return 39;
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage()); 
        }
        return 0;
    }
    
     public int simboloToCode()
     {
        switch (simbolo)
        {
        //Caso seja um inversor de sinal
        case "sinv" :
             return 0;   
        case "sprograma":
            return 1;
        case "sinicio":
            return 2;
        case "sfim":
            return 3;
        case "sprocedimento":
            return 4;
        case "sfuncao":
            return 5;
        case "sse":
            return 6;
        case "sentao":
            return 7;
        case "ssenao":
            return 8;
        case "senquanto":
            return 9;
        case "sfaca":
            return 10;
        case "satribuicao":
            return 11;
        case "sescreva":
            return 12;
        case "sleia":
            return 13;
        case "svar":
            return 14;
        case "sinteiro":
            return 15;
        case "sbooleano":
            return 16;
        case "sidentificador":
            return 17;
        case "snumero":
            return 18;
        case "sponto":
            return 19;
        case "sponto_virgula":
            return 20;
        case "svirgula":
            return 21;
        case "sabre_parenteses":
            return 22;
        case "sfecha_parenteses":
            return 23;
        case "smaior":
            return 24;
        case "smaiorig":
            return 25;
        case "sig":
            return 26;
        case "smenor":
            return 27;
        case "smenorig":
            return 28;
        case "sdif":
            return 29;
        case "smais":
            return 30;
        case "smenos":
            return 31;
        case "smult":
            return 32;
        case "sdiv":
            return 33;
        case "se":
            return 34;
        case "sou":
            return 35;
        case "snao":
            return 36;
        case "sdoispontos":
            return 37;
        case "sverdadeiro":
            return 38;
        case "sfalso":
            return 39;
        }
        return -1;
     }
}
