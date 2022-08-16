public class ResultChecker {
    public boolean[] result;

    public ResultChecker(int n) {
        this.result = new boolean[n];
    }

    public void addResult(int i, boolean r) {
        this.result[i] = r;
    }

    public void restart() {
        for (int i=0; i<result.length; i++)
            this.result[i] = false;
    }
}
