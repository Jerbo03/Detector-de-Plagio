import java.io.*;
import java.util.*;
import javax.swing.*;

public class lecturaArchivos {
    JFileChooser fileChooser = new JFileChooser ();
    ArrayList <File> fileList = new ArrayList <File> ();
    String[] paths;
    
    
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
            
            paths = new String[fileList.size()];
            
            for(int i = 0; i < fileList.size(); i++) {
                paths[i] = fileList.get(i).getAbsolutePath();
            }
            
        } catch (NullPointerException e) {
            System.out.println("No se ha seleccionado ningún archivo");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public String[] getPaths() {
        return paths;
    }
}
