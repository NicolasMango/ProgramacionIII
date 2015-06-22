package Implementaciones;
import TDA.GrafoTDA;
import TDA.ConjuntoTDA;
import TDA.ColaPrioridadTDA;
import TDA.VectorTDA;

public class AlgoritmoKruskal {
	
	public class Par{
		int valor1;
		int valor2;
	}
	
	public GrafoTDA <Integer> Kruskal ( GrafoTDA <Integer> g) throws Exception {
			int vertice , cantidad = 0, i, aux_vertice , c1 =0, c2=0, cantidad_pendientes;
			Par aux_par;
			ConjuntoTDA < Integer > aux_adyacentes ;
			GrafoTDA < Integer > resultado = new Grafo < Integer >() ;
			resultado . InicializarGrafo ();
			ConjuntoTDA < Integer > vertices = g. Vertices ();
			while (! vertices . conjuntoVacio ()){
				vertice = vertices . elegir ();
				vertices . sacar ( vertice );
				resultado . AgregarVertice ( vertice );
				cantidad ++;
			}
			// en el par , valor1 y valor2 son los vertices y prioridad es el peso
			ColaPrioridadTDA <Par> aristas = new ColaPrioridad <Par>() ;
		    aristas.InicializarCola();
			// en el par , valor1 es el vertice y valor2 el conjunto
			VectorTDA <Par> conjuntos = new Vector <Par>();
			conjuntos.inicializarVector(cantidad );
			vertices = g.Vertices();
			i = 0;
			while (! vertices.conjuntoVacio()){
				vertice = vertices.elegir();
				vertices.sacar (vertice);
				aux_par = new Par();
				aux_par.valor1 = vertice ;
				aux_par.valor2 = vertice ;
				conjuntos.agregarElemento (i, aux_par );
				i++;
				aux_adyacentes = g.Adyacentes(vertice);
				while (!aux_adyacentes.conjuntoVacio()){
					aux_vertice = aux_adyacentes.elegir();
					aux_adyacentes.sacar(aux_vertice);
					if ( aux_vertice > vertice ){// este if es para no agregar (2 ,3) y (3 ,2)
						aux_par = new Par ();
						aux_par.valor1 = vertice ;
						aux_par.valor2 = aux_vertice ;
						aristas.AgregarElemento ( aux_par , g.PesoArista ( vertice , aux_vertice ));
				    }
				}
			}
			cantidad_pendientes = cantidad ;
			// mientras haya mas de un conjunto
			while ( cantidad_pendientes >1){
			// tomo la arista mas liviana
				aux_par = aristas.RecuperarMinElemento ();
			// busco a que conjunto pertenece cada vertice de la arista
				for (i = 0; i < cantidad ; i++){
					if ( conjuntos.recuperarElemento(i).valor1 == aux_par.valor1 ){
						c1 = conjuntos.recuperarElemento (i). valor2 ;
					}
					if ( conjuntos.recuperarElemento(i).valor1 == aux_par.valor2 ){
						c2 = conjuntos.recuperarElemento(i).valor2 ;
					}
				}
				// si pertenecen a distintos conjuntos.
				if (c1 != c2){
				// unifico los conjuntos
					for (i = 0;i< cantidad ;i++){
						if ( conjuntos.recuperarElemento(i).valor2 == c2){
							 conjuntos.recuperarElemento(i).valor2 = c1;
						}
					}
				// agrego la arista al resultado
					resultado.AgregarArista ( aux_par.valor1 , aux_par.valor2 , ( int ) aristas.RecuperarMinPrioridad());
					cantidad_pendientes --;
				}
				aristas.EliminarMinPrioridad ();
			}
	return resultado ;
	}
}
