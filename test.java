import java.io.FileNotFoundException;

public class test {
    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();
        
        test02();    
    
        final long endTime = System.currentTimeMillis();

        System.out.println("Total execution time: " + (endTime - startTime) + " ms");
    }

    public static void test01() {
        PlagiarismChecker checker = new PlagiarismChecker();
        //lecturaArchivos lector = new lecturaArchivos();

        String[] paths = {
            "./archivos/poema.txt",
            "./archivos/laPalomaYLaHormiga.txt"
        };

        try {
            checker.loadFiles(paths);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        String path = "./datos/test.txt";
        boolean[] r = checker.verifyPlagiarism(path).result;
        for (boolean e : r)
            System.out.println(e);
    }

    public static void test02() {
        VentanaPrincipal mio = new VentanaPrincipal();
        mio.setVisible(true);
    }
}
