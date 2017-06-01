package negocio.ssusuarios;
import java.util.ArrayList;

import negocio.ssactividades.Actividad;


public class LCE extends Agrupacion {
    public LCE(String nombre, String password,String[] actIni,ArrayList<String>pc) {
		super(nombre, password,actIni,pc);
		
	}

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
