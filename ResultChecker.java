public class ResultChecker {
    boolean[] result;
    int index;

    public ResultChecker(int n) {
        this.result = new boolean[n];
        this.index = 0;
    }

    public void addResult(boolean r) {
        if (this.index == this.result.length) return;
        this.result[index] = r;
        this.index++;
    }
}
