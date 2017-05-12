package ssactividades;
import java.util.ArrayList;
import java.util.List;

import ssactividades.map.Lugar;
import ssbuscador.Buscable;
import ssusuarios.Agrupacion;
import ssusuarios.Alumno;

public class Actividad extends Evento implements Buscable {
    public Actividad(String name, String description, ArrayList<String> keyWords,
    		ArrayList<Lugar> places, ArrayList<Fecha> dates) {
		super(name, description, keyWords, places, dates);
		// TODO Auto-generated constructor stub
	}


	private boolean verificada;
    private Agrupacion agrupacion;

    public List<Alumno> alumnosInscritos = new ArrayList<Alumno> ();


	public void verificar() {
		verificada = true;
		
	}



}
