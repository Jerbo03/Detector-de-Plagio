import java.io.FileNotFoundException;

public class test {
    public static void main(String[] args) {        
        final long startTime = System.currentTimeMillis();
        
        PlagiarismChecker checker = new PlagiarismChecker();
        //lecturaArchivos lector = new lecturaArchivos();

        lecturaArchivos lector = new lecturaArchivos();
        lector.addDbFile();

        String[] paths = lector.DBPaths;
        /*{
            "./archivos/poema.txt",
            "./archivos/laPalomaYLaHormiga.txt"
        };*/

        try {
            checker.loadFiles(paths);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        lector.setTextPath();
        String path = lector.textPath; //"./datos/test.txt";
        
        boolean[] r = checker.verifyPlagiarism(path).result;
        for (boolean e : r)
            System.out.println(e);

        final long endTime = System.currentTimeMillis();

        System.out.println("Total execution time: " + (endTime - startTime) + " ms");
    }
}
