package Pruebas;

import Auxiliares.TuplaTDA;
import Implementaciones.AlgoritmoMochila;
import Implementaciones.Mochila;
import Implementaciones.Tupla;
import Implementaciones.Vector;
import TDA.VectorTDA;

public class MochilaTest {

	public static void main(String[] args) throws Exception {
		
/*		VectorTDA<TuplaTDA> elementos = new Vector();
		TuplaTDA tupla = new Tupla();
		elementos.inicializarVector(3);
		tupla.setValor(10);
		tupla.setPeso(40);
		try {
			elementos.agregarElemento(0, tupla);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tupla.setValor(20);
		tupla.setPeso(5);
		try {
			elementos.agregarElemento(1, tupla);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tupla.setValor(30);
		tupla.setPeso(10);
		try {
			elementos.agregarElemento(2, tupla);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int capacidad = 15;
		int posicion = 1;
		
		AlgoritmoMochila algoritmo = new AlgoritmoMochila();
		int gananciamaxima = 0;
		try {
			gananciamaxima = algoritmo.mochila(elementos, capacidad,posicion);
		} catch (Exception e) {
			e.printStackTrace();
		}
*/
		
        VectorTDA<Integer> ganancia = new Vector<Integer>();
        VectorTDA<Integer> peso = new Vector<Integer>();
        ganancia.inicializarVector(3);
        peso.inicializarVector(3);
        ganancia.agregarElemento(0,10);
		ganancia.agregarElemento(1,20);
		ganancia.agregarElemento(2,30);
		peso.agregarElemento(0,40);
		peso.agregarElemento(1,5);
		peso.agregarElemento(2,10);

		int capacidad = 15;
		int posicion = 1;
		
		AlgoritmoMochila algoritmo = new AlgoritmoMochila();
		int gananciamaxima = 0;

		gananciamaxima = algoritmo.mochila(ganancia,peso, capacidad,posicion);

	
		System.out.print("La ganancia maxima permitida para la capaciad " + capacidad + " es : " + gananciamaxima);
		return;
	}

}
