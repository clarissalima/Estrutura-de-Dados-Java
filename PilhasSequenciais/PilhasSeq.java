package PilhasSequenciais;

public class PilhasSeq {
	
	private int dados[];
	private int topo;
	private int tamMax;
	
	public PilhasSeq() {
		tamMax = 100;
		dados = new int[tamMax];
		topo = -1;
	}
	
	public boolean vazia() {
		if(topo == -1) return true;
		else return false;
	}
	
	public boolean cheia() {
		if(topo == (tamMax-1)) return true;
		else return false;
	}
	
	public int tamanho() {
		return topo+1;
	}
	
	public int top() {
		if(vazia()) {
			return -1;
		}
		return dados[topo];
	}
	
	public boolean push(int valor) {
		if(cheia()) return false;
		
		topo++;
		dados[topo] = valor;
		return true;
	}
	
	public int pop() {
		if(vazia()) return -1;
		
		int valor = dados[topo];
		topo--;
		return valor;
	}
	
	
	

}
