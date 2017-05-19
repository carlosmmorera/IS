package view;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Observer;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ssactividades.Actividad;
import ssbuscador.*;
/**
 * 
 * @author Ariadna
 * @version 1.0
 */
public class FrameSinLog extends JFrame{

	JButton accBuscador;
	
	public FrameSinLog(){
		super("Acceder sin Log");
		initGUI();
	}
	/**
	 * Crea la interfaz gráfica
	 */
	private void initGUI(){
		JPanel panel = createPanel();
		this.setSize(new Dimension(360, 320));
		this.add(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	/**
	 * 
	 * @return un panel con el botón de acceder al buscador
	 */
	private JPanel createPanel(){
		JPanel panel = new JPanel();
		JPanel palabras = new JPanel();
		palabras.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		JTextField area = new JTextField(20);		
		JLabel a = new JLabel("Introduzca las palabras clave");
		palabras.add(a);
		palabras.add(area);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		accBuscador = new JButton("Acceder al buscador");
		accBuscador.addActionListener((e)->{	
			String s = area.getText();
			String[] pc = s.split(" ");
			Buscador buscador = new Buscador();
			ArrayList<Buscable> act = buscador.buscar(pc);
			//Con lo obtenido (act) llamaria a mostrarResultados de ResultadosFrame
			this.setVisible(false);
			//Aquí se llama a mostrar buscador
			
			
			
		});
		JPanel boton = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
		boton.setSize(new Dimension(500,100));			
		boton.add(accBuscador);
		panel.add(boton);
		panel.add(palabras);
		return panel;
	}
	
}
