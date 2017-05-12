package ssbuscador;
import java.util.ArrayList;
import java.util.List;

import ssactividades.Actividad;
import ssactividades.Iniciativa;
import ssusuarios.Agrupacion;

public class PalabraClave {
    private String palabra;

    public List<Iniciativa> arrayIniciativa = new ArrayList<Iniciativa> ();

    public List<Actividad> arrayActividad = new ArrayList<Actividad> ();

    public List<Agrupacion> arrayAgrupacion = new ArrayList<Agrupacion> ();
    
    public PalabraClave(String palabra) {
		this.palabra = palabra;
	}
    
    public String getPalabra(){
    	return palabra;
    }
    public void insertarActividad(Actividad a){
    	arrayActividad.add(a);
    }
    public void insertarIniciativa(Iniciativa a){
    	arrayIniciativa.add(a);
    }
    public void insertarAgrupacion(Agrupacion a){
    	arrayAgrupacion.add(a);
    }
    
    public List<Iniciativa> getIniciativas(){
    	return arrayIniciativa;
    }
    public List<Actividad> getActividades(){
    	return arrayActividad;
    }
    public List<Agrupacion> getAgrupaciones(){
    	return arrayAgrupacion;
    }
    //TODO Metodos para eliminar
    public void eliminarActividad(Actividad a){
    	arrayActividad.remove(a); 
    }
	

}
