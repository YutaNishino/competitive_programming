package library.algorithm.Mathematical;

public class Matrix {
    long[][] modPowMatrix(long[][] matrix, int n, int mod) {
        long[][] ret = matrix.clone();
        while (n > 0) {
            if (n % 2 == 1) {
                ret = modMultiplyMatrix(ret, matrix, mod);
            }
            n /= 2;
            matrix = modMultiplyMatrix(matrix, matrix, mod);
        }
        return ret;
    }

    long[][] modMultiplyMatrix(long[][] a, long[][] b, int mod) {
        long[][] ret = new long[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    ret[i][j] = (ret[i][j] + a[i][k] * b[k][j]) % mod;
                }
            }
        }
        return ret;
    }

    long[] modMultiplyVector(long[][] matrix, long[] vector, int mod) {
        long[] ret = new long[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                ret[i] = (ret[i] + matrix[i][j] * vector[j]) % mod;
            }
        }
        return ret;
    }
}
