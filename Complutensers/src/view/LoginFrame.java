package view;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginFrame extends JFrame{
	
	JTextField user;
	JTextField password;
	JButton log;
	
	public LoginFrame (){
		super("Login");		
		initGUI();
	}
	
	private void initGUI(){		
		//JPanel mainpanel = createJpanel();
		JPanel panel=new JPanel();
		user = new JTextField();
		user.setSize(120, 30);
		password = new JTextField();
		password.setSize(120, 30);
		panel.add(user);
		panel.add(password);
		this.add(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(600, 600));
		this.pack();
		this.setVisible(true);
	}
	private JPanel createJpanel(){
		JPanel panel=new JPanel();
		user = new JTextField();
		user.setSize(120, 30);
		password = new JTextField();
		password.setSize(120, 30);
		panel.add(user);
		panel.add(password);
		return panel;
	}

}
