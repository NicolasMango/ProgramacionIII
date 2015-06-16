package Pruebas;

import Implementaciones.AlgoritmoMochila;
import Implementaciones.Vector;
import TDA.VectorTDA;

public class MochilaTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
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
		
		AlgoritmoMochila tobes = new AlgoritmoMochila();
		int gananciafinal = tobes.mochila(ganancia, peso, capacidad);
		System.out.print(gananciafinal);
	}

}
