
public class Data {
	
	public int InstructionAdress;
	
	public int PileAdress;
	
	public int[] Pile;
	
	
	public void InsertAt(int info, int index) {
		Pile[index] = info;
	}
	
	public int GetInfoAt(int index) {
		if(Pile.length < index) {
			return Pile[index];
		}
		return -1;
	}
	
	
	public int IncrementPileAdress() {
		return PileAdress++;	
	}
	
	public int DecrementPileAdress() {
		return PileAdress--;
	}
	
	public void SetInstructionAdress(int value) {
		InstructionAdress = value;
	}
	
	public int GetInstructionAdress() {
		return InstructionAdress;
	}
	
}
