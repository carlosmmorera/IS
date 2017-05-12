package ssactividades;
import java.util.ArrayList;
import java.util.List;

import ssactividades.map.Lugar;
import ssbuscador.Buscable;

public class Evento implements Buscable{
    private String nombre;
    private String descripcion;
    private ArrayList<String> palabrasClave=new ArrayList<String>();
    private ArrayList<Lugar> lugar = new ArrayList<Lugar> ();
    private ArrayList<Fecha> fecha = new ArrayList<Fecha> ();
    /**
     * Constructor
     * @param name
     * @param description
     * @param keyWords
     * @param places
     * @param dates
     */
    public Evento(String name, String description, ArrayList<String> keyWords,
    		ArrayList<Lugar> places, ArrayList<Fecha> dates){
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
    public void modificarFecha(ArrayList<Fecha> date) {
    	fecha = date;
    }
    /**
     * Modifies the place.
     * @param places
     */
    public void modificarLugar(ArrayList<Lugar> places) {
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
}
