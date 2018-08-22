//Falta corrigir pra lidar com Zeros na posicao do pivor em tempo de exec.

public class AlgebraLinear {
	public static void main(String[] args) {
		double matriz[][] = {{1, -1, 4, 0}, {3, 1, 8, 0}};
		print(matriz);
		System.out.println();
		Organizar(matriz);
		print(matriz);
		System.out.println();
		Escalonamento(matriz);
		
	}	
	
	static void Escalonamento (double matriz[][]) {
		int auxLinha = 0, auxColuna = 0;
		for(int i = 0; i < matriz.length; i++) {
			if(matriz[auxLinha][++auxColuna] == 0) {
				
			}
			auxColuna = Parte1(matriz, auxLinha);
			Parte2(matriz, auxLinha, auxColuna);
			auxLinha++;
			
			
		}
	}
	
	static void Organizar(double matriz[][]) {
		
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz.length; j++) { 
				if(matriz[j][i] == 0 && j == i) {
					double vetorAux[] = new double [matriz.length];
					vetorAux = matriz[j];
					matriz[j] = matriz[matriz.length - 1];
					matriz[matriz.length - 1] = vetorAux;
				}
			}
			
			
		}
		
		int aux;
		int aux2 = matriz.length - 1;
		for(int i = 0; i < matriz.length; i++) {
			aux = 0;
			for(int j = 0; j < matriz.length; j++) {
				if(matriz[i][j] == 0) {
					aux++;
				}
			}
			if(aux == matriz.length) {
				double vetorAux[] = new double [matriz.length];
				vetorAux = matriz[i];
				matriz[i] = matriz[aux2];
				matriz[aux2] = vetorAux;
				aux2--;
			}
		}
		
//		for(int i = 1; i < matriz.length; i++) {
//			if(matriz[i][0] == 1) {
//				double vetorAux[] = matriz[0];
//				matriz[0] = matriz[i];
//				matriz[i] = vetorAux;
//				break;
//			}
//		}
	}
	
	static int Parte1(double matriz[][], int auxLinha) {
		for(int i = 0; i < matriz.length; i++) {
			if(matriz [auxLinha] [i] != 0) {
				if(matriz[auxLinha][i] == 1) {
					
					return i;
				}else {
					CriarPivor(matriz[auxLinha], matriz[auxLinha][i]);
			
					return i;
				}
			}
		}
		return -1;
	}
	
	static void Parte2(double matriz[][], int auxLinha, int auxColuna) {
		boolean erros = true;
		while(erros) {
			erros = false;
			for(int i = 0; i < matriz.length; i++) {
				for(int j = 0; j < matriz.length; j++) {
					if(matriz[i][j] != 0 && auxLinha != i && auxColuna == j) {
						ZerarElemento(matriz, i, j, auxLinha);
						print(matriz);
						System.out.println();
						erros = true;	
					}
				}
			}
		}
		
		
	}
	
	static double[] CriarPivor(double vetor[], double multiplicador) {
		for(int i = 0; i < vetor.length; i++) {
			vetor[i] = vetor[i] * (1/multiplicador);
		}
		return vetor;
	}
	
	static void ZerarElemento(double matriz[][], int i, int j, int linhaAux) {
		double aux = matriz[i][j];
		for(int k = 0; k < matriz[linhaAux].length; k++) {
			matriz[i][k] = matriz[i][k] - (aux * matriz[linhaAux][k]);
		}
	}
	
	static void print(double matriz[][]) {
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	static void Determinante(double matriz[][]) {
		double matrizAux[][] = new double[3][5];
		for(int i = 0; i < 3; i++) {
			matrizAux[i] = matriz[i];
		}
	}
}
