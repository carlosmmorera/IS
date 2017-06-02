package negocio.ssactividades;
import java.util.ArrayList;
import java.util.List;

import negocio.ssactividades.map.Lugar;
import negocio.ssbuscador.Buscable;

public abstract class Evento implements Buscable{
    protected String nombre;
    protected String descripcion;
    protected ArrayList<String> palabrasClave=new ArrayList<String>();
    //private ArrayList<Lugar> lugar = new ArrayList<Lugar> ();
    //private ArrayList<Fecha> fecha = new ArrayList<Fecha> ();
    Lugar lugar;
    Fecha fecha;
    /**
     * Constructor
     * @param name
     * @param description
     * @param keyWords
     * @param places
     * @param dates
     */
    public Evento(String name, String description, ArrayList<String> keyWords,
    		Lugar places, Fecha dates){
    	nombre = name;
    	descripcion = description;
    	palabrasClave = keyWords;
    	lugar = places;
    	fecha = dates;
    }
    /**
     * Modifies the date.
     * @param date
     */
    public void modificarFecha(Fecha date) {
    	fecha = date;
    }
    /**
     * Modifies the place.
     * @param places
     */
    public void modificarLugar(Lugar places) {
    	lugar = places;
    }

    public void modificarBuscador() {
    	//I do not know what should it does.
    }
    /**
     * Modifies the key words.
     * @param keyWords
     */
    public void modificarPalabrasClave(ArrayList<String> keyWords) {
    	palabrasClave = keyWords;
    }
    /**
     * Modifies the description.
     * @param description
     */
    public void modificarDescripcion(String description) {
    	descripcion = description;
    }
    /**
     * Modifies the name.
     * @param name
     */
    public void ModificarNombre(String name) {
    	nombre = name;
    }
	@Override
	public ArrayList<String> obtenerPalabrasClave() {
		return palabrasClave;
	}
	@Override
	public String getName() {
		return nombre;
	}
	
	public Lugar getLugar(){
		return lugar;
	}
	@Override
	public String getDescription() {
		return desc();
	}
	
	protected abstract String desc();
}
