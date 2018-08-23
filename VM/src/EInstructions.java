
public enum EInstructions {
	
	LDC,LDV,ADD,SUB,MULT,DIVI,INV,AND,OR,NEG,CME,CMA,CEQ,CDIF,CMEQ,CMAQ,START,HLT,STR,JMP,JMPF,NULL,RD,PRN,ALLOC,DALLOC,CALL,RETURN;
	
	public boolean CheckIfValidInstruction(String comparing) {
		for(EInstructions op : values()) {
			
			if(op.name().equals(comparing)) {
				return true;
			}
		}
		return false;
	}
	
	public EInstructions GetInstruction(String comparing) {
		for(EInstructions op : values()) {
			
			if(op.name().equals(comparing)) {
				return op;
			}
			
		}
		return EInstructions.NULL;
	}
}
