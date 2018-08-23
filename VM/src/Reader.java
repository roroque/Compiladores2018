import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class Reader {
	
	public Vector<InstructionLine> ReadInstructions(String FilePath) {
		
		Vector<InstructionLine> instructions = new Vector<InstructionLine>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(FilePath))) {
		    String line = br.readLine();

		    while (line != null) {
		        
		        InstructionLine possibleLine = new InstructionLine(line);
		        
		        if(possibleLine.IsValidInstruction()) {
		        	instructions.add(possibleLine);
		        }
		        
		    }
		    
		    return instructions;
		    
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
	
	
	
	
	

}
