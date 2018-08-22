
public class Operations {
	
	public void LDC(int info , Data data) {
		data.PileAddress += 1;
		data.InsertAt(info, data.PileAddress);
	}
	
	public void LDV(int info , Data data) {
		data.PileAddress += 1;
		data.InsertAt(info, data.GetInfoAt(info)); //corrigir, voce esta fazendo M[n] = M[n] e o correto seria M[S] = M[n]
	}
	
	public void ADD(Data data) {
		int aux = data.Pile[data.PileAddress-1] + data.Pile[data.PileAddress];
		data.InsertAt(aux, data.PileAddress - 1);
		data.DecrementPileAddress();
	}
	
	public void SUB(Data data) {
		int aux = data.Pile[data.PileAddress-1] - data.Pile[data.PileAddress];
		data.InsertAt(aux, data.PileAddress - 1);
		data.DecrementPileAddress();
	}
	
	public void MULT(Data data) {
		int aux = data.Pile[data.PileAddress-1] * data.Pile[data.PileAddress];
		data.InsertAt(aux, data.PileAddress - 1);
		data.DecrementPileAddress();
	}
	
	public void DIVI(Data data) {
		int aux = data.Pile[data.PileAddress-1]/data.Pile[data.PileAddress];
		data.InsertAt(aux, data.PileAddress - 1);
		data.DecrementPileAddress();
	}
	
	public void INV(Data data) {
		data.InsertAt(0 - data.Pile[data.PileAddress], data.PileAddress);
	}
	
	public void AND(Data data) {
		int aux = 0;
		if((data.Pile[data.PileAddress-1] == 1 && data.Pile[data.PileAddress] == 1)) {
			aux = 1;
		}
		data.InsertAt(aux, data.PileAddress-1);
		data.DecrementPileAddress();
	}
	
	public void OR(Data data) {
		int aux = 0;
		if((data.Pile[data.PileAddress-1] == 1 || data.Pile[data.PileAddress] == 1)) {
			aux = 1;
		}
		data.InsertAt(aux, data.PileAddress-1);
		data.DecrementPileAddress();
	}
	
	public void NEG(Data data) {
		int aux = 0;
	    aux = 1 - data.Pile[data.PileAddress];
	    data.InsertAt(aux, data.PileAddress);
	}
	
	public void CME(Data data) {
		int aux = 0;
		if(data.Pile[data.PileAddress-1] < data.Pile[data.PileAddress]) {
			aux = 1;
		}
		data.InsertAt(aux, data.PileAddress-1);
		data.DecrementPileAddress();
	}
	
	public void CMA(Data data) {
		int aux = 0;
		if(data.Pile[data.PileAddress-1] > data.Pile[data.PileAddress]) {
			aux = 1;
		}
		data.InsertAt(aux, data.PileAddress-1);
		data.DecrementPileAddress();
	}
	
	public void CEQ(Data data) {
		int aux = 0;
		if(data.Pile[data.PileAddress-1] == data.Pile[data.PileAddress]) {
			aux = 1;
		}
		data.InsertAt(aux, data.PileAddress-1);
		data.DecrementPileAddress();
	}
	
	public void CDIF(Data data) {
		int aux = 0;
		if(data.Pile[data.PileAddress-1] != data.Pile[data.PileAddress]) {
			aux = 1;
		}
		data.InsertAt(aux, data.PileAddress-1);
		data.DecrementPileAddress();
	}
	
	public void  CMEQ(Data data) {
		int aux = 0;
		if(data.Pile[data.PileAddress-1] <= data.Pile[data.PileAddress]) {
			aux = 1;
		}
		data.InsertAt(aux, data.PileAddress-1);
		data.DecrementPileAddress();
	}
	
	public void  CMAQ(Data data) {
		int aux = 0;
		if(data.Pile[data.PileAddress-1] >= data.Pile[data.PileAddress]) {
			aux = 1;
		}
		data.InsertAt(aux, data.PileAddress-1);
		data.DecrementPileAddress();
	}
	
	public void START(Data data) {
		data.PileAddress = -1;
	}
	
	public void HLT(Data data) {
		//incorreto essa instrucao nao modifica nenhuma variavel
		//data.PileAdress = 0; //fim da execução
	}
	
	public void STR(int info, Data data) {
		data.InsertAt(data.GetInfoAt(data.PileAddress), info);
		data.DecrementPileAddress();
	}
	
	public void JMP(int info, Data data) {
		data.SetInstructionAdress(info);
	}
	
	public void JMPF(int info, Data data) {
		if(data.GetInfoAt(data.PileAddress) == 0) {
			data.SetInstructionAdress(info);
		}else {
			data.SetInstructionAdress(data.InstructionAddress+1);
		}
		data.DecrementPileAddress();
	}
	
	public void NULL(Data data) {}
	
	public void RD(int info, Data data) {
		data.PileAddress += 1;
		data.InsertAt(info, data.PileAddress);
	}
	
	public void PRN(Data data) {//modificar funcao para int para retornar o valor que deve ser impresso
		int info = data.DecrementPileAddress();// isso aqui se encontra bem incorreto
		data.GetInfoAt(info);//logo essa informacao se encontra incorreta
		//seguir essa ordem
		//pegar a informacao que se encontra no topo da pilha (nao eh necessario decrementar o topo dela) e armazena-la em um auxiliar
		//decrementar o pile adress pela funcao
	}
	
	public void ALLOC(int p1, int p2, Data data) {
		for (int i = 0; i < p2 - 1; i++) {
			data.IncrementPileAddress();
			data.InsertAt(data.GetInfoAt(p1 + i),data.PileAddress);
		}
	}
	
	public void DALLOC(int p1, int p2, Data data) {
		for(int i = (p2-1); i>=0; i--){
			data.Pile[p1+i] = data.Pile[data.PileAddress];
			data.DecrementPileAddress();
		}
	}
	
	public void CALL(int info, Data data) { //manter padrao por favor: (int info , Data data)
		//int info=0;// essa parte incorreta
		//int i = data.IncrementPileAddress(); //essa parte esta correta
		//data.Pile[info] = i++; // substituir i++ por data.InstructionAddress + 1
		//i=t;// substituir por: data.SetInstructionAdress(t);
		//esclarecimento, assim como nos jumps i corresponde ao instruction address
		
		
	}
	
	public void RETURN(Data data) {
		data.SetInstructionAdress(data.GetInfoAt(data.PileAddress));
		data.DecrementPileAddress();
	}
}
	
	
	
	
	
    
