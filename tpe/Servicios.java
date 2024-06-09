package tpe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

import tpe.utils.CSVReader;

/**
 * NO modificar la interfaz de esta clase ni sus métodos públicos.
 * Sólo se podrá adaptar el nombre de la clase "Tarea" según sus decisiones
 * de implementación.
 */
public class Servicios {

	private HashMap<String , Tarea> tareasPorID;
	private ArrayList<Tarea> criticas;
	private ArrayList<Tarea> noCriticas;
	private TreeMap<Integer, ArrayList<Tarea>> tareasPorPrioridad;
	private List<Procesador> procesadores;
	private ArrayList<Tarea> tareas;

	private HashMap<Integer, ArrayList<Tarea>> tareasPorPrioridadHASH;
	/*
	 * Expresar la complejidad temporal del constructor.
	 */
	//COMPLEJIDAD O(M + N) DONDE M ES NUMERO DE PROCESADORES Y N ES NUMERO DE TAREAS
	//QUE SE VAN LEYENDO 1 A 1 CON EL FOR IMPLEMENTADO EN CSVREADER
	public Servicios(String pathProcesadores, String pathTareas) {
		this.tareasPorID = new HashMap<>();
        this.criticas = new ArrayList<>();
        this.noCriticas = new ArrayList<>();
        this.tareasPorPrioridad = new TreeMap<>();
		this.tareasPorPrioridadHASH = new HashMap<>();
		this.procesadores = new LinkedList<>();
		this.tareas = new ArrayList<>();
		CSVReader.readProcessors(pathProcesadores, procesadores);
		CSVReader.readTasks(pathTareas, tareasPorID, criticas, noCriticas, tareasPorPrioridad, tareasPorPrioridadHASH, tareas);
		
	}

	/*
	 * Expresar la complejidad temporal del servicio 1.
	 */
	//COMPLEJIDAD PROMEDIO O(1) PARA BUSCAR EN HASHMAP
	public Tarea servicio1(String ID) {
		Tarea id = tareasPorID.get(ID);
		return id;
	}

	/*
	 * Expresar la complejidad temporal del servicio 2.
	 */
	//COMPLEJIDAD O(n) DONDE N ES LA CANTIDAD DE ELEMENTOS DE LA LISTA 
	public List<Tarea> servicio2(boolean esCritica) {
		return esCritica ? new ArrayList<>(criticas) : new ArrayList<>(noCriticas);
	}

	/*
	 * Expresar la complejidad temporal del servicio 3.
	 */
	//COMPLEJIDAD O(LOG N) PARA ENCONTRAR LOS VALORES EN EL TREEMAP
	//COMPLEJIDAD O(M) PARA COPIAR LOS VALORES A LA LISTA, DONDE M ES EL NÚMERO DE ELEMENTOS DEL SUBMAP
	//COMPLEJIDAD DEL SERVICIO: O(LOG N + M)
	public List<Tarea> servicio3(int prioridadInferior, int prioridadSuperior) {
		ArrayList<Tarea> retorno = new ArrayList<>();

		for( ArrayList<Tarea> tareas : tareasPorPrioridad.subMap(prioridadInferior, true, prioridadSuperior, true).values()) {
			retorno.addAll(tareas);
		}
		return retorno;

	}

	public List<Tarea> servicio4(int prioridadInferior, int prioridadSuperior) {
		Iterator<Integer> it = tareasPorPrioridadHASH.keySet().iterator();
		ArrayList<Tarea> retorno = new ArrayList<>();
		
		while(it.hasNext()){
			Integer clave = it.next();
			if(clave >= prioridadInferior && clave <= prioridadSuperior){
				retorno.addAll(tareasPorPrioridadHASH.get(clave));
			}			
		}

		return retorno;

	}

	public Solucion ServicioBack(int tiempoMaximo){

		AsingarTareaProcesadorBacktracking back = new AsingarTareaProcesadorBacktracking(procesadores, tareas, tiempoMaximo);
		return back.backtracking();
	}

	public Solucion ServicioGreedy(int tiempoMaximo){

		AsignarTareaProcesadorGreedy g = new AsignarTareaProcesadorGreedy(procesadores, tareas, tiempoMaximo);
		return g.greedy();
	}
}
