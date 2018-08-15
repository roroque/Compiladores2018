
public class Operations {
	
	
	public void LDC(int info , Data data) {
		data.PileAdress += 1;
		data.InsertAt(info, data.PileAdress);
	}
	
	public void ADD(Data data) {
		int aux = data.Pile[data.PileAdress-1] + data.Pile[data.PileAdress];
		data.InsertAt(aux, data.PileAdress - 1);
		data.DecrementPileAdress();
	}
	
	public void MULT(Data data) {
		int aux = data.Pile[data.PileAdress-1] * data.Pile[data.PileAdress];
		data.InsertAt(aux, data.PileAdress - 1);
		data.DecrementPileAdress();
	}
	
	public void INV(Data data) {
		data.InsertAt(0 - data.Pile[data.PileAdress], data.PileAdress);
	}
	
	public void OR(Data data) {
		int aux = 0;
		if((data.Pile[data.PileAdress-1] == 1 || data.Pile[data.PileAdress] == 1)) {
			aux = 1;
		}
		
		data.InsertAt(, data.PileAdress-1);
		data.DecrementPileAdress();
	}
	
	
	
	
	
	

}
