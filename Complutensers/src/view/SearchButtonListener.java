package view;

import java.util.ArrayList;

import ssactividades.Actividad;
import ssusuarios.Agrupacion;

public interface SearchButtonListener {
		public ArrayList<Actividad> buscarActividad(String keyWords);
		public ArrayList<Agrupacion> buscarAgrupacion(String keyWords);
		public ArrayList<Actividad> buscarIniciativa(String keyWords);
}
