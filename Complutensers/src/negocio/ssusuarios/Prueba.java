package negocio.ssusuarios;

import java.util.ArrayList;

import negocio.ssactividades.Actividad;
import negocio.ssactividades.Fecha;
import negocio.ssactividades.map.Lugar;

public class Prueba {

	public static void main(String...args){
		String[] s = {"volley", "futbol", "bacanales"};
		Alumno a = new Alumno("Paco", "123456", s);
		Actividad ac = new Actividad("actividasa", "pues esta es la nueva actividad loko", 
				new ArrayList<String> (), new Lugar("mates"), new Fecha(1, 1, 1, null), 
				new Agrupacion(null, null, s, null), "Verificada");

		a.apuntarseActividad(ac);
		Actividad act = new Actividad("eee", "jijijijijiji", 
				new ArrayList<String> (), new Lugar("mates"), new Fecha(1, 1, 1, null), 
				new Agrupacion(null, null, s, null), "Verificada");

		a.apuntarseActividad(act);
		System.out.println(ac);

		System.out.println(a);
		System.out.println(a.actividadesPendientes);

	}
}
