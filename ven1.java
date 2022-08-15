import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ven1 extends javax.swing.JFrame {

    public ven1() {
        initComponents();
    }

                     
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCargar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaArea = new javax.swing.JTextArea();
        btnArchivoBD = new javax.swing.JButton();
        btnEvaluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 480));

        jLabel1.setFont(new java.awt.Font("Eras Bold ITC", 0, 36)); // NOI18N
        jLabel1.setText("DETECTOR DE PLAGIO");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        btnCargar.setBackground(new java.awt.Color(51, 51, 255));
        btnCargar.setFont(new java.awt.Font("Source Sans Pro Black", 0, 14)); // NOI18N
        btnCargar.setForeground(new java.awt.Color(255, 255, 255));
        btnCargar.setText("Cargar Archivo");
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 150, 40));

        txaArea.setColumns(20);
        txaArea.setRows(5);
        jScrollPane1.setViewportView(txaArea);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 260, 120));

        btnArchivoBD.setBackground(new java.awt.Color(153, 255, 255));
        btnArchivoBD.setFont(new java.awt.Font("Oswald", 0, 12)); // NOI18N
        btnArchivoBD.setText("Ver Archivos en BS");
        btnArchivoBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArchivoBDActionPerformed(evt);
            }
        });
        jPanel2.add(btnArchivoBD, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 130, 40));

        btnEvaluar.setBackground(new java.awt.Color(255, 0, 0));
        btnEvaluar.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        btnEvaluar.setText("EVALUAR");
        btnEvaluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEvaluarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEvaluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 150, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        JFileChooser fc= new JFileChooser();//ventana que abre para escoger
        fc.showOpenDialog(null);//"abre el cuadro de dialogo con el campo nulo, osea no tenga ningun objeto seleecionado ara poder despalazrnos 
        File archivo= fc.getSelectedFile();
        
        try{
            FileReader fr= new FileReader(archivo);
            BufferedReader br =new BufferedReader(fr);

            JOptionPane.showMessageDialog(null,"Archivo leido correctamente");
        }
        catch(Exception e){
            
        }
    }                                         

    private void btnArchivoBDActionPerformed(java.awt.event.ActionEvent evt) {                                             
       // TODO  add your handling code here:
        JFileChooser fc= new JFileChooser();//ventana que abre para escoger
        fc.showOpenDialog(null);//"abre el cuadro de dialogo con el campo nulo, osea no tenga ningun objeto seleecionado ara poder despalazrnos 
        File archivo= fc.getSelectedFile();
        
        try{
            FileReader fr= new FileReader(archivo);
            BufferedReader br =new BufferedReader(fr);
//espacio de memoria para que primero la mantenga en la memoria y luego la muestre
            String texto="";
            String linea="";
            while(((linea=br.readLine())!=null)){//recorrer todo el archivo y cada linea que vaya leyendo que la agegue a la variable texto 
                texto+=linea+"\n";
            }
            txaArea.setText(texto);//wey coloca el texto en txaArchivo oc
        }
        catch(Exception e){
            
        }
    }                                            

    private void btnEvaluarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

   
                   
    private javax.swing.JButton btnArchivoBD;
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnEvaluar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txaArea;
                    
}

