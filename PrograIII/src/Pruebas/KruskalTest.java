package Pruebas;

import TDA.*;
import Implementaciones.*;

public class KruskalTest {

	public static void main(String[] args) throws Exception {
		GrafoTDA<Integer> grafo = new Grafo();
		grafo.InicializarGrafo();
		grafo.AgregarVertice(1);
		grafo.AgregarVertice(2);
		grafo.AgregarVertice(3);
		grafo.AgregarVertice(4);
		grafo.AgregarVertice(5);
		grafo.AgregarArista(1,2,4);
		grafo.AgregarArista(1,4,2);
		grafo.AgregarArista(2,3,3);
		grafo.AgregarArista(2,5,2);
		grafo.AgregarArista(4,3,5);
		grafo.AgregarArista(4,5,1);
		grafo.AgregarArista(5,3,2);
		
		AlgoritmoKruskal algoritmo = new AlgoritmoKruskal();
		
		GrafoTDA<Integer> GrafoFinal = algoritmo.Kruskal(grafo);
		
		ConjuntoTDA<Integer> adyacentes = new Conjunto();
		adyacentes.inicializarConjunto();
		
		for (int i = 1 ; i <= 5; i++){
				adyacentes = GrafoFinal.Adyacentes(i);
				while (!adyacentes.conjuntoVacio()){
					int vertice = adyacentes.elegir();
					System.out.println("Vertice : "+i+" es adyacente al vertice "+vertice);
					adyacentes.sacar(vertice);
				}
					
		}
		ConjuntoTDA vertices = GrafoFinal.Vertices();
		
		
		return;

	}

}
