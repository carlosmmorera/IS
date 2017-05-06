import java.util.ArrayList;
import java.util.List;

public class Evento {
    private String nombre;
    private String descripcion;
    private String[] palabrasClave;
    private List<Lugar> lugar = new ArrayList<Lugar> ();
    private List<Fecha> fecha = new ArrayList<Fecha> ();
    /**
     * Constructor
     * @param name
     * @param description
     * @param keyWords
     * @param places
     * @param dates
     */
    public Evento(String name, String description, String[] keyWords,
    		List<Lugar> places, List<Fecha> dates){
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
    public void modificarFecha(List<Fecha> date) {
    	fecha = date;
    }
    /**
     * Modifies the place.
     * @param places
     */
    public void modificarLugar(List<Lugar> places) {
    	lugar = places;
    }

    public void modificarBuscador() {
    	//I do not know what should it does.
    }
    /**
     * Modifies the key words.
     * @param keyWords
     */
    public void modificarPalabrasClave(String[] keyWords) {
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
}
