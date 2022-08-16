import java.io.FileNotFoundException;
import java.util.*;

public class PlagiarismChecker {
  // Objetos
  lecturaArchivos lector = new lecturaArchivos();
  // Datos
  List <String[]> bd = new ArrayList();

  public boolean loadFiles(String[] paths) {
    for (String path : paths) {
      try {
        bd.add(lector.leer(path));
      } catch (FileNotFoundException e) {
        e.printStackTrace();
        return false;
      }
    }
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

