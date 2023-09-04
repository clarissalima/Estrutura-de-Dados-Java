package SimplesmenteEncadeadas;

public class ListaSE extends No {

	private No cabeca;
	private int tamanho;
	private int tamAtual;
	
	public ListaSE() {
		cabeca = null;
		tamanho = 0;
	}
	
	public boolean vazia() {
		if(tamAtual == 0) return true;
		else return false;
	}
	
	
	public int tamanho() {
		//p é um aux que começa apontando pra onde a cabeça aponta
		No p = cabeca;
		int cont = 0;
		while(p != null) {
			//vai recebendo o prox enquanto nao chega ao fim
			p = p.getProximo();
			//cont retorna o tam pq vai incrementando enq p pega o prox
			cont++;
		}
		return cont;
	}
	
	public int elemento(int pos) {
		No aux = cabeca;
		int cont = 1;
		if(vazia()) return -1;
		
		if((pos < 1) || (pos > tamanho)) return -1;
		
		while(cont < pos) {
			aux = aux.getProximo();
			cont ++;
		}
		
		return aux.getConteudo();
	}
	
	public int posicao(int dado) {
		int cont = 1;
		No aux;
		
		if(vazia ()) return 0;
		aux = cabeca;
		while(aux != null) {
			if(aux.getConteudo() == dado) return cont;
			aux = aux.getProximo();
			cont++;
		}
		return -1;
	}
	
	boolean insere(int pos, int dado) {
		if((vazia()) && (pos != 1)) return false;
		
		if(pos == 1) {
			return insereInicioLista(dado);
		}
		else if(pos == tamanho+1) {
			return insereFimLista(dado);
		}
		else {
			return insereMeioLista(pos, dado);
		}
	}
	
	private boolean insereInicioLista(int valor) {
		No novoNo = new No();
		novoNo.setConteudo(valor);
		novoNo.setProximo(cabeca);
		cabeca = novoNo;
		tamanho++;
		return true;
	}
	
	private boolean insereMeioLista(int pos, int dado) {
		int cont = 1;
		No novoNo = new No();
		novoNo.setConteudo(dado);
		
		//localizando posicao para inserir
		No aux = cabeca;
		while((cont < pos-1) && (aux != null)){
			aux = aux.getProximo();
			cont++;
		}
		if(aux == null) return false;
		
		novoNo.setProximo(aux.getProximo());
		aux.setProximo(novoNo);
		tamanho++;
		return true;
	}
	
	private boolean insereFimLista(int dado) {
		No novoNo = new No();
		novoNo.setConteudo(dado);
		
		No aux = cabeca;
		while(aux.getProximo() != null) {
			aux = aux.getProximo();
		}
		
		novoNo.setProximo(null);
		aux.setProximo(novoNo);
		this.tamanho++;
		return true;
	}
	
	public int remove(int pos) {
		if(vazia()) return -1;
		
		if(pos == 1) {
			return removeInicioLista();
		} else return removeNaLista(pos);
	}
	
	private int removeInicioLista() {
		No p = cabeca;
		int dado = p.getConteudo();
		
		cabeca = p.getProximo();
		tamanho --;
		p = null;
		return dado;
	}
	
	private int removeNaLista(int pos) {
		No atual = null, antecessor = null;
		int dado = -1, cont = 1;
		
		atual = cabeca;
		while((cont < pos) && (atual != null)) {
			antecessor = atual;
			atual = atual.getProximo();
			cont++;
		}
		
		if(atual == null) return -1;
		
		dado = atual.getConteudo();
		antecessor.setProximo(atual.getProximo());
		tamanho--;
		atual = null;
		return dado;
	}
	
	
	
	
	

	
}
