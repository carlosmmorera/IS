package ssactividades;
import java.util.ArrayList;
import java.util.List;

import ssactividades.map.Lugar;
import ssbuscador.Buscable;
import ssusuarios.Agrupacion;
import ssusuarios.Alumno;

public class Actividad extends Evento implements Buscable {
    public Actividad(String name, String description, ArrayList<String> keyWords,
    		Lugar places, Fecha dates,Agrupacion agr,String verified) {
		super(name, description, keyWords, places, dates);
		if(verified.equalsIgnoreCase("Verificada"))verificada=true;
		else verificada=false;
		agrupacion=agr;
	}


	private boolean verificada;
    private Agrupacion agrupacion;
    private List<Alumno> alumnosInscritos = new ArrayList<Alumno> ();


	public void verificar() {
		verificada = true;
	}

	public void apuntarAlumno(Alumno al){
		alumnosInscritos.add(al);
	}

}
