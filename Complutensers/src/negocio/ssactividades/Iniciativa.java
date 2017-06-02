package negocio.ssactividades;

import java.util.ArrayList;
import java.util.List;

import negocio.ssactividades.map.Lugar;
import negocio.ssbuscador.Buscable;
import negocio.ssusuarios.Alumno;


public class Iniciativa extends Evento implements Buscable {
	public Alumno alumno;

	public Iniciativa(String nombre, Lugar lugar, Fecha fecha,String descripcion,
			Alumno alumno,ArrayList<String> palabrasClave) {
		super(nombre,descripcion,palabrasClave,lugar,fecha);
		this.alumno = alumno;
	}
	public String guardar(){
		String guardar=nombre +'\n'+descripcion+'\n';
		for(int i=0;i<palabrasClave.size()-1;++i)guardar+=palabrasClave.get(i)+" ";
		guardar+=palabrasClave.get(palabrasClave.size()-1)+'\n';
		guardar+=lugar.getDireccion()+'\n';
		guardar+=fecha.guardar()+'\n';
		guardar+=alumno.getName()+'\n';
		return guardar;
	}
	@Override
	protected String desc() {
		return descripcion+"\nFecha: "+fecha.toString()+"\nLugar: "+ lugar.getDireccion()
				+ "\nInciativa propuesta por: " + alumno.getName();
	}
}
