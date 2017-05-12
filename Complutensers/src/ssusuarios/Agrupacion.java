package ssusuarios;
import java.util.ArrayList;

import ssbuscador.Buscable;

public class Agrupacion extends UsuarioConLog implements Buscable {
    public Agrupacion(String nombre, String password) {
		super(nombre, password);
		// TODO Auto-generated constructor stub
	}


	private ArrayList<Alumno> alumno = new ArrayList<Alumno> ();
    private ArrayList<String> palabrasClave=new ArrayList<String>();
    
    public void accederHistorial() {
    }

    
	public void AccederMapaGeneral() {
	}


	@Override
	public ArrayList<String> obtenerPalabrasClave() {
		return palabrasClave;
	}

}
