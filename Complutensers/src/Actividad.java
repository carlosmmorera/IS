import java.util.ArrayList;
import java.util.List;

public class Actividad extends Evento implements Buscable {
    private boolean verificada;
    private Agrupacion agrupacion;

    public List<Alumno> alumnosInscritos = new ArrayList<Alumno> ();

    public void insertarEnBuscador() {
    }

	public void verificar() {
		verificada = true;
		
	}

}
