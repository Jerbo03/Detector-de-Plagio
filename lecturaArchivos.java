import java.io.*;
import java.util.*;
import javax.swing.*;

public class lecturaArchivos {
    JFileChooser fileChooser = new JFileChooser ();
    List <File> fileList = new ArrayList <File> ();
    List <String[]> archivos = new ArrayList <String[]> ();
    List<String> stop = Arrays.asList("el","la","los","","");
    
    public void leerArchivos () {
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        if (!fileChooser.isMultiSelectionEnabled()) {
           fileChooser.setMultiSelectionEnabled(true);
        }
        
        fileChooser.showOpenDialog(fileChooser);
        
        try {
            
            for (File f : fileChooser.getSelectedFiles()) {
                fileList.add(f);
            }
            
        } catch (NullPointerException e) {
            System.out.println("No se ha seleccionado ningún archivo.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void guardarArchivos () throws FileNotFoundException {
        for(File f : fileList) {
            Scanner sc = new Scanner(f);
            String text = "";

            while (sc.hasNextLine()) {
                text += sc.nextLine().toLowerCase()+" ";
            }

            archivos.add(text.split("\\. "));
        }
        
        eliminarStop(archivos);
    }
    
    public void eliminarStop(List <String[]> archivos) {
        for (String[] a : archivos) {
            for (int i = 0; i < a.length; i++) {
                
            }
        }
    }

    public List<String[]> getArchivos() {
        return archivos;
    }
}
