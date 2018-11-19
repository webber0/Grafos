package pack;

public class MatrizSimetrica {
	private int grado;
	private int matriz[];
	
	public MatrizSimetrica(int grado) {
		this.grado=grado;
		int tam=(grado*(grado-1))/2;
		matriz= new int[tam];
	}
	private int obtenerIndice(int fila,int columna) {
		if(fila>columna) {
			int aux= fila;
			fila=columna;
			columna=aux;
		}
		return (fila*this.grado) + columna- ((fila*fila) + (fila*3)+2)/2;
	}
	
	public int obtenerContenido(int fila,int columna) throws MatrizSimetricaException {
		if(fila==columna) {
			throw new MatrizSimetricaException("No es posible llegar a la diagonal principal...");
		}
		return this.matriz[this.obtenerIndice(fila,columna)];
	}
	
	public void ingresarContenido(int fila, int columna, int contenido) throws MatrizSimetricaException{
		this.matriz[obtenerIndice(fila, columna)]=contenido;
	}
	
	public int obtenerGrado() {
		return this.grado;
	}
}