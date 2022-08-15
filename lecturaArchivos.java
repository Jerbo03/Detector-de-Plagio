import java.io.*;
import java.util.*;
import java.util.stream.*;

import javax.swing.*;

public class lecturaArchivos {
    JFileChooser fileChooser = new JFileChooser ();
    List <File> fileList = new ArrayList <File> ();
    List <String> stopwords = new ArrayList <String> ();
    
    List <String[]> archivos = new ArrayList <String[]> ();
    String[] baseDatos;
    
    public void leerArchivos () throws FileNotFoundException {
        
        Scanner sc = new Scanner (new FileReader("palabrasStop.txt"));        
        while (sc.hasNext()) {
            stopwords.add(sc.next());
        }
        
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        if (!fileChooser.isMultiSelectionEnabled()) {
           fileChooser.setMultiSelectionEnabled(true);
        }
        
        fileChooser.showOpenDialog(fileChooser);
        try {
            for (File f : fileChooser.getSelectedFiles()) {
                fileList.add(f);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    public void guardarArchivos () throws FileNotFoundException {
        for(File f : fileList) {
            String text = eliminarStop(f);
            archivos.add(text.split(" "));
        }
    }
    
    public void guardarBD () throws FileNotFoundException {
        String text = "";
        
        for(File f : fileList) {
            text += eliminarStop(f);
        }
        
        baseDatos = text.split(" ");
    }
    
    public String eliminarStop(File f) throws FileNotFoundException {
        Scanner sc = new Scanner(f);
        String text = "";

        while (sc.hasNext()) {
            String t = sc.next().toLowerCase().replaceAll("\\p{Punct}","");
            if(stopwords.contains(t) || t.equals("")) continue;

            text += t+" ";
        }
        
        return text;
    }
    
    public List<File> getFileList() {
        return fileList;
    }

    public List<String[]> getArchivos() {
        return archivos;
    }

    public String[] getBaseDatos() {
        return baseDatos;
    }
}

