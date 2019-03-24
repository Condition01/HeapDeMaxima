package controller;

public class HeapSortDois {
	public static int[] heapSort(int[] v) {
		
		constroiHeapSubbindo(v);
		int f = 2;
		int ultimo = v.length-1;
		int i = 1;
		while(ultimo >= 1) {
			int filho = i+1;
			if(filho+1 <= ultimo && v[filho+1]>v[filho]) {
				int aux2 = v[filho+1];
				v[filho+1] = v[filho];
				v[filho] = aux2;
			} //usando essa logica precisamos fazer a construção do filhao que merece o titulo né :3
			int aux = v[1];
			v[1] = v[ultimo];
			v[ultimo] = aux;
			ultimo--;
			
			subir(v,i+1, ultimo);
			
		}
		return v;
	}

	public static int[] peneira(int ultimo, int v[]) {
		 int p = 1, f = 2, x = v[1];
		   while (f <= ultimo) {
		      if (f < ultimo && v[f] < v[f+1]) ++f;
		      if (x >= v[f]) break;
		      v[p] = v[f];
		      p = ultimo;
		      f = 2*p;
		   }
		   v[p] = x;
		   return v;
	}

	public static void constroiHeapSubbindo(int vetor[]) {
		for (int i = 1; i < vetor.length - 1; i++) {
			int filho = i + 1;
			subir(vetor, filho, vetor.length - 1);
		}
	}

	public static void subir(int vetor[], int filho, int ultimo) {
		int pai = filho / 2;
		if (filho > 1 && vetor[pai] < vetor[filho] && ultimo > 1) {
			int aux = vetor[pai];
			vetor[pai] = vetor[filho];
			vetor[filho] = aux;
			subir(vetor, pai, ultimo);
		}
	}

}
/*
 * peneira (int m, int v[]) { int f = 2; while (f <= m) { if (f < m && v[f] <
 * v[f+1]) ++f; // f é o filho mais valioso de f/2 if (v[f/2] >= v[f]) break;
 * troca (v[f/2], v[f]); f *= 2; } }
 */