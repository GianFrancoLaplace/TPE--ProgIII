package tpe;

import java.util.ArrayList;
import java.util.Objects;

public class Procesador {
    
    private String id_procesador;
    private String codigo_procesador;
    private Boolean esta_refrigerado;
    private Integer anio_funcionamiento;
    private int tareasCriticas;
    private ArrayList<Tarea> tareas;
    
    public Procesador(String id_procesador, String codigo_procesador, Boolean esta_refrigerado,
            Integer anio_funcionamiento) {
        this.id_procesador = id_procesador;
        this.codigo_procesador = codigo_procesador;
        this.esta_refrigerado = esta_refrigerado;
        this.anio_funcionamiento = anio_funcionamiento;
        this.tareas = new ArrayList<>();
    }

    public ArrayList<Tarea> getTareas() {
        ArrayList<Tarea> retorno = new ArrayList<>();
        for (Tarea t : tareas) {
            retorno.add(t.getCopia());
        } return retorno;
    }

    public Procesador getCopia(){
        Procesador copia = new Procesador(id_procesador, codigo_procesador, esta_refrigerado, anio_funcionamiento);
        for (Tarea t : tareas) { // itera las copias
            copia.asignarTarea(t.getCopia());
        } return copia;
    }

    public void asignarTarea(Tarea tarea) {
        tareas.add(tarea);
        if (tarea.esCritica()) {
            tareasCriticas++;
        }
    }

    public void quitarTarea(Tarea tarea) {
        tareas.remove(tarea);
        if (tarea.esCritica()) {
            tareasCriticas--;
        }
    }

    public boolean puedeAsignarTarea(Tarea tarea, int tiempoMax) {
        if (!this.isRefrigerado() && (this.getTiempoEjecucion() + tarea.getTiempo_ejecucion() > tiempoMax)) {
            return false;
        }
        if (tarea.esCritica() && this.getTareasCriticas() >= 2) {
            return false;
        }
        return true;
    }

    public int getTiempoEjecucion() {
        int tiempoEjecucion = 0;
        for (int i = 0; i < tareas.size(); i++) {
            tiempoEjecucion+= tareas.get(i).getTiempo_ejecucion();
        }return tiempoEjecucion;
    }

    public boolean isRefrigerado() {
        return esta_refrigerado;
    }

    public int getTareasCriticas() {
        return tareasCriticas;
    }

    @Override
    public String toString() {
        return "Procesador [id_procesador=" + id_procesador + ", esta_refrigerado=" + esta_refrigerado
                + ", tareasCriticas=" + tareasCriticas + ", tareas=" + tareas + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Procesador that = (Procesador) o;
        return tareasCriticas == that.tareasCriticas && Objects.equals(id_procesador, that.id_procesador) && Objects.equals(codigo_procesador, that.codigo_procesador) && Objects.equals(esta_refrigerado, that.esta_refrigerado) && Objects.equals(anio_funcionamiento, that.anio_funcionamiento) && Objects.equals(tareas, that.tareas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_procesador, codigo_procesador, esta_refrigerado, anio_funcionamiento, tareasCriticas, tareas);
    }
}
