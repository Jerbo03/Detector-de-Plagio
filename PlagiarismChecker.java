import java.io.FileNotFoundException;
import java.util.*;

public class PlagiarismChecker {
  // Objetos
  lecturaArchivos lector = new lecturaArchivos();
  // Datos
  List <String[]> bd = new ArrayList();
  HashMap <String, String[]> loadedPaths = new HashMap <String, String[]>(); 

  public boolean loadFiles(String[] paths) {
    bd.clear();
    String[] texto;
    for (String path : paths) {
      System.out.println(
        "\nArchivos Seleccionados:\t" + bd +
        "\nArchivos Cargados:\t" + this.loadedPaths
      );
      if(this.loadedPaths.containsKey(path)) {
        bd.add(this.loadedPaths.get(path));
        continue;
      }
      try {
        texto = lector.leer(path);
        bd.add(texto);
      } catch (FileNotFoundException e) {
        e.printStackTrace();
        return false;
      }
      this.loadedPaths.put(path, texto);
    }
    System.out.println(
      "\nArchivos Cargados:\t" + bd +
      "\nArchivos Seleccionados:\t" + this.loadedPaths
    );
    return true;
  }
  
  public ResultChecker verifyPlagiarism(String path) {
    ResultChecker result = new ResultChecker(bd.size());

    compareFile comparador = null;;
    try {
      comparador = new compareFile(lector.leer(path));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    for (int i=0; i < bd.size(); i++) {
      result.addResult(i, comparador.evaluar(bd.get(i)));
    }

    return result;
  }
}

