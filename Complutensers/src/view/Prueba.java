package view;

import java.util.ArrayList;

import javax.swing.SwingUtilities;

import ssactividades.Actividad;
import ssbuscador.Buscable;

public class Prueba {
	
	private static ArrayList<Buscable> iniciarLista(ArrayList<Buscable> a){
		a.add(new Buscable(){

			@Override
			public ArrayList<String> obtenerPalabrasClave() {
				return null;
			}
			@Override
			public String getName() {
				return "hola";
			}
			@Override
			public String getDescription() {
				return "Pues sabes que te digo: vente a esta actividad, que esta muy guay y todo eso";
			}
		});
		a.add(new Buscable(){

			@Override
			public ArrayList<String> obtenerPalabrasClave() {
				return null;
			}
			@Override
			public String getName() {
				return "lao";
			}
			@Override
			public String getDescription() {
				return "Pues sabes que te digo: vente a esta actividad, que esta muy guay y todo eso";
			}
		});
		a.add(new Buscable(){

			@Override
			public ArrayList<String> obtenerPalabrasClave() {
				return null;
			}
			@Override
			public String getName() {
				return "asin";
			}
			@Override
			public String getDescription() {
				return "Pues sabes que te digo: vente a esta actividad, que esta muy guay y todo eso";
			}
		});
		a.add(new Buscable(){

			@Override
			public ArrayList<String> obtenerPalabrasClave() {
				return null;
			}
			@Override
			public String getName() {
				return "oyes";
			}
			@Override
			public String getDescription() {
				return "Pues sabes que te digo: vente a esta actividad, que esta muy guay y todo eso";
			}
		});			

		return a;
	}

	public static void main(String...args){
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				LoginFrame loginframe = new LoginFrame(new LoginListener(){

					@Override
					public void loggear(String usuario, String password) {
						System.out.println(usuario + password);
						
					}

					@Override
					public void entrarSinLog() {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void registrarse(String usuario, String password) {
						System.out.println(usuario + password);
						
					}
					
				});
				
				ArrayList<Buscable> a =new ArrayList<Buscable>();
				a=iniciarLista(a);	
				ArrayList<Actividad> b =new ArrayList<Actividad>();
				ResultadosFrame f=new ResultadosFrame(a);
				
			}
			
		});
	}
}