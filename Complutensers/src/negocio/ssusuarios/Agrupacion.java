package negocio.ssusuarios;
import java.util.ArrayList;

import negocio.ssactividades.*;
import negocio.ssactividades.map.Lugar;
import negocio.ssbuscador.Buscable;

public class Agrupacion extends UsuarioConLog implements Buscable {
    public Agrupacion(String nombre, String password,String[]actIni,ArrayList<String> pc) {
		super(nombre, password,actIni);
		palabrasClave=pc;
	}


	private ArrayList<Alumno> alumno = new ArrayList<Alumno> ();
    private ArrayList<String> palabrasClave;
    
    public void accederHistorial() {
    }

    
	public void AccederMapaGeneral() {
	}


	@Override
	public ArrayList<String> obtenerPalabrasClave() {
		return palabrasClave;
	}
	public boolean apuntarAlumno(Alumno a){
		if (alumno.contains(a)){
			return false;
		}
		else{
			alumno.add(a);
			a.apuntarseAsociacion(this);
			return true;
		}
		
	}
	public void apuntarActividad(Actividad a){
		actividadesPendientes.add(a);
	}
	//La actividad que devuelve es para añadirla al array de actividades del DAO
	public Actividad crearActividad(String name,String desc,String keyWords,
			String place,Fecha fecha){
		String[]pcSplit=keyWords.split(" ");
		ArrayList<String> pcList=new ArrayList<String>();
		for(int i=0;i<pcSplit.length;++i)pcList.add(pcSplit[i]);
		Actividad act=new Actividad(name,desc,pcList,new Lugar(place),
				fecha,this,"NO VERIFICADA");
		actividadesPendientes.add(act);
		
		return act;
	}

	@Override
	public String getDescription() {
		String listaUsuarios = "\nUsuarios apuntados a esta agrupación:\n";
		for (Alumno a : alumno)
			listaUsuarios += "- " + a.getName() + "\n";
		return nombre + listaUsuarios;
	}
	public String guardar(){
		String guardar=nombre +'\n'+password+'\n';
		for(int i=0;i<actividadesPendientes.size()-1;++i)guardar+=actividadesPendientes.get(i).getName()+" ";
		if(!actividadesPendientes.isEmpty())guardar+=actividadesPendientes.get(actividadesPendientes.size()-1).getName();
		guardar+='\n';
		for(int i=0;i<alumno.size()-1;++i)guardar+=alumno.get(i).getName()+" ";
		if(!alumno.isEmpty())guardar+=alumno.get(alumno.size()-1).getName();
		guardar+='\n';
		for(int i=0;i<palabrasClave.size()-1;++i)guardar+=palabrasClave.get(i)+" ";
		guardar+=palabrasClave.get(palabrasClave.size()-1)+'\n';		
		return guardar;
	}

}
