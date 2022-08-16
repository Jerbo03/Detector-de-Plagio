
import java.awt.*;
import java.io.*;
import javax.swing.*;

public class VentanaPrincipal extends JFrame {

    PlagiarismChecker checker = new PlagiarismChecker();
    lecturaArchivos lector = new lecturaArchivos();

    public VentanaPrincipal() {
        setTitle("Detector");
        setSize(500, 500);
        setMinimumSize(new Dimension(300, 400));
        this.getContentPane().setBackground(Color.BLUE);
        iniciarComponentes();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void iniciarComponentes() {
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCargar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaArea = new javax.swing.JTextArea();
        btnArchivoBD = new javax.swing.JButton();
        btnEvaluar = new javax.swing.JButton();

        JPanel BASE = new JPanel();
        this.getContentPane().add(BASE);
        BASE.setLayout(null);

        JLabel jPanel1 = new JLabel();
        jPanel1.setBackground(Color.GREEN);

        BASE.add(jPanel1);
        jLabel1.setFont(new java.awt.Font("Eras Bold ITC", 0, 36)); 
        jLabel1.setText("DETECTOR DE PLAGIO");
        jLabel1.setBounds(40, 40, 850, 40);
        BASE.add(jLabel1);

        btnCargar.setBackground(new java.awt.Color(51, 51, 255));
        btnCargar.setFont(new java.awt.Font("Source Sans Pro Black", 0, 14)); 
        btnCargar.setForeground(new java.awt.Color(255, 255, 255));
        btnCargar.setText("Cargar Archivos");
        btnCargar.setBounds(160, 80, 150, 40);
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });
        BASE.add(btnCargar);

        txaArea.setColumns(20);
        txaArea.setRows(5);
        txaArea.setBounds(100, 180, 260, 120);
        jScrollPane1.setViewportView(txaArea);
        BASE.add(txaArea);

        btnEvaluar.setBackground(new java.awt.Color(255, 0, 0));
        btnEvaluar.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); 
        btnEvaluar.setText("EVALUAR");
        btnEvaluar.setBounds(150, 340, 150, 40);
        btnEvaluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEvaluarActionPerformed(evt);
            }
        });

        BASE.add(btnEvaluar);
    }

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {
        lector.addDbFile();
        
        String nombres = "";
        for (String name : lector.getFileNames())
            nombres += name + "\n";
        txaArea.setText("Archivos: " + lector.DBPaths.length + "\n" +nombres);
    }

    private void btnEvaluarActionPerformed(java.awt.event.ActionEvent evt) {
        ResultChecker result = new ResultChecker(lector.DBPaths.length);
        result.restart();
        
        checker.loadFiles(lector.DBPaths);
        lector.setTextPath();
        result = checker.verifyPlagiarism(lector.textPath);

        String newText = "";
        String[] names = lector.getFileNames();
        for (int i=0; i<lector.DBPaths.length; i++) {
            newText += names[i] + "\t" +
            (result.result[i] ? "SE ENCONTRO PLAGIO" : "NO SE ENCONTRO PAGLIO")
            + "\n";
        }
        txaArea.setText(newText);
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
