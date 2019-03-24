package view;

import controller.Heap;
import controller.HeapSort;
import controller.HeapSortDois;

public class Main {
	public static void main(String[] args) {
		HeapSortDois heap = new HeapSortDois();
		int vetor[] = {0,16,13,27, 28, 29};
		heap.heapSort(vetor);
		
	}
	static boolean verificaHeap(int vetor[], int pai, int ultimo) {
		int filhoEsq = 2*pai+1;
		int filhoDir = 2*pai+2;
		boolean validacaoEsq = true;
		boolean validacaoDir = true;
		if(filhoEsq <= ultimo) {
			if(vetor[filhoEsq] > vetor[pai]) {
				return false;
			}
		}
		if(filhoDir <= ultimo) {
			if(vetor[filhoDir] > vetor[pai]) {
				return false;
			}
		}
		if(pai  <= ultimo) {
			validacaoEsq = verificaHeap(vetor, filhoEsq, ultimo);
			validacaoDir = verificaHeap(vetor, filhoDir, ultimo);
		}
		if(validacaoEsq != validacaoDir) {
			return false;
		}else {
			return true;
		}
		
	}
	
	static int menor(int vetor[], int pai, int ultimo) {
		int filhoEsq = 2*pai+1;
		int filhoDir = 2*pai+2;
		int menor = pai;
		
		if(filhoEsq <= ultimo) {
			if(vetor[pai] > vetor[filhoEsq]) {
				menor = filhoEsq;
			}
		}
		if(filhoDir <= ultimo) {
			if(vetor[menor] > vetor[filhoDir]) {
				menor = filhoDir;
			}
		}
		if(menor!= pai) {
			return menor(vetor, menor, ultimo);
		}
		return vetor[pai];
	}
}
