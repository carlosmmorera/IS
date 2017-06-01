package presentacion.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import negocio.ssactividades.Actividad;
import negocio.ssbuscador.Buscable;
import presentacion.controller.Controller;

public class HistorialFrame extends JFrame {
	
	private ArrayList<Actividad> arract;
	private HistorialListener hl;
	private JPanel panelHistorial;
	private JPanel panelinfo;
	
	public HistorialFrame(ArrayList<Actividad> actividades,  Controller controller){
		arract =actividades;
		hl = controller;
		initGUI(arract.size());
	}
	
	private void initGUI(int numact){
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 20));
		if(numact==0)
			top.add(new JLabel("No se han encontrado resultados"));
		else if(numact==1)
			top.add(new JLabel("Se ha obtenido un resultado:"));
		else
			top.add(new JLabel("Se han obtenido " + numact + " resultados:"));
		
		JPanel results = new JPanel();
		results.setLayout(new BoxLayout(results, BoxLayout.Y_AXIS));
		for(Actividad elem : arract){
			
			JPanel resultado = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
			
			JButton info = new JButton("+ info");
			info.addActionListener((e) -> {
				mostrarInfo(elem);
			});	
			resultado.add(new JLabel(elem.getName()));
			resultado.add(info);
			
			JButton apuntarse = new JButton("Modificar");
			apuntarse.addActionListener((e) -> {
				hl.modificarActividad(elem);
			});
			resultado.add(apuntarse);
			
			results.add(resultado);
		}
		
		JScrollPane panelBarra = new JScrollPane(results,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		
		panel.add(top,BorderLayout.NORTH);
		panel.add(panelBarra,BorderLayout.CENTER);
		
		panelHistorial = panel;
		this.setContentPane(panelHistorial);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setPreferredSize(new Dimension(384,620));
		this.pack();
		this.setVisible(true);
	}

	private void mostrarInfo(Buscable elem) {
		JPanel mainPanel=new JPanel(new BorderLayout());
		
		JPanel top =new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
		top.add(new JLabel(elem.getName()));
		mainPanel.add(top,BorderLayout.NORTH);			
		
		JTextArea descripcion = new JTextArea(elem.getDescription());
		descripcion.setEditable(false);
		descripcion.setLineWrap(true);
		descripcion.setWrapStyleWord(true);
		JScrollPane center = new JScrollPane(descripcion,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		mainPanel.add(center,BorderLayout.CENTER);		
		
		JPanel bot=new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
		JButton volver = new JButton("Volver a resultados");
		volver.addActionListener((e)->{
			this.setContentPane(panelHistorial);
			this.pack();
		});
		
		mainPanel.add(new JPanel(),BorderLayout.LINE_START);
		mainPanel.add(new JPanel(),BorderLayout.LINE_END);
		
		bot.add(volver);
		mainPanel.add(bot,BorderLayout.SOUTH);
		
		
		panelinfo=mainPanel;
		this.setContentPane(panelinfo);
		this.setPreferredSize(new Dimension(384,620));
		this.pack();
	}

}
