package Implementaciones;

import Auxiliares.TuplaTDA;
import TDA.VectorTDA;public class AlgoritmoMochila {
	
	
	
	public int mochila ( VectorTDA<Integer> ganancia , VectorTDA<Integer> peso, int capacidad, int posicion) throws Exception {
		
		if (capacidad == 0) {
			return 0;
		} else {
			if (ganancia.capacidadVector() - posicion == 0) {
				return -9999;
			} else {
				int gan = ganancia.recuperarElemento(ganancia.capacidadVector()-posicion);
				int pes = peso.recuperarElemento(peso.capacidadVector()-posicion);
				return Math.max(mochila(ganancia,peso,capacidad,posicion + 1),gan + mochila(ganancia,peso,capacidad-pes,posicion +1));
				
			}
		}
		

	}
}

