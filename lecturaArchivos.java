import java.io.*;
import java.util.*;
import javax.swing.*;

public class lecturaArchivos {
    
    String[] DBPaths;
    String textPath;
    HashMap <String, Integer> stopwords;

    JFileChooser fileChooser = new JFileChooser (".");

    public lecturaArchivos() {

        stopwords = new HashMap <String, Integer>();
        try {
            Scanner sc = new Scanner (new FileReader("palabrasStop.txt"));        
            while (sc.hasNext()) {
                stopwords.put(sc.next(), stopwords.size());
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        
    }
    
    public void getCurrentDirectory() {
        File workingDirectory = new File(System.getProperty("user.dir"));
        fileChooser.setCurrentDirectory(workingDirectory);
    }

    public void addDbFile () {
        getCurrentDirectory();

        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (!fileChooser.isMultiSelectionEnabled()) {
           fileChooser.setMultiSelectionEnabled(true);
        }
        
        fileChooser.showOpenDialog(fileChooser);
        
        try {
            File[] f = fileChooser.getSelectedFiles();  
            int size = f.length;
            DBPaths = new String[size];
                    
            for(int i = 0; i < size; i++) {
                DBPaths[i] = f[i].getAbsolutePath();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void setTextPath () {
        getCurrentDirectory();
        
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
            String t = sc.next().replaceAll("\\p{Punct}","");
            if(stopwords.containsKey(t) || t.equals("")) continue;

            text += t+" ";
        }
        return text.split(" ");
    }
}
