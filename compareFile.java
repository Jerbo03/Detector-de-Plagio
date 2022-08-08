import java.util.*;

public class compareFile {
  public double calcularPlagio(Scanner obj1, Scanner obj2) {
    double promedio=0;
    int n=0;
    for( line1 in obj1) {
      double max = 0;
      for( line2 in obj2) {
        double comparacion = compareSentence(line1,lin2);
        if(comparacion>max) max=comparacion;
        n++;
      }
      promedio+=max;
    }
    promedio/=n;
    return promedio;
  }
  
  public double compareSentence(String l1, String l2) {
    int[] v1 = countWords(l1);
    int[] v2 = countWords(l2);
    return pruebaCoseno(v1, v2);
  }
  
  public countWords(String sentence) {
    String[] words = sentence.slpit(" ");
    Hashtable<String, int> count = new Hashtable<String, int>();
    for(int i=0; i<words.length(); i++) {
      if(count.containsKey(words[i])) count.replace(words[i]),count.get(words[i]))++);
      else count.put(words[i]),0);
    }
    return count.keys();
  }
  
  public double pruebaCoseno(int[] v1, int[] v2) {
    
  }
}
