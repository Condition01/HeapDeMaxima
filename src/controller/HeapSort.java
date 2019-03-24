package controller;

public class HeapSort {
	public static int[] heapSort(int[] vetor) {
		int aux;
		constroiHeapDescendo(vetor);
		int ultimo = vetor.length - 1;
		while (ultimo >= 0) {
			aux = vetor[ultimo];
			vetor[ultimo] = vetor[0];
			vetor[0] = aux;
			ultimo--;
			descer(vetor, 0, ultimo);
		}
		return vetor;
	}

	public static void constroiHeapDescendo(int[] vetor) {
		for (int i = (vetor.length/2)-1; i >= 0 ; i--) {
			descer(vetor, i, (vetor.length - 1));
		}
	}

	public static void descer(int[] vetor, int pai, int ultimo) {
		int esq = ((2 * pai) + 1);
		int dir = ((2 * pai) + 2);
		int maior = pai;
		if ((esq <= ultimo) && (vetor[esq] > vetor[pai])) {
			maior = esq; // Filho Esquerdo Maior
		}
		if ((dir <= ultimo) && (vetor[dir] > vetor[maior])) {
			maior = dir; // Filho Direito Maior
		}
		if (maior != pai) {
			int aux = vetor[pai];
			vetor[pai] = vetor[maior];
			vetor[maior] = aux;
			// Trocar Pai e Filho Maior
			descer(vetor, maior, ultimo);
		}
	}


}
