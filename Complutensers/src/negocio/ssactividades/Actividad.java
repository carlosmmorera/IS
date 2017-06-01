package negocio.ssactividades;
import java.util.ArrayList;
import java.util.List;

import negocio.ssactividades.map.Lugar;
import negocio.ssbuscador.Buscable;
import negocio.ssusuarios.Agrupacion;
import negocio.ssusuarios.Alumno;

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

	public Fecha getFecha(){
		return fecha;
	}
	
	public Agrupacion getAgrupacion(){
		return agrupacion;
	}

	public String toString(){
		return nombre + '\n' + descripcion +  '\n';
	}
	public String guardar(){
		String guardar=nombre +'\n'+descripcion+'\n';
		for(int i=0;i<palabrasClave.size()-1;++i)guardar+=palabrasClave.get(i)+" ";
		guardar+=palabrasClave.get(palabrasClave.size()-1)+'\n';
		guardar+=lugar.getDireccion()+'\n';
		guardar+=fecha.guardar()+'\n';
		for(int i=0;i<alumnosInscritos.size()-1;++i)guardar+=alumnosInscritos.get(i).getName()+" ";
		if(!alumnosInscritos.isEmpty())guardar+=alumnosInscritos.get(alumnosInscritos.size()-1).getName();
		guardar+='\n';
		guardar+=agrupacion.getName()+'\n';
		if(verificada)guardar+="VERIFICADA";
		else guardar+="NO VERIFICADA";
		guardar+='\n';
		return guardar;
	}
}
