package ssbuscador;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import ssactividades.Actividad;
import ssactividades.Iniciativa;
import ssusuarios.Agrupacion;

public class Buscador {
	public List<PalabraClave> palabrasClave = new ArrayList<PalabraClave>();
	private static Buscador instance = null;

	private Buscador(){
		
	}
	
	public static Buscador getInstancia(){
		if(instance==null){
			instance=new Buscador();
		}
		return instance;
		
	}

	private int busquedaBinaria(String palabra, int ini, int fin) {
		if (ini > fin) {
			return -1;
		}
		int mitad = (ini + fin) / 2;
		int aux = palabrasClave.get(mitad).getPalabra()
				.compareToIgnoreCase(palabra);
		if (aux < 0) {
			return busquedaBinaria(palabra, mitad + 1, fin);
		} else if (aux > 0) {
			return busquedaBinaria(palabra, ini, mitad - 1);
		} else {
			return mitad;
		}

	}

	public void insertarActividad(final Actividad act) {
		ArrayList<String> pc = act.obtenerPalabrasClave();
		for (String palabra : pc) {
			int pos = busquedaBinaria(palabra, 0, palabrasClave.size()-1);
			if (pos < 0) {
				PalabraClave nueva = new PalabraClave(palabra);
				palabrasClave.add(nueva);
				int i = palabrasClave.size() - 1;
				while (i > 0
						&& palabrasClave.get(i - 1).getPalabra()
								.compareToIgnoreCase(palabra) > 0) {
					palabrasClave.set(i, palabrasClave.get(i - 1));
					--i;
				}
				nueva.insertarActividad(act);
				palabrasClave.set(i, nueva);
			} else {
				palabrasClave.get(pos).insertarActividad(act);
			}
		}
	}

	public void insertarIniciativa(final Iniciativa ini) {
		ArrayList<String> pc = ini.obtenerPalabrasClave();
		for (String palabra : pc) {
			int pos = busquedaBinaria(palabra, 0, palabrasClave.size()-1);
			if (pos < 0) {
				PalabraClave nueva = new PalabraClave(palabra);
				palabrasClave.add(nueva);
				int i = palabrasClave.size() - 1;
				while (i > 0
						&& palabrasClave.get(i - 1).getPalabra()
								.compareToIgnoreCase(palabra) > 0) {
					palabrasClave.set(i, palabrasClave.get(i - 1));
					--i;
				}
				nueva.insertarIniciativa(ini);
				palabrasClave.set(i, nueva);
			} else {
				palabrasClave.get(pos).insertarIniciativa(ini);
			}
		}
	}

	public void insertarAgrupacion(final Agrupacion ag) {
		ArrayList<String> pc = ag.obtenerPalabrasClave();
		for (String palabra : pc) {
			int pos = busquedaBinaria(palabra, 0, palabrasClave.size()-1);
			if (pos < 0) {
				PalabraClave nueva = new PalabraClave(palabra);
				palabrasClave.add(nueva);
				int i = palabrasClave.size() - 1;
				while (i > 0
						&& palabrasClave.get(i - 1).getPalabra()
								.compareToIgnoreCase(palabra) > 0) {
					palabrasClave.set(i, palabrasClave.get(i - 1));
					--i;
				}
				nueva.insertarAgrupacion(ag);
				palabrasClave.set(i, nueva);
			} else {
				palabrasClave.get(pos).insertarAgrupacion(ag);
			}
		}
	}

	public ArrayList<Buscable> buscar(String[] palabras) {
    	HashSet<Buscable> resultados = new HashSet<Buscable>();
    	resultados.addAll(buscarActividades(palabras));
    	resultados.addAll(buscarIniciativas(palabras));
    	resultados.addAll(buscarAgrupaciones(palabras));    	
    	ArrayList<Buscable> array = new ArrayList<Buscable>();
		for (Buscable a : resultados) {
			array.add(a);
		}
		return array;
    }

	public ArrayList<Agrupacion> buscarAgrupaciones(String[] palabras) {
		HashSet<Agrupacion> resultados = new HashSet<Agrupacion>();
		for (String p : palabras) {
			int pos = busquedaBinaria(p, 0, palabrasClave.size()-1);
			if (pos >= 0) {
				resultados.addAll(palabrasClave.get(pos).getAgrupaciones());
			}
		}
		ArrayList<Agrupacion> array = new ArrayList<Agrupacion>();
		for (Agrupacion a : resultados) {
			array.add(a);
		}
		return array;
	}

	public ArrayList<Iniciativa> buscarIniciativas(String[] palabras) {
		HashSet<Iniciativa> resultados = new HashSet<Iniciativa>();
		for (String p : palabras) {
			int pos = busquedaBinaria(p, 0, palabrasClave.size()-1);
			if (pos >= 0) {
				resultados.addAll(palabrasClave.get(pos).getIniciativas());
			}
		}
		ArrayList<Iniciativa> array = new ArrayList<Iniciativa>();
		for (Iniciativa a : resultados) {
			array.add(a);
		}
		return array;
	}

	public ArrayList<Actividad> buscarActividades(String[] palabras) {
		HashSet<Actividad> resultados = new HashSet<Actividad>();
		for (String p : palabras) {
			int pos = busquedaBinaria(p, 0, palabrasClave.size()-1);
			if (pos >= 0) {
				resultados.addAll(palabrasClave.get(pos).getActividades());
			}
		}
		ArrayList<Actividad> array = new ArrayList<Actividad>();
		for (Actividad a : resultados) {
			array.add(a);
		}
		return array;
	}

}
