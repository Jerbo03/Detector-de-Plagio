import java.io.*;
import java.util.*;
import javax.swing.*;

public class lecturaArchivos {
    
    String[] DBPaths;
    String textPath;
    List <String> stopwords;

    public lecturaArchivos() {
        
        stopwords = new ArrayList <String>();
        
        Scanner sc = null;;
        try {
            sc = new Scanner (new FileReader("palabrasStop.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }        
        while (sc.hasNext()) {
            stopwords.add(sc.next());
        }
    }
    
    public void addDbFile () {
        JFileChooser fileChooser = new JFileChooser ();
        ArrayList <File> fileList = new ArrayList <File> ();
        
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (!fileChooser.isMultiSelectionEnabled()) {
           fileChooser.setMultiSelectionEnabled(true);
        }
        
        fileChooser.showOpenDialog(fileChooser);
        
        try {
            for (File f : fileChooser.getSelectedFiles()) {
                fileList.add(f);
            }
            
            DBPaths = new String[fileList.size()];
            
            for(int i = 0; i < fileList.size(); i++) {
                DBPaths[i] = fileList.get(i).getAbsolutePath();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void setTextPath () {
        JFileChooser fileChooser = new JFileChooser ();
        
        fileChooser.showOpenDialog(fileChooser);
        
        try {
            textPath = fileChooser.getSelectedFile().getAbsolutePath();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public String[] leer(String path) throws FileNotFoundException {
        
        File f = new File(path);
        Scanner sc = new Scanner(f);
        String text = "";

        while (sc.hasNext()) {
            String t = sc.next().toLowerCase().replaceAll("\\p{Punct}","");
            if(stopwords.contains(t) || t.equals("")) continue;

            text += t+" ";
        }
        return text.split(" ");
    }
}

