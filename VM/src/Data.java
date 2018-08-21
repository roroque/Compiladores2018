
public class Data {
	
	public int InstructionAddress;
	
	public int PileAddress;
	
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
	
	
	public int IncrementPileAddress() {
		return PileAddress++;	
	}
	
	public int DecrementPileAddress() {
		return PileAddress--;
	}
	
	public void SetInstructionAdress(int value) {
		InstructionAddress = value;
	}
	
	public int GetInstructionAddress() {
		return InstructionAddress;
	}
	
}
