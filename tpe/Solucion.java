package tpe;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solucion {
    public List<Procesador> procesadores;
    int tiempoEjecucion;
    int candidatosConsiderados;
    int cantEstadosGenerados;

    public Solucion(){
        this.procesadores = new ArrayList<>();
        this.tiempoEjecucion = 0;
        this.candidatosConsiderados = 0;
        this.cantEstadosGenerados = 0;
    }
    public Solucion(int tiempoEjecucion) {
        this.procesadores = new LinkedList<>();
        this.tiempoEjecucion = tiempoEjecucion;
        this.candidatosConsiderados = 0;
        this.cantEstadosGenerados = 0;
    }

    public int getTiempoEjecucion() {
        return tiempoEjecucion;
    }

    public void setTiempoEjecucion(int tiempoEjecucion) {
        this.tiempoEjecucion = tiempoEjecucion;
    }

    public List<Procesador> getProcesadores() {
        ArrayList<Procesador> listaProcesadores = new ArrayList<>();
        for (Procesador procesador : procesadores) {
            listaProcesadores.add(procesador.getCopia());
        }
        return listaProcesadores;
    }

    public void addProcesador(Procesador p){
        procesadores.add(p);
    }

    public int getCandidatosConsiderados() {
        return candidatosConsiderados;
    }

    public void setCandidatosConsiderados(int candidatosConsiderados) {
        this.candidatosConsiderados = candidatosConsiderados;
    }

    /*

    No funciona...


    public boolean puedeAsignarTarea(Procesador procesador, Tarea tarea, int tiempoMax){
        int i = 0;
        while (i < procesadores.size() && !procesadores.get(i).equals(procesador)) {
            i++;
        }if (i == procesadores.size()){ i--; }
        return procesadores.get(i).puedeAsignarTarea(tarea, tiempoMax);
    }

    public void asignarTarea(Procesador procesador, Tarea tarea){
        int i = procesadores.indexOf(procesador);
        procesadores.get(i).asignarTarea(tarea);
    }
    */

    public int getCantEstadosGenerados() {
        return cantEstadosGenerados;
    }

    public void setCantEstadosGenerados(int cantEstadosGenerados) {
        this.cantEstadosGenerados = cantEstadosGenerados;
    }
    @Override
    public String toString() {
        String str = "Solucion {" ;
        for(Procesador p : procesadores){
            str += p.toString() + "\n";
        }
        return str + "}";
    }
}
