/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.util.ArrayList;

import ssactividades.Actividad;
import ssusuarios.Agrupacion;

/**
 *
 * 
 */
public class StudentFrame extends javax.swing.JFrame{

	public SearchButtonListener listener;
	
	
    /**
     * Creates new form AEFrame
     */
    public StudentFrame(SearchButtonListener listen) {
    	this.listener=listen;
        initComponents();
    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        keyWords = new javax.swing.JTextField();
        textOfSearch = new javax.swing.JLabel();
        header = new javax.swing.JLabel();
        jButtonInic = new javax.swing.JButton();
        jButtonActiv = new javax.swing.JButton();
        buscActText = new javax.swing.JLabel();
        buscIniText = new javax.swing.JLabel();
        logeadoComoText = new javax.swing.JLabel();
        ucmIcon = new javax.swing.JLabel();
        jButtonAgrup = new javax.swing.JButton();
        buscInicText = new javax.swing.JLabel();
        propIni = new javax.swing.JButton();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(384, 640));
        setSize(new java.awt.Dimension(384, 640));

        textOfSearch.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        textOfSearch.setText("Introduzca las palabras clave de su b�squeda, y pulse buscar");
        textOfSearch.setMaximumSize(new java.awt.Dimension(140, 28));
        textOfSearch.setMinimumSize(new java.awt.Dimension(140, 28));
        textOfSearch.setPreferredSize(new java.awt.Dimension(140, 28));

        header.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/header.jpg"))); // NOI18N
        header.setMaximumSize(new java.awt.Dimension(384, 63));
        header.setMinimumSize(new java.awt.Dimension(384, 63));
        header.setPreferredSize(new java.awt.Dimension(384, 63));

        jButtonInic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/labuenalupa.png"))); // NOI18N

        jButtonActiv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/labuenalupa.png"))); // NOI18N

        buscActText.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        buscActText.setText("Actividades");

        buscIniText.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        buscIniText.setText("Agrupaciones");

        logeadoComoText.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        logeadoComoText.setText("Logeado como estudiante");

        ucmIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ucm.png"))); // NOI18N

        jButtonAgrup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/labuenalupa.png"))); // NOI18N

        buscInicText.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        buscInicText.setText("Iniciativas");
        
        jButtonInic.addActionListener((e)->{
			listener.buscarIniciativa(keyWords.getText());
		});
        
        jButtonActiv.addActionListener((e)->{
			listener.buscarActividad(keyWords.getText());
		});
        
        jButtonAgrup.addActionListener((e)->{
			// Biti: es para probar el propIni | listener.buscarAgrupacion(keyWords.getText());
        	listener.proponerIniciativa();
        	setVisible(false);
		});
        
        propIni.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/initiatives.png")));
        propIni.addActionListener((e)->{
			listener.proponerIniciativa();
			setVisible(false);
		});
      //  add(propIni,BorderLayout.PAGE_END);
                

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ucmIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logeadoComoText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(keyWords, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textOfSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonActiv)
                            .addComponent(buscActText))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buscIniText)
                            .addComponent(jButtonAgrup))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonInic)
                            .addComponent(buscInicText))))
                .addGap(49, 49, 49))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(logeadoComoText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(ucmIcon)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(textOfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(keyWords, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonInic)
                            .addComponent(jButtonAgrup)))
                    .addComponent(jButtonActiv, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscIniText)
                    .addComponent(buscActText, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscInicText))
                .addContainerGap(126, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	SearchButtonListener b = new SearchButtonListener(){
            		public void buscarActividad(String keyWords){
            			System.out.println("Quieres buscar actividad");
            		}
            		public void buscarAgrupacion(String keyWords){
            			System.out.println("Quieres buscar agrupacion");
            		}
            		public void buscarIniciativa(String keyWords){
            			System.out.println("Quieres buscar iniciativa");
            		}
					@Override
					public void proponerIniciativa() {
						// TODO Auto-generated method stub
						
					}
            	};
                new StudentFrame(b).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel buscActText;
    private javax.swing.JLabel buscIniText;
    private javax.swing.JLabel buscInicText;
    private javax.swing.JLabel header;
    private javax.swing.JButton jButtonInic;
    private javax.swing.JButton jButtonActiv;
    private javax.swing.JButton jButtonAgrup;
    private javax.swing.JTextField keyWords;
    private javax.swing.JLabel logeadoComoText;
    private javax.swing.JLabel textOfSearch;
    private javax.swing.JLabel ucmIcon;
    private javax.swing.JButton propIni;
    // End of variables declaration                   
}
