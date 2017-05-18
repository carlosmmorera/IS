package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/*
 * para ver como queda ejecutar la clase prueba
 */
public class LoginFrame extends JFrame{
	
	JTextField user;
	JPasswordField password;
	JButton logButton;
	JButton notlogButton;
	
	public LoginFrame (){
		super("Login");		
		initGUI();
	}
	
	private void initGUI(){		
		JPanel panel = createJpanel();		
		this.add(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
	private JPanel createJpanel(){
		JPanel panel=new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel userp = new JPanel();
		userp.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
		user = new JTextField(20);			
		JLabel a = new JLabel("Usuario:");
		userp.add(a);
		userp.add(user);
		
		JPanel pass = new JPanel();
		pass.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
		password = new JPasswordField(20);	
		JLabel b = new JLabel("Contrase�a:");
		pass.add(b);
		pass.add(password);
		
		JPanel botones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
		botones.setSize(new Dimension(500,100));		
		logButton = new JButton("Log in");
		notlogButton = new JButton("Entrar sin log");
		
		logButton.addActionListener((e)->{
			//TODO a�adir la funcion a la que se llama al hacer click en login
		});
		notlogButton.addActionListener((e)->{
			//TODO a�adir la funcion a la que se llama al hacer click en entrar sin login
		});
		botones.add(logButton);
		botones.add(notlogButton);
		
		panel.add(userp);
		panel.add(pass);
		panel.add(botones);
		return panel;
	}

}

