package presentacion.view;

import java.util.ArrayList;

import javax.swing.SwingUtilities;

import negocio.ssactividades.Actividad;
import negocio.ssbuscador.Buscable;
import negocio.ssusuarios.Agrupacion;

public class Prueba {

	public static void main(String... args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				LoginFrame loginframe = new LoginFrame(new LoginListener() {

					@Override
					public boolean loggear(String usuario, String password) {
						System.out.println(usuario + password);
						return true;
					}

					@Override
					public void entrarSinLog() {
						// TODO Auto-generated method stub

					}

					@Override
					public boolean registrarse(String usuario, String password) {
						System.out.println(usuario + password);
						return true;
					}

				});

				ArrayList<Buscable> a = new ArrayList<Buscable>();
				a = iniciarLista(a);
				ArrayList<Actividad> b = dameUnArrayDeActividades();
				
				
				ArrayList<Buscable> c = new ArrayList<Buscable>();
				for (Actividad act : b) {
					c.add(act);
				}

				ResultadosFrame f = new ResultadosFrame(c,
						new ResultadosListener() {

							@Override
							public void apuntarseAct(Actividad a) {
								System.out.println("apuntarse a " + a.getName());

							}

							@Override
							public void apuntarseAgrup(Agrupacion elem) {
								System.out.println("apuntarse a " + elem.getName());
								
							}

						});
			}
		});
	}

	private static ArrayList<Actividad> dameUnArrayDeActividades() {

		ArrayList<Actividad> activ = new ArrayList<Actividad>();
		ArrayList<String> uno = new ArrayList<String>();
		uno.add("barbacoa");
		uno.add("comer");
		ArrayList<String> dos = new ArrayList<String>();
		dos.add("ocio");
		dos.add("comer");
		activ = new ArrayList<Actividad>();
		activ.add(new Actividad("barbacoa", "barbacoa con los chavales", uno,
				null, null, null, "Verificada"));
		activ.add(new Actividad("cocinitas", "curso de cocina", dos, null,
				null, null, "Verificada"));
		ArrayList<String> j = new ArrayList<String>();
		j.add("sabrosura");
		j.add("comer");
		ArrayList<String> k = new ArrayList<String>();
		k.add("algo");
		k.add("nose");
		activ.add(new Actividad("sabrosura", "sabroso totalmente", j, null,
				null, null, "Verificada"));
		activ.add(new Actividad("algo",
				"algo, pero no sabemos de que estamos hablando", k, null, null,
				null, "Verificada"));
		return activ;
	}

	private static ArrayList<Buscable> iniciarLista(ArrayList<Buscable> a) {
		a.add(new Buscable() {

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
		a.add(new Buscable() {

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
		a.add(new Buscable() {

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
		a.add(new Buscable() {

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
}