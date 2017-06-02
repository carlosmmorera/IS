package negocio.ssusuarios;
import java.util.ArrayList;
import java.util.List;

import negocio.ssactividades.Actividad;

public class Alumno extends UsuarioConLog {
	private List<Agrupacion> agrupaciones = new ArrayList<Agrupacion> ();
	
    public Alumno(String nombre, String password,String[] actIni) {
		super(nombre, password,actIni);
	}

    public boolean apuntarseActividad(Actividad a) {
    	if(!actividadesPendientes.contains(a)){
    		actividadesPendientes.add(a);
    		a.apuntarAlumno(this);
    		return true;
    	}
    	else
    		return false;
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
    
	public void AccederMapaGeneral() {
		//not implemented
	}
	public String guardar(){
		String guardar=nombre+'\n'+password+'\n';
		for(int i=0;i<actividadesPendientes.size()-1;++i)guardar+=actividadesPendientes.get(i).getName()+" ";
		if(!actividadesPendientes.isEmpty())guardar+=actividadesPendientes.get(actividadesPendientes.size()-1).getName();
		guardar+='\n';
		return guardar;
	}
}
