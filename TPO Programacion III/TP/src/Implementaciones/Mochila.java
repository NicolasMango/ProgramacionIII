package Implementaciones;

import Auxiliares.TuplaTDA;
import TDA.MatrizTDA;
import TDA.VectorTDA;

public class Mochila {

	public int mochilaSinOptimizar(int capacidad, VectorTDA<TuplaTDA> tupla, 
			int res, int posicion){
		
		int resto= tupla.capacidadVector()-posicion;
		int capacidadNueva = 0;
		int resultado = 0;
		try {
			capacidadNueva = capacidad-tupla.recuperarElemento(posicion).getPeso();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(resto>0 && capacidad>0){
			
			
			if (capacidadNueva>=0){
				try {
					resultado= max(mochilaSinOptimizar(capacidadNueva, tupla,
							res+tupla.recuperarElemento(posicion).getValor(),
							posicion+1), 
							mochilaSinOptimizar(capacidad, tupla, res,posicion+1));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				resultado=mochilaSinOptimizar(capacidad, tupla, resto, posicion+1);
			}
			
		}
		return resultado;
	}

	public int mochilaOptimizada(int capacidad, VectorTDA<TuplaTDA> tupla){
		//supongo que las secuencias se ordenaron de menor a mayor segun el peso
	
		int resultado = 0;
		MatrizTDA<Integer> m= new Matriz<Integer>();
		
		m.inicializarMatriz(max(capacidad,tupla.capacidadVector())+1);
		int j=0,i;
		//puse un while porque ecclipce se habia vuelto loco y me daba un error con un for
		while(j<=capacidad){
			m.setearValor(0, j, 0);
			j++;
			
		}
			
			
		
		//arranca en 1 porque el 0,0 se cargo en el anterior "for"
		for( i=1; i<=tupla.capacidadVector();i++){
			m.setearValor(i, 0, 0);
		}
		
		for( i=1;i<=tupla.capacidadVector();i++){
			for( j=1; j<=capacidad;j++){
				try {
					if(j-tupla.recuperarElemento(i).getPeso()>=0){
						m.setearValor(i, j, max(m.obtenerValor(i-1, j),
								tupla.recuperarElemento(i).getValor()+
								m.obtenerValor(i-1,j-
										tupla.recuperarElemento(i).getPeso())));
					}else{
						m.setearValor(i, j, m.obtenerValor(i-1, j));
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		resultado=m.obtenerValor(tupla.capacidadVector(), capacidad);
		
		
		return resultado;
		
	}
	
	private int max(int opcion1, int opcion2) {
		// TODO Auto-generated method stub
		int resultado;
		if(opcion1>opcion2){
			resultado=opcion1;
		} else{
			resultado=opcion2;
		}
		return resultado;
	}
	
	
}
