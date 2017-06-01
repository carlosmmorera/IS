package presentacion.view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import negocio.ssactividades.*;
import negocio.ssactividades.map.Lugar;

public class ModificarFrame extends JFrame{
	
	private Actividad act;
	private JTextField place;
	private JTextField date;
	private JTextField time;
	private JTextField desc;
	private JButton aceptar;
	private JButton rechazar;
	private ModificarListener list;
	
	public ModificarFrame(Actividad act, ModificarListener ml){
		this.act = act;
		this.list = ml;
		initGUI();
	}
	
	private void initGUI(){
	JPanel panel = createPanel();
	this.add(panel);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.pack();
	this.setVisible(true);
}

	private JPanel createPanel(){
		JPanel panel=new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//Creamos paneles con sus respectivos areas de texto con los campos que vamos a cambiar
		JPanel lugar = new JPanel();
		lugar.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
		place = new JTextField(20);	
		JLabel b = new JLabel("Lugar: ");
		lugar.add(b);
		lugar.add(place);
		
		JPanel fecha = new JPanel();
		fecha.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
		date = new JTextField(20);	
		JLabel c = new JLabel("Fecha: ");
		fecha.add(c);
		fecha.add(date);
		
		JPanel hora = new JPanel();
		hora.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
		time = new JTextField(20);	
		JLabel d = new JLabel("Hora: ");
		hora.add(d);
		hora.add(time);
		
		JPanel descripcion = new JPanel();
		descripcion.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
		desc = new JTextField(20);	
		JLabel e = new JLabel("Descripcion: ");
		descripcion.add(e);
		descripcion.add(desc);
																											
		JPanel botones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
		botones.setSize(new Dimension(500,100));		
		aceptar = new JButton("Aceptar Cambios");
		rechazar = new JButton("Rechazar Cambios");
		
		//En caso de aceptar, creamos las instancias necesarias y cambiamos la actividad
		aceptar.addActionListener((f)->{
			act.modificarDescripcion(desc.getText());
			String[] cad = time.getText().split(":");  
			Hora auxiliar = new Hora(Integer.parseInt(cad[0]), Integer.parseInt(cad[1]));
			String [] cad1 = date.getText().split("/");
			Fecha aux = new Fecha(Integer.parseInt(cad1[0]), Integer.parseInt(cad1[1]),
					Integer.parseInt(cad1[2]), auxiliar );
			act.modificarFecha(aux);
			Lugar lugaraux = new Lugar(place.getText());
			act.modificarLugar(lugaraux);
			list.Modificar(act);
			this.setVisible(false);
		});
		rechazar.addActionListener((f)->{
			this.setVisible(false);
		});
		botones.add(aceptar);
		botones.add(rechazar);
		
		panel.add(lugar);
		panel.add(hora);
		panel.add(fecha);
		panel.add(descripcion);

		panel.add(botones);
		return panel;
		
	}
}
