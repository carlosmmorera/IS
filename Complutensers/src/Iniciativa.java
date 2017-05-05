
public class Iniciativa extends Evento implements Buscable {
	public Alumno alumno;
	private String nombre;
	private Lugar lugar;
	private Fecha fecha;
	private Hora hora;
	private String descripcion;

	public Iniciativa() {
		this.nombre = "";
		this.lugar = new Lugar();
		this.fecha = new Fecha();
		this.hora = new Hora();
		this.descripcion = "";
		this.alumno = new Alumno();
	}


	public Iniciativa(String nombre, Lugar lugar, Fecha fecha, Hora hora, 
			String descripcion, Alumno alumno) {
		this.nombre = nombre;
		this.lugar = lugar;
		this.fecha = fecha;
		this.hora = hora;
		this.descripcion = descripcion;
		this.alumno = alumno;
	}

	public Iniciativa crearIniciativa() {
		//Muestra ventana y obtiene datos necesarios 
		return new Iniciativa();
	}

	public void insertarEnBuscador() {
		
	}
}
