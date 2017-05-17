package ssusuarios;
import java.util.ArrayList;
import java.util.List;

import ssactividades.Actividad;

public class Alumno extends UsuarioConLog {
	private List<Agrupacion> agrupaciones = new ArrayList<Agrupacion> ();
	
    public Alumno(String nombre, String password,String[] actIni) {
		super(nombre, password,actIni);
	}

    public void apuntarseActividad(Actividad a) {
        actividadesPendientes.add(a);
    }

    public void apuntarseAsociacion(Agrupacion a) {
       agrupaciones.add(a);
    }

    public void accederHistorial() {
    	//not implemented
    }

    public void accederActividadRecomendada() {
    	//not implemented
    }

    public void crearAgrupacion() {
    	//not implemented
    }

	@Override
	public void AccederMapaGeneral() {
		//not implemented
	}

}
