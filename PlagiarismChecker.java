import java.util.*;

public class PlagiarismChecker {
  // Objetos
  lecturaArchivos lector = new lecturaArchivos();

  // Datos
  List <String[]> bd = new ArrayList();

  public boolean loadFiles(String[] paths) {
    for (String path : paths) {
      if (!(bd.Add(lector.leer(path)))) return false;
    }
    return true;
  }
  
  public ResultChecker verifyPlagiarism(String path) {
    ResultChecker result = new ResultChecker(bd.size());

    compareFile comparador = new compareFile(lector.leer(path));
    for (int i=0; i < bd.size(); i++) {
      result.addResult(comparador.evaluar(bd.get(i)));
    }


    return result;
  }
}
