package ssusuarios;
import java.util.ArrayList;
import ssactividades.*;
import ssactividades.map.Lugar;
import ssbuscador.Buscable;

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
	public void apuntarAlumno(Alumno a){
		alumno.add(a);
	}
	//La actividad que devuelve es para añadirla al array de actividades del DAO
	public Actividad crearActividad(String name,String desc,String keyWords,
			String place,String fecha){
		String[]pcSplit=keyWords.split(" ");
		ArrayList<String> pcList=new ArrayList<String>();
		for(int i=0;i<pcSplit.length;++i)pcList.add(pcSplit[i]);
		Actividad act=new Actividad(name,desc,pcList,new Lugar(place),
				new Fecha(fecha),this,"NO VERIFICADA");
		actividadesPendientes.add(act);
		return act;
	}

	@Override
	public String getDescription() {
		return nombre;
	}

}
