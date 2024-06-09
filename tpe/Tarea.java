package tpe;

public class Tarea implements Comparable<Tarea> {
    private String id_tarea;
    private String nombre_tarea;
    private Integer tiempo_ejecucion;
    private Boolean es_critica;
    private Integer nivel_prioridad;
    
    public Tarea(String id_tarea, String nombre_tarea, Integer tiempo_ejecucion, Boolean es_critica,
            Integer nivel_prioridad) {
        this.id_tarea = id_tarea;
        this.nombre_tarea = nombre_tarea;
        this.tiempo_ejecucion = tiempo_ejecucion;
        this.es_critica = es_critica;
        this.nivel_prioridad = nivel_prioridad;
    }
    public int getTiempo_ejecucion() {
        return tiempo_ejecucion;
    }

    public boolean esCritica() {
        return es_critica;
    }

    @Override
    public int compareTo(Tarea otraTarea) {

        if (this.esCritica() && !otraTarea.esCritica()) {
            return -1;
        }
        if (!this.esCritica() && otraTarea.esCritica()){
            return 1;
        }else{
            return otraTarea.getTiempo_ejecucion() - this.tiempo_ejecucion; // Orden descendente
        }
    }

    public Tarea getCopia(){
        return new Tarea(id_tarea,nombre_tarea,tiempo_ejecucion,es_critica,nivel_prioridad);
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "id_tarea='" + id_tarea + '\'' +
                ", nombre_tarea='" + nombre_tarea + '\'' +
                ", tiempo_ejecucion=" + tiempo_ejecucion +
                ", es_critica=" + es_critica +
                ", nivel_prioridad=" + nivel_prioridad +
                '}';
    }
}
