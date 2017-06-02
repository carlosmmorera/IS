        package presentacion.view;

        /**
         *
         * @author usuario_local
         */
        public class StudentFrame extends javax.swing.JFrame {

            /**
             * Creates new form AEFrame
             */
            public StudentFrame(SearchButtonListener listener) {
                this.listener = listener;
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

                jLabel1 = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                jLabel4 = new javax.swing.JLabel();
                searchWords = new javax.swing.JTextField();
                activButton = new javax.swing.JButton();
                iniButton = new javax.swing.JButton();
                agrButton = new javax.swing.JButton();
                jLabel5 = new javax.swing.JLabel();
                jLabel6 = new javax.swing.JLabel();
                jLabel7 = new javax.swing.JLabel();
                proponeragrButton = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setPreferredSize(new java.awt.Dimension(384, 620));

                jLabel1.setIcon(new javax.swing.ImageIcon("src/integracion/resources/header.jpg")); // NOI18N

                jLabel2.setIcon(new javax.swing.ImageIcon("src/integracion/resources/ucm.png")); // NOI18N

                jLabel3.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
                jLabel3.setText("Logeado como estudiante");
                
                jLabel4.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
                jLabel4.setText("Introduzca las palabras clave de su b�squeda, y pulse buscar");

                activButton.setIcon(new javax.swing.ImageIcon("src/integracion/resources/labuenalupa.png")); // NOI18N

                iniButton.setIcon(new javax.swing.ImageIcon("src/integracion/resources/labuenalupa.png")); // NOI18N

                agrButton.setIcon(new javax.swing.ImageIcon("src/integracion/resources/labuenalupa.png")); // NOI18N

                jLabel5.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
                jLabel5.setText("Buscar iniciativa");

                jLabel6.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
                jLabel6.setText("Buscar actividad");

                jLabel7.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
                jLabel7.setText("Buscar agrupaci�n");

                proponeragrButton.setText("Proponer iniciativa");
                
                iniButton.addActionListener((e)->{
                	listener.buscarIniciativa(searchWords.getText());
                });

                agrButton.addActionListener((e)->{
        			listener.buscarAgrupacion(searchWords.getText());
        		});
                
                activButton.addActionListener((e)->{
        			listener.buscarActividad(searchWords.getText());
        		});
                
                proponeragrButton.addActionListener((e)->{
                	listener.proponerIniciativa();
                	setVisible(false);
        		});
              
                

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addComponent(jLabel3)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(searchWords, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(activButton)
                                            .addComponent(jLabel6))
                                        .addGap(38, 38, 38)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(agrButton)
                                                .addGap(53, 53, 53)
                                                .addComponent(iniButton))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel5)))))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(proponeragrButton)
                        .addGap(130, 130, 130))
                );
                layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel4)
                        .addGap(26, 26, 26)
                        .addComponent(searchWords, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(activButton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(agrButton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(iniButton, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(68, 68, 68)
                        .addComponent(proponeragrButton)
                        .addGap(0, 91, Short.MAX_VALUE))
                );

                pack();
            }// </editor-fold>                        

                      // Variables declaration - do not modify                     
            private javax.swing.JButton activButton;
            private javax.swing.JButton iniButton;
            private javax.swing.JButton agrButton;
            private javax.swing.JLabel jLabel1;
            private javax.swing.JLabel jLabel2;
            private javax.swing.JLabel jLabel3;
            private javax.swing.JLabel jLabel4;
            private javax.swing.JLabel jLabel5;
            private javax.swing.JLabel jLabel6;
            private javax.swing.JLabel jLabel7;
            private javax.swing.JButton proponeragrButton;
            private javax.swing.JTextField searchWords;
            SearchButtonListener listener;
            // End of variables declaration                   
        }
