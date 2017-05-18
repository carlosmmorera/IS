package view;

import java.util.ArrayList;

import javax.swing.SwingUtilities;

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
				//LoginFrame loginframe = new LoginFrame();
				
				ArrayList<Buscable> a =new ArrayList<Buscable>();
				a=iniciarLista(a);				
				ResultadosFrame f=new ResultadosFrame(a);
				
			}
			
		});
	}
}