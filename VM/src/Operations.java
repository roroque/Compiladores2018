
public class Operations {
	
	
	public void LDC(int info , Data data) {
		data.PileAdress += 1;
		data.InsertAt(info, data.PileAdress);
	}
	
	public void LDV(int info , Data data) {
		data.PileAdress += 1;
		data.InsertAt(info, data.GetInfoAt(info));
	}
	
	public void ADD(Data data) {
		int aux = data.Pile[data.PileAdress-1] + data.Pile[data.PileAdress];
		data.InsertAt(aux, data.PileAdress - 1);
		data.DecrementPileAdress();
	}
	
	public void SUB(Data data) {
		int aux = data.Pile[data.PileAdress-1] - data.Pile[data.PileAdress];
		data.InsertAt(aux, data.PileAdress - 1);
		data.DecrementPileAdress();
	}
	
	public void MULT(Data data) {
		int aux = data.Pile[data.PileAdress-1] * data.Pile[data.PileAdress];
		data.InsertAt(aux, data.PileAdress - 1);
		data.DecrementPileAdress();
	}
	
	public void DIVI(Data data) {
		int aux = data.Pile[data.PileAdress-1]/data.Pile[data.PileAdress];
		data.InsertAt(aux, data.PileAdress - 1);
		data.DecrementPileAdress();
	}
	
	public void INV(Data data) {
		data.InsertAt(0 - data.Pile[data.PileAdress], data.PileAdress);
	}
	
	public void AND(Data data) {
		int aux = 0;
		if((data.Pile[data.PileAdress-1] == 1 && data.Pile[data.PileAdress] == 1)) {
			aux = 1;
		}
		data.InsertAt(aux, data.PileAdress-1);
		data.DecrementPileAdress();
	}
	
	public void NEG(Data data) {
		int aux = 0;
	    aux = 1 - data.Pile[data.PileAdress];
	    data.InsertAt(aux, data.PileAdress);
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
	
	public void CMA(Data data) {
		int aux = 0;
		if(data.Pile[data.PileAdress-1] > data.Pile[data.PileAdress]) {
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
	
	public void CDIF(Data data) {
		int aux = 0;
		if(data.Pile[data.PileAdress-1] != data.Pile[data.PileAdress]) {
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
	
	public void  CMAQ(Data data) {
		int aux = 0;
		if(data.Pile[data.PileAdress-1] >= data.Pile[data.PileAdress]) {
			aux = 1;
		}
		data.InsertAt(aux, data.PileAdress-1);
		data.DecrementPileAdress();
	}
	
	public void START(Data data) {
		data.PileAdress = -1;
	}
	
	public void HLT(Data data) {
		data.PileAdress = 0; //fim da execu��o
	}
	
	public void STR(int info, Data data) {
		data.InsertAt(data.GetInfoAt(data.PileAdress), info);
		data.DecrementPileAdress();
	}
	
	public void JMP(int info, Data data) {
		data.SetInstructionAdress(info);
	}
	
	public void JMPF(int info, Data data) {
		if(data.GetInfoAt(data.PileAdress) == 0) {
			data.SetInstructionAdress(info);
		}else {
			data.SetInstructionAdress(data.InstructionAdress+1);
		}
		data.DecrementPileAdress();
	}
	
	public void NUL(int info, Data data) {}
	
}
