
public class InstructionLine {
	
	public Boolean hasComments;
	public Boolean hasLineIdentifier;
	
	public String LineIdentifier;
	public String Comments;
	
	public EInstructions Instruction;
	
	public int InstructionParameter1;
	public int InstructionParameter2;
	
	private Boolean isValid;
	
	
	public InstructionLine() {
		super();
		this.hasComments = false;
		this.hasLineIdentifier = false;
		LineIdentifier = "";
		Comments = "";
		Instruction = EInstructions.NULL;
		InstructionParameter1 = 0;
		InstructionParameter2 = 0;
		isValid = false;
	}


	public InstructionLine(String lineToBeDecrypted) {
		super();
		
		DecodeStringIntoInstruction(lineToBeDecrypted);
		
	}
	
	public void DecodeStringIntoInstruction(String info) {
		
		String trimmedInfo = info.trim();
		String[] words = trimmedInfo.split("\\s");
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			
			System.out.println(word);
			
		}
		
	}
	
	
	
	public Boolean IsValidInstruction() {
		
		return isValid;
	}
	
	
	
	
	
	

}
