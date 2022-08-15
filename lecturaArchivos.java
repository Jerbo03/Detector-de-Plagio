import java.io.*;
import java.util.*;
import java.util.stream.*;

import javax.swing.*;

public class lecturaArchivos {
    JFileChooser fileChooser = new JFileChooser ();
    List <File> fileList = new ArrayList <File> ();
    List <String[]> archivos = new ArrayList <String[]> ();
    List<String> stopwords = new ArrayList <String> ();
    
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
                ArrayList<String> palabras = Stream.of(a[i].split(" ")).collect(Collectors.toCollection(ArrayList<String>::new));
                palabras.removeAll(stopwords);

                a[i] = palabras.stream().collect(Collectors.joining(" "));
            }
        }
    }

    public List<File> getFileList() {
        return fileList;
    }

    public List<String[]> getArchivos() {
        return archivos;
    }
}
