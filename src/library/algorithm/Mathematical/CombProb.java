package library.algorithm.Mathematical;

public class CombProb {
    static double[][] combProb(int num) {
        double[][] comb = new double[num][num];
        comb[0][0] = 1;
        for (int i = 1; i < comb.length; i++) {
            for (int j = 0; j <= i; j++) {
                comb[i][j] = (comb[i - 1][j] +
                        (j > 0 ? comb[i - 1][j - 1] : 0)) * 0.5;
            }
        }
        return comb;
    }
}
