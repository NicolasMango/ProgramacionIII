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
				gan=ganancia.recuperarElemento(ganancia.capacidadVector()-1);
				pes=peso.recuperarElemento(peso.capacidadVector()-1);
				peso.EliminarElemento(peso.capacidadVector()-1);
				ganancia.EliminarElemento(ganancia.capacidadVector()-1);

				return Math.max(mochila(ganancia,peso,capacidad),gan+mochila(ganancia,peso,capacidad-pes));
				
			}
		}
		

	}
	
}
