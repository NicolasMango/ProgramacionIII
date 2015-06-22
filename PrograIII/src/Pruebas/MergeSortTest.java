package Pruebas;
import java.awt.print.Printable;

import TDA.*;
import Implementaciones.*;

public class MergeSortTest {

	public static void main(String[] args) throws Exception {
		
		VectorTDA<Integer> secuencia = new Vector();
		secuencia.inicializarVector(10);
		secuencia.agregarElemento(0, 2);
		secuencia.agregarElemento(1, 1);
		secuencia.agregarElemento(2, 4);
		secuencia.agregarElemento(3, 6);
		secuencia.agregarElemento(4, 3);
		secuencia.agregarElemento(5, 9);
		secuencia.agregarElemento(6, 8);
		secuencia.agregarElemento(7, 5);
		secuencia.agregarElemento(8, 10);
		secuencia.agregarElemento(9, 7);
		System.out.println("Secuencia original : ");
		
		for (int i = 0 ; i <= 9 ; i++){
			System.out.print(secuencia.recuperarElemento(i)+" ");
		}
		
		AlgoritmoMergeSort algoritmo = new AlgoritmoMergeSort();
		
		algoritmo.MergeSort(secuencia, 0, 9);

		System.out.println("\nSecuencia ordenada por MergeSort : ");
		for (int i = 0 ; i <= 9 ; i++){
			System.out.print(secuencia.recuperarElemento(i)+" ");
		}
		return;

	}

}
