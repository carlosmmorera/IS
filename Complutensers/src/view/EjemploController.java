package view;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

import DAO.DAO;
import ssactividades.Actividad;
import ssactividades.Evento;
import ssbuscador.Buscable;
import ssbuscador.Buscador;
import ssusuarios.Agrupacion;
import view.AEFrame.*;

public class EjemploController implements SearchButtonListener{

	private DAO dao;
	ArrayList<Actividad> activities;
	
	public EjemploController(){
		/*
		try{
			dao = new DAO();
			activities = dao.getActividades();		
			
		}
		catch(IOException e){
			
		}*/
		activities=this.dameUnArrayDeActividades();
				
		JFrame pantalla = new StudentFrame(this);
		pantalla.setVisible(true);
	}
	
	@Override
	public ArrayList<Actividad> buscarActividad(String keyWords) {
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
		
		new ResultadosFrame(bu).setVisible(true);
		return null;
	}

	@Override
	public ArrayList<Agrupacion> buscarAgrupacion(String keyWords) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Actividad> buscarIniciativa(String keyWords) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String ... args){
		EjemploController controller = new EjemploController();
		
	}
	
	//Funcion para hacer pruebas
	private ArrayList<Actividad> dameUnArrayDeActividades(){
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

}