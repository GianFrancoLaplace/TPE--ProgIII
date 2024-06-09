package tpe;



public class Main {

	public static void main(String args[]) {
		Servicios servicios = new Servicios("TPE--ProgIII/src/tpe/datasets/Procesadores.csv", "TPE--ProgIII/src/tpe/datasets/Tareas.csv");
        /*Timer timer4 = new Timer();
        timer4.start();
        System.out.println("SERVICIO 1" + servicios.servicio1("T2"));
        System.out.println(timer4.stop());
        System.out.println();
        Timer timer3 = new Timer();
        timer3.start();
        System.out.println("SERVICIO 2" + servicios.servicio2(true));
        System.out.println(timer3.stop());
        System.out.println();
        Timer timer = new Timer();
        timer.start();
        System.out.println("SERVICIO 3" + servicios.servicio3(2, 69));
        System.out.println(timer.stop());
        System.out.println();
        Timer timer2 = new Timer();
        timer2.start();
        System.out.println("SERVICIO 4" + servicios.servicio4(2, 69));
        System.out.println(timer2.stop());
        System.out.println(); */
        System.out.println("SERVICIO BACK" + servicios.ServicioBack(150));
        System.out.println();
        System.out.println("SERVICIO GREEDY" + servicios.ServicioGreedy(150));
    }
}
