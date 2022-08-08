import java.io.*;
import java.util.*;
import javax.swing.*;

public class lecturaArchivos {
    JFileChooser fileChooser = new JFileChooser ();
    ArrayList <File> fileList = new ArrayList <File> ();
    String[] archivos;
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
            archivos = new String[fileList.size()];
            
            for(int i = 0; i < fileList.size(); i++) {
                archivos[i] = "";
                paths[i] = fileList.get(i).getAbsolutePath();
            }
            
            int c = 0;
            for(File f : fileList) {
                Scanner sc = new Scanner(f);

                while (sc.hasNextLine())
                    archivos[c] += sc.nextLine() + "\n";
                c++;
            }
            
        } catch (NullPointerException e) {
            System.out.println("No se ha seleccionado ningún fichero");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public ArrayList <File> GetFiles () {
        return fileList;
    }
    
    public String[] getPaths() {
        return paths;
    }
    
    public String[] getArchivos() {
        return archivos;
    }
}
