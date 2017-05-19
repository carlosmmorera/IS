package view;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

import DAO.DAO;
import ssactividades.Actividad;
import ssbuscador.Buscable;
import ssbuscador.Buscador;
import ssusuarios.Agrupacion;
import view.AEFrame.*;

public class EjemploController implements SearchButtonListener{

	private DAO dao;
	ArrayList<Actividad> activities;
	
	public EjemploController(){
		try{
			dao = new DAO();
			activities = dao.getActividades();
		}
		catch(IOException e){
			
		}
		JFrame pantalla = new StudentFrame(this);
		pantalla.setVisible(true);
	}
	
	@Override
	public ArrayList<Actividad> buscarActividad(String keyWords) {
		String[] pc = keyWords.split(" ");
		Buscador busc = new Buscador();
		for(Actividad a : activities) {
			busc.insertarActividad(a);
		}
		ArrayList<Actividad> resultados = busc.buscarActividades(pc);
		new ResultadosFrame(resultados).setVisible(true);
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

}