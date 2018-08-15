
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
		
		data.InsertAt(aux, data.PileAdress-1);
		data.DecrementPileAdress();
	}
	
	public void CME(Data data) {
		int aux = 0;
		if(data.Pile[data.PileAdress-1] < data.Pile[data.PileAdress]) {
			aux = 1;
		}
		data.InsertAt(aux, data.PileAdress-1);
		data.DecrementPileAdress();
	}
	
	public void CEQ(Data data) {
		int aux = 0;
		if(data.Pile[data.PileAdress-1] == data.Pile[data.PileAdress]) {
			aux = 1;
		}
		data.InsertAt(aux, data.PileAdress-1);
		data.DecrementPileAdress();
	}
	
	public void  CMEQ(Data data) {
		int aux = 0;
		if(data.Pile[data.PileAdress-1] <= data.Pile[data.PileAdress]) {
			aux = 1;
		}
		data.InsertAt(aux, data.PileAdress-1);
		data.DecrementPileAdress();
	}
	
	public void START(Data data) {
		data.PileAdress = -1;
	}
	
	public void STR(int info, Data data) {
		data.InsertAt(data.GetInfoAt(data.PileAdress), info);
		data.DecrementPileAdress();
	}
	
	public void JMPF(int info, Data data) {
		if(data.GetInfoAt(data.PileAdress) == 0) {
			data.SetInstructionAdress(info);
		}else {
			data.SetInstructionAdress(data.InstructionAdress+1);
		}
		data.DecrementPileAdress();
	}
	
	
	
	
	
	
	
	

}
