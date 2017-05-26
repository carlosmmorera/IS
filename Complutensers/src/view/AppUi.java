package view;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ssbuscador.Buscable;
import controller.Controller;

public class AppUi {
	private LoginFrame log;
	private AEFrame ae;
	private StudentFrame student;
	private ResultadosFrame results;
	private FrameSinLog withoutLog;
	private PropIniFrame propini;
	private Controller controller;
	
	public AppUi(Controller controller){
		this.controller = controller;
		log = new LoginFrame(this.controller);
		ae = null;
		student = null;
		results = null;
		withoutLog = null;
		propini = null;
		
		log.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		log.addWindowListener(controller);
	}
	public void entrarSinLog(){
		withoutLog = new FrameSinLog();
		withoutLog.setVisible(true);
		withoutLog.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		withoutLog.addWindowListener(controller);
	}
	public void iniciarStudentFrame(){
		student = new StudentFrame(controller);
		student.setVisible(true);
		student.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		student.addWindowListener(controller);
	}
	public void iniciarAEFrame(){
		ae = new AEFrame(controller);
		ae.setVisible(true);
		ae.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ae.addWindowListener(controller);
	}
	public void iniciarResultadosFrame(ArrayList<Buscable> resultado){
		results = new ResultadosFrame(resultado, controller);
		results.setVisible(true);
	}
	public void mostrarMensajeAlumnoApuntado(String nombreActividad){
		JFrame frame = new JFrame();
		JOptionPane.showMessageDialog(frame, "Te has apuntado a " + nombreActividad);
	}
	public void iniciarPropIniFrame(){
		new PropIniFrame(controller).setVisible(true);
	}
}
