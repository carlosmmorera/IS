package ssusuarios;
import java.util.ArrayList;
import java.util.List;

import ssbuscador.Buscable;

public class Agrupacion extends UsuarioConLog implements Buscable {
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
