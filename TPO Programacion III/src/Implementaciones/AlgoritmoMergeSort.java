package Implementaciones;

import TDA.VectorTDA;

public class AlgoritmoMergeSort {
	void MergeSort ( VectorTDA < Integer > valores , int inicio ,int fin ) throws Exception {
			if (inicio <fin){
			   int medio = (fin+ inicio )/2;
			   MergeSort ( valores ,inicio , medio );
			   MergeSort ( valores , medio +1, fin);
			   Merge ( valores ,inicio ,fin);
			}
	}
	
	void Merge ( VectorTDA < Integer > valores , int inicio , int fin) throws Exception {
			// utilizo un vector auxiliar , paso todo all y luego lo vuelvo al vector de origen
			VectorTDA <Integer> resultado = new Vector <Integer>();
			resultado.inicializarVector (1+ fin - inicio );
			int medio = (fin + inicio )/2;
			int i = inicio;
			int j = medio + 1;
			for ( int k = 0; k <= fin - inicio ; k++){
				if (j> fin || (i <= medio && valores.recuperarElemento(i) <= valores.recuperarElemento(j))){
					resultado.agregarElemento (k, valores .
				    recuperarElemento (i));
			        i++;
			    }else{
			    	resultado.agregarElemento (k, valores .
			        recuperarElemento (j));
			    	j++;
			    }
			}
			for ( int k =0; k <= fin - inicio ; k++){
				valores.agregarElemento ( inicio +k,resultado.recuperarElemento (k));
			}
	}

}


