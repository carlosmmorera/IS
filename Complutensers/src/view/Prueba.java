package view;

import javax.swing.SwingUtilities;

public class Prueba {

	public static void main(String...args){
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				LoginFrame loginframe = new LoginFrame();
				
			}
			
		});
	}
}
