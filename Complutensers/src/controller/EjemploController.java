package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

import DAO.DAO;
import ssactividades.*;
import ssactividades.map.*;
import ssbuscador.*;
import ssusuarios.*;
import view.ResultadosFrame;
import view.ResultadosListener;
import view.SearchButtonListener;
import view.StudentFrame;
import view.AEFrame.*;
import view.PropIniFrame;
import view.PropIniFrame.InitiativeListener;

public class EjemploController extends Controller implements SearchButtonListener, InitiativeListener{

	private DAO dao;
	ArrayList<Actividad> activities;
	ArrayList<Iniciativa> initiatives;
	ArrayList<Agrupacion> ae;
	ArrayList<Alumno> alumnos;
	
	public EjemploController(){
		
		try{
			dao = new DAO();
			activities = dao.getActividades();		
			initiatives=dao.getIniciativas();
			ae=dao.getAgrupaciones();
			alumnos=dao.getAlumnos();
			System.out.println(alumnos.get(0).guardar());
			dao.guardarDAO();
		}
		catch(IOException e){
			
		}
				
		new StudentFrame(this).setVisible(true);
	}
	
	@Override
	public void buscarActividad(String keyWords) {
		String[] pc = keyWords.split(" ");
		Buscador busc = Buscador.getInstancia();
		for(Actividad a : activities) {
			busc.insertarActividad(a);
		}		
		ArrayList<Actividad> resultados = busc.buscarActividades(pc);
		
		ArrayList<Buscable> bu= new ArrayList<Buscable>();
		for(Actividad a:  resultados){
			bu.add(a);
		}
		
		new ResultadosFrame(bu, new ResultadosListener() {

							@Override
							public void apuntarse(Actividad a) {
								System.out.println("apuntarse a " + a.getName());

							}

						}).setVisible(true);
	}

	@Override
	public void buscarAgrupacion(String keyWords) {
		// TODO Auto-generated method stub
	}

	@Override
	public void buscarIniciativa(String keyWords) {
		// TODO Auto-generated method stub
	}
	
	//Funcion para hacer pruebas
	private static ArrayList<Actividad> dameUnArrayDeActividades(){
		
		ArrayList<Actividad> activ = new ArrayList<Actividad>();
		ArrayList<String> uno = new ArrayList<String>();
		uno.add("barbacoa");
		uno.add("comer");
		ArrayList<String> dos = new ArrayList<String>();
		dos.add("ocio");
		dos.add("comer");
		activ = new ArrayList<Actividad>();
		activ.add(new Actividad("barbacoa", "barbacoa con los chavales", 
				uno, null, null, null, "Verificada"));
		activ.add(new Actividad("cocinitas", "curso de cocina", 
				dos, null, null, null, "Verificada"));
		ArrayList<String> j = new ArrayList<String>();
		j.add("sabrosura");
		j.add("comer");
		ArrayList<String> k = new ArrayList<String>();
		k.add("algo");
		k.add("nose");
		activ.add(new Actividad("sabrosura", "sabroso totalmente", j, null, null,
				null, "Verificada"));
		activ.add(new Actividad("algo",
				"algo, pero no sabemos de que estamos hablando", k, null,
				null, null, "Verificada"));
		return activ;
	}

	@Override
	public void proponerIniciativa() {
		new PropIniFrame(this).setVisible(true);
	}

	@Override
	public void proponerIniciativa(String nombre, String fecha, String lugar, String descr, String hora) {
		String ddmmaa[] = fecha.split("/");
		String hhmm[] = hora.split(":");
		int dia, mes, anyo, hh, mm;
		dia = Integer.parseInt(ddmmaa[0]);
		mes = Integer.parseInt(ddmmaa[1]);
		anyo = Integer.parseInt(ddmmaa[2]);
		hh = Integer.parseInt(hhmm[0]);
		mm = Integer.parseInt(hhmm[1]);
		Fecha fechaIni = new Fecha(dia,mes,anyo,new Hora(hh,mm));
		Lugar lugarIni = new Lugar(new Coordenada(), lugar);
		
		ArrayList<String> palabrasClave = new ArrayList<String>();
		
		String[] palsClaveTitulo = nombre.split(" ");
		String[] palsClaveLugar = lugar.split(" ");
		for(String s : palsClaveTitulo) if(s.length() > 3) palabrasClave.add(s);
		for(String s : palsClaveLugar) if(s.length() > 3) palabrasClave.add(s);
		iniciativas.add(new Iniciativa(nombre,lugarIni,fechaIni,descr,alumnos.get(alumnoLogged),palabrasClave));
	}
	
	public static void main(String ... args){
		EjemploController controller = new EjemploController();
	}
}