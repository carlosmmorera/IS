package view;

import controller.Controller;

public class AppUi implements SearchButtonListener{
	private LoginFrame log;
	private AEFrame ae;
	private StudentFrame student;
	private ResultadosFrame results;
	private FrameSinLog withoutLog;
	private Controller controller;
	
	public AppUi(Controller c){
		controller = c;
		log = new LoginFrame(controller);
	}
	@Override
	public void buscarActividad(String keyWords) {
		// TODO Auto-generated method stub
		return;
	}
	@Override
	public void buscarAgrupacion(String keyWords) {
		// TODO Auto-generated method stub
		return;
	}
	@Override
	public void buscarIniciativa(String keyWords) {
		// TODO Auto-generated method stub
		return;
	}
	@Override
	public void proponerIniciativa() {
		// TODO Auto-generated method stub
		
	}
}
