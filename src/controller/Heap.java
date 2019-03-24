package controller;

public class Heap {
	int vetor[];
	int n;
	
	public Heap(int t) {
		vetor = new int[t];
		n = 0;
	}
	
	public void insere(int element) {
		vetor[++n] = element;
		subir(n);
	}
	
	public void subir(int filho) {
		int pai = filho/2;
		if(pai>=1) {
			if(vetor[filho] > vetor[pai]) {
				int aux = vetor[filho];
				vetor[filho] = vetor[pai];
				vetor[pai] = aux;
				subir(pai);
			}
		}
	}
	
	public void remove() {
		vetor[n] = vetor[1];
 		n--;
		descer(1,n);
	}
	
	public void descer(int pai, int ultimo) {
		int filho = 2*pai;
		if(pai<=ultimo) {
			if(pai<ultimo) { //verifica o ultimo pelo fato de ter ou não um irmão.
				if(vetor[filho+1]> vetor[filho]) {
					filho++;
				}
			}
			if(vetor[filho] > vetor[pai]) {
				int aux = vetor[filho];
				vetor[filho] = vetor[pai];
				vetor[pai] = aux;
				descer(filho, ultimo);
			}
		}
	}
	public String printHeap(int p) {
		String retorno = "(";
		while(p<=n) {
			retorno += " " + vetor[p] + " ";
			retorno += printHeap(p*2);
			retorno += printHeap(p*2+1);
		}
		retorno += ")";
		return retorno;
	}
	
	public boolean isHeapMax(int pai) {
		int filhoEsq = pai*2;
		int filhoDir = pai*2+1;
		boolean validacao = true;
		
		if(filhoEsq<= n && vetor[filhoEsq] > vetor[pai]) {
			return false;
		}
		if(filhoDir <= n && vetor[filhoDir] > vetor[pai]) {
			return false;
		}else if(pai <= n){
			validacao = isHeapMax(filhoEsq);
			validacao = isHeapMax(filhoDir);
		}
		return validacao;
	}
	
	public int menor(int pai) {
		int filhoEsq = pai*2;
		int filhoDir = pai*2+1;
		int menor = pai;
		
		if(filhoEsq <= n && vetor[filhoEsq] < vetor[pai]) {
			menor = filhoEsq;
		}
		if(filhoDir <= n && vetor[filhoDir] < vetor[menor]) {
			menor = filhoDir;
		}
		if(menor!=pai) {
			return menor(menor);
		}else {
			return vetor[menor];
		}
	}
}
