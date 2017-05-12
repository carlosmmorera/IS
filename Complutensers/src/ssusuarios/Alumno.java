package ssusuarios;
import java.util.ArrayList;
import java.util.List;

import ssactividades.Actividad;

public class Alumno extends UsuarioConLog {
    public Alumno(String nombre, String password) {
		super(nombre, password);
	}

	private List<Agrupacion> agrupaciones = new ArrayList<Agrupacion> ();

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
