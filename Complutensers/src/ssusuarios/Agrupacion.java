package ssusuarios;
import java.util.ArrayList;

import ssbuscador.Buscable;

public class Agrupacion extends UsuarioConLog implements Buscable {
    public Agrupacion(String nombre, String password,String[]actIni,ArrayList<String> pc) {
		super(nombre, password,actIni);
		palabrasClave=pc;
	}


	private ArrayList<Alumno> alumno = new ArrayList<Alumno> ();
    private ArrayList<String> palabrasClave;
    
    public void accederHistorial() {
    }

    
	public void AccederMapaGeneral() {
	}


	@Override
	public ArrayList<String> obtenerPalabrasClave() {
		return palabrasClave;
	}
	public void apuntarAlumno(Alumno a){
		alumno.add(a);
	}


	@Override
	public String getDescription() {
		return nombre;
	}

}
