package tpe;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Estado {
    private List<Procesador> procesadores;
    private List<Tarea> tareas;
    private int indexTareaActual = 0;


    public Estado(List<Procesador> procesadores, List<Tarea> tareas, int indexTareaActual) {
        this.procesadores = new LinkedList<>(procesadores);
        this.tareas = new LinkedList<>(tareas);
        this.indexTareaActual = indexTareaActual;
    }

    public int getIndexTareaActual() {
        return indexTareaActual;
    }

    public void setIndexTareaActual(int indexTareaActual) {
        this.indexTareaActual = indexTareaActual;
    }

    public List<Tarea> getTareas() {
        return new LinkedList<>(tareas);
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }

    public List<Procesador> getProcesadores() {
        return new LinkedList<>(procesadores);
    }

    public void asignar(Tarea tarea, Procesador procesador) { procesador.asignarTarea(tarea); }

    public void designar(Tarea tarea, Procesador procesador) { procesador.quitarTarea(tarea); }

    public boolean quedanTareas() { return indexTareaActual < tareas.size();}

    public int getTiempoEjecucion(){
        int mayorTiempo = 0;
        for (Procesador procesador : procesadores) {
            if (procesador.getTiempoEjecucion()>mayorTiempo){
                mayorTiempo = procesador.getTiempoEjecucion();
            }
        }
        return mayorTiempo;
    }

    public Solucion getSolucion(){
        Solucion sol = new Solucion(this.getTiempoEjecucion());
        for(Procesador procesador : procesadores){
            sol.addProcesador(procesador.getCopia());
        }
        return sol;
    }

    public Iterator<Procesador> getProcesadoresIterator(){ return this.procesadores.iterator(); }

    public Tarea getTareaActual(){
        return tareas.get(this.indexTareaActual);
    }

    public void avanzarTarea(){this.indexTareaActual++;}

    public void retrocederTarea(){this.indexTareaActual--;}
}
