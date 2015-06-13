package Implementaciones;

import TDA.VectorTDA;
import TDA.ColaPrioridadTDA;

public class AlgoritmoMochila {
	
	
	
	public int mochila (VectorTDA<Integer> ganancia, VectorTDA<Integer> peso, int capacidad) throws Exception {
		
		int gan=0;
		int pes=0;
		
		if (capacidad == 0) {
			return 0;
		} else {
			if (ganancia.capacidadVector() == 0) {
				return -9999;
			} else {
				gan=ganancia.recuperarElemento(0);
				pes=peso.recuperarElemento(0);
				peso.EliminarElemento(0);
				ganancia.EliminarElemento(0);
				
				return Math.max(mochila(ganancia,peso,capacidad),gan+mochila(ganancia,peso,capacidad-pes));
				
			}
		}
		

	}
	
}