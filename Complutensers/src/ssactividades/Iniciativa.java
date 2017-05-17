package ssactividades;

import java.util.ArrayList;
import java.util.List;

import ssactividades.map.Lugar;
import ssbuscador.Buscable;
import ssusuarios.Alumno;


public class Iniciativa extends Evento implements Buscable {
	public Alumno alumno;

	public Iniciativa(String nombre, Lugar lugar, Fecha fecha,String descripcion,
			Alumno alumno,ArrayList<String> palabrasClave) {
		super(nombre,descripcion,palabrasClave,lugar,fecha);
		this.alumno = alumno;
	}

}
