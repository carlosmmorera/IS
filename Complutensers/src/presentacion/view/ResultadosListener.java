package presentacion.view;

import negocio.ssactividades.Actividad;
import negocio.ssusuarios.Agrupacion;

public interface ResultadosListener {
	
	void apuntarseAct(Actividad a);

	void apuntarseAgrup(Agrupacion elem);
	
}
