package DuplamenteEncadeadas;

public class ListaDE {

	private No cabeca;
	private No cauda;
	private int nElementos;
	private int tamanho;
	private int tamAtual;
	
	public ListaDE() {
		cabeca = null;
		cauda = null;
		nElementos = 0;
	}
	
	public boolean vazia() {
		if(tamAtual == 0) return true;
		else return false;
	}
	
	public int tamanho() {
		return tamanho;
	}
	
	public int elemento (int pos) {
		No aux = cabeca;
		int cont = 1;
		if(vazia()) return -1;
		
		if((pos < 1) || (pos > tamanho)) return -1;
		
		while(cont < pos) {
			aux = aux.getProx();
			cont++;
		}
		return aux.getConteudo();
	}
	
	public int posicao (int dado) {
		int cont = 1;
		No aux;
		if (vazia()) return 0;
		aux = cabeca;
		
		while (aux != null) {
			if (aux.getConteudo() == dado) return cont;
			
		aux = aux.getProx();
		cont++;
		}
		return -1;
		}
	
	
	boolean insere(int pos, int dado) {
		if((vazia()) && (pos != 1)) return false;
		
		if (pos == 1){ // insercao no inicio da lista
			return insereInicioLista(dado);
		}
		else if (pos == tamanho+1){ // inserção no fim
			return insereFimLista(dado);
		}
		else{ // inserção no meio da lista
			return insereMeioLista(pos, dado);
		}

	}
	
	private boolean insereInicioLista(int valor) {
		No novoNo = new No();
		
		novoNo.setConteudo(valor);
		novoNo.setProx(cabeca);
		
		novoNo.setAnt(null);
		if (vazia()) cauda = novoNo;
		else cabeca.setAnt(novoNo);
		cabeca = novoNo;
		tamanho++;
		return true;
		
	}
	
	
	private boolean insereMeioLista(int pos, int dado) {
		int cont = 1;
		No novoNo = new No();
		novoNo.setConteudo(dado);
		
		No aux = cabeca;
		while ((cont < pos-1) && (aux != null)){
		aux = aux.getProx(); cont++;
		}
		
		if (aux == null) { return false; }
		novoNo.setAnt(aux);
		novoNo.setProx(aux.getProx());
		aux.getProx().setAnt(novoNo);
		aux.setProx(novoNo);
		tamanho++;
		 return true;
	}
	
	private boolean insereFimLista(int dado) {
		No novoNo = new No();
		novoNo.setConteudo(dado);
		
		No aux = cauda;
		
		novoNo.setProx(null);
		aux.setProx(novoNo);
		novoNo.setAnt(cauda);
		cauda.setProx(novoNo);
		cauda = novoNo;
		this.tamanho++;
		return true;
	}
	
	private int remove(int pos) {
		int ret;
		if (vazia()) {return (0);}
		
		if ((pos == 1) && (tamanho() == 1)){
			return removeInicioListaUnitaria();
			 }
		
		else if (pos == 1){
			return removeInicioLista();
			 }
		else if (pos == tamanho()){
			return removeFimLista();
			 }
		else{ // remoção no meio da lista
			return removeMeioLista(pos);
			 }
	}
	
	private int removeInicioListaUnitaria() {
		int dado = inicio.getConteudo();
		cabeca = null;
		cauda = null;
		tamanho--;
		return dado;
	}
	
	private int removeInicioLista(){
		No p = cabeca;
		int dado = p.getConteudo();
	}
	
	
}
