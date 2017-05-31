package controller;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ssactividades.Actividad;
import ssactividades.Fecha;
import ssactividades.Hora;
import ssactividades.Iniciativa;
import ssactividades.map.Coordenada;
import ssactividades.map.Lugar;
import ssbuscador.Buscable;
import ssbuscador.Buscador;
import ssusuarios.Agrupacion;
import ssusuarios.Alumno;
import view.AppUi;
import view.LoginListener;
import view.ModificarListener;
import view.ResultadosListener;
import view.PropIniFrame.InitiativeListener;
import view.SearchButtonListener;
import view.CrearActividadFrame.ActividadInfoListener;
import view.HistorialFrame;
import view.HistorialListener;
import view.ExitListener;
import DAO.DAO;

public class Controller implements LoginListener, ModificarListener, SearchButtonListener, 
InitiativeListener, ResultadosListener, ExitListener, WindowListener, ActividadInfoListener, HistorialListener{
	/*
	 * BITI: he puesto varios a protected para poder usarlos desde el ejemplo
	 */
	
	private DAO dao;
	private ArrayList<Actividad> actividades;
	protected ArrayList<Iniciativa> iniciativas;
	protected ArrayList<Alumno> alumnos;
	private ArrayList<Agrupacion> agrupaciones;
	protected int alumnoLogged;
	private int agrupacionLogged;
	private AppUi appui;
	
	public Controller(){
		alumnoLogged = -1;
		agrupacionLogged = -1;
		try {
			dao = new DAO();
			actividades = dao.getActividades();
			iniciativas = dao.getIniciativas();
			alumnos = dao.getAlumnos();
			agrupaciones = dao.getAgrupaciones();
			iniciarBuscador();
			appui = new AppUi(this);
		} catch (IOException e) { }
	}

	private void iniciarBuscador() {
		Buscador buscador = Buscador.getInstancia();
		for(Actividad a : actividades)
			buscador.insertarActividad(a);
		for (Agrupacion a : agrupaciones)
			buscador.insertarAgrupacion(a);
		for (Iniciativa a : iniciativas)
			buscador.insertarIniciativa(a);
	}

	@Override
	public boolean loggear(String usuario, String password) {
		int i = 0, j = 0;
		while (i < alumnos.size() && !alumnos.get(i).logIn(usuario, password)) ++i;
		if (i == alumnos.size()){
			while (j < agrupaciones.size() && !agrupaciones.get(j).logIn(usuario, password)) ++j;
			
			if (j != agrupaciones.size()){
				agrupacionLogged = j;
				appui.iniciarAEFrame();
			}
		}
		else{
			alumnoLogged = i;
			appui.iniciarStudentFrame();
		}
		
		return alumnoLogged != -1 || agrupacionLogged != -1;
	}

	@Override
	public void entrarSinLog() {
		appui.entrarSinLog();
	}

	@Override
	public boolean registrarse(String usuario, String password) {
		int i = 0, j = 0;
		while (i < alumnos.size() && !alumnos.get(i).getName().equals(usuario)) ++i;
		while (j < agrupaciones.size() && !agrupaciones.get(j).getName().equals(usuario)) ++j;
		
		boolean registroCorrecto = (i == alumnos.size() && j == agrupaciones.size());
		if (registroCorrecto)
			alumnos.add(new Alumno(usuario, password, null));
		return registroCorrecto;
	}

	@Override
	public void buscarActividad(String keyWords) {
		String[] pc = keyWords.split(" ");		
		ArrayList<Actividad> resultados = Buscador.getInstancia().buscarActividades(pc);
		ArrayList<Buscable> bu = new ArrayList<Buscable>();
		for(Actividad a:  resultados){
			bu.add(a);
		}
		appui.iniciarResultadosFrame(bu);
	}

	@Override
	public void buscarAgrupacion(String keyWords) {
		String [] pc = keyWords.split(" ");	
		ArrayList<Agrupacion> resultados = Buscador.getInstancia().buscarAgrupaciones(pc);
		ArrayList<Buscable> bu = new ArrayList<Buscable>();
		for(Agrupacion a:  resultados){
			bu.add(a);
		}
		appui.iniciarResultadosFrame(bu);
	}
	
	@Override
	public void mostrarHistorial() {
		ArrayList<Actividad> arract = new ArrayList<Actividad>();
		for(Actividad act : actividades){
			if(act.getAgrupacion().getName().equals(agrupaciones.get(agrupacionLogged).getName())){
				arract.add(act);
			}
		}
		appui.iniciarHistorialFrame(arract);
		
	}
	
	@Override
	public void modificarActividad(Actividad a) {
		appui.modificarActividad(a);
	}
	
	@Override
	public void Modificar(Actividad a) {
		for(Actividad act : actividades){
			if(a.getName().equals(act.getName())){
			act.ModificarNombre(a.getName());
			act.modificarDescripcion(a.getDescription());
			act.modificarFecha(a.getFecha());	
			act.modificarLugar(act.getLugar());
			}
		}
	}

	@Override
	public void buscarIniciativa(String keyWords) {
		String [] pc = keyWords.split(" ");
		
		ArrayList<Iniciativa> resultados = Buscador.getInstancia().buscarIniciativas(pc);
		ArrayList<Buscable> bu = new ArrayList<Buscable>();
		for(Iniciativa a:  resultados){
			bu.add(a);
		}
		appui.iniciarResultadosFrame(bu);
	}

	@Override
	public void proponerIniciativa() {
		appui.iniciarPropIniFrame();
	}

	@Override
	public void proponerIniciativa(String nombre, String fecha, String lugar,
			String descr, String hora) {
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
	@Override
	public void exitApp() {
		try {
			dao.guardarDAO();
		} catch (IOException e) { }
		System.exit(0);
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
		int n = JOptionPane.showOptionDialog(new JFrame(),
				"Are sure you want to quit?", "Quit",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				null, null);
		if (n == 0) {
			Controller.this.exitApp();
		}
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void registrarActividad(String name, String desc, String keyWords,
			String place, String dia, String mes, String anyo, String hora,
			String min) {
		Fecha fecha = new Fecha(Integer.parseInt(dia), Integer.parseInt(mes),
				Integer.parseInt(anyo), new Hora(Integer.parseInt(hora),Integer.parseInt(min)));
		Actividad a = agrupaciones.get(agrupacionLogged).crearActividad(name, desc, keyWords, place, fecha);
		actividades.add(a);
	}

	@Override
	public void proponerActividad() {
		appui.iniciarActIniFrame();
	}

	@Override
	public void apuntarseAgrup(Agrupacion elem) {
		elem.apuntarAlumno(alumnos.get(alumnoLogged));
		appui.mostrarMensaje("Te has apuntado a " + elem.getName());
	}

	@Override
	public void apuntarseAct(Actividad a) {
		if (alumnoLogged != -1){
			if (alumnos.get(alumnoLogged).apuntarseActividad(a))
				appui.mostrarMensaje("Te has apuntado a " + a.getName());
			else
				appui.mostrarMensaje("Error: Ya est�s apuntado a esta actividad");
		}
	}

	@Override
	public void buscarGeneral(String keyWords) {
		String[] pc = keyWords.split(" ");
		Buscador buscador = Buscador.getInstancia();
		ArrayList<Buscable> act = buscador.buscar(pc);
		appui.iniciarResultadosFrame(act);
	}

	
	

}
