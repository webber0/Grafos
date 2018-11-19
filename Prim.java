package pack;
/*
 * Este algoritmo busca encontrar un arbol recubridor minimo. En otras palabras
 * lo que busca es unir todos los nodos de un grafo a un costo minimo
 * @param: Un vector representativo de la matriz de adyacencia
 * @return:  Muestra en pantalla (a fin de despues modificarlo para que grabe en un archivo)
 * visitado[i]= False indica que no lo visite, True indica que SI lo visite
 * Costo computacional: O(n^2)
 * Fuente del algortimo original:  https://es.wikipedia.org/wiki/Algoritmo_de_Prim#Otra_versi%C3%B3n_sin_usar_Colas
 */
public class Prim {
	private void inicializarVector(boolean[] visitados) {
		for(int i=0;i<visitados.length;i++) {
			visitados[i]=false;
		}
	}
	public void resolver(int grado, MatrizSimetrica matriz) throws MatrizSimetricaException {
		int fila=0,columna=0,minimo_actual=-1,fila_min=0,columna_min=0,minimo_anterior=-1;
		//para no ver el mismo nodo 2 veces
		boolean[] visitado= new boolean[grado];
		//inicializo el vector
		inicializarVector(visitado);
		
		if(!TodosVisitados(visitado)) { //Si no visite todos los nodos, entonces empiezo
			for(fila=0;fila<matriz.obtenerGrado()-1;fila++) { //Entro a la primera fila
				if(!visitado[fila]) {  //Si esa fila no esta visitada, entonces, la recorro
					minimo_actual=-1;
					for(columna=0 ; columna<matriz.obtenerGrado() ; columna++) { //Entro a la primera columna
						if(fila!=columna) { //Como nos manejamos con la matriz simetrica, y en la posicion fila==colmna no hay nada, la ignoro
							if(minimo_actual==-1) { //Esto se hace una vez
								minimo_actual=matriz.obtenerContenido(fila, columna);
							}
							else {
								minimo_actual=Math.min(matriz.obtenerContenido(fila, columna),minimo_actual);
							}
							if(minimo_actual!=minimo_anterior) {
								minimo_anterior=minimo_actual;
								fila_min=fila;
								columna_min=columna;
							}
						}
						else;
					}
					visitado[fila]=true;
				}
				System.out.println("Fila minima: "+ (fila_min+1) + ", Columna minima: "+ (columna_min+1) +", Pasos: "+ minimo_actual);
			}
		}
	}
	private boolean TodosVisitados(boolean[] nodos) {
		for(boolean resultado:nodos) {
			if(!resultado) return resultado;
		}
		return true;
	}
}
