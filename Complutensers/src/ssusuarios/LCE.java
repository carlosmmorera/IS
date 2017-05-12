package ssusuarios;
import java.util.ArrayList;

import ssactividades.Actividad;


public class LCE extends Agrupacion {
    public void verificarRegistro() {
    	
    }

    public void verificarActividades() {
    	//TODO DAO Obtener actividades sin verificar
    	ArrayList<Actividad> sinVerificar = null;
    	for(Actividad a :sinVerificar){
    		//TODO mostrar actividad en pantalla
    		//esperar al listener del boton (aceptar o rechazar)
    	}
    }
    //el listener del boton aceptar llama aqui
	public void verficarActividad(Actividad a) {		
		a.verificar();	
		//TODO insertar en buscador
	}

}
