package atcoder.ABC015;

import java.util.Scanner;

public class ABC015D {
    static int w, n, k;
    static int[] A, B;
    static int[][][] field;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        w = sc.nextInt();
        n = sc.nextInt();
        k = sc.nextInt();
        A = new int[n];
        B = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
            B[i] = sc.nextInt();
        }
        field = new int[n + 1][k + 2][w + 2];
        for (int i = 0; i < field.length; i++)
            for (int j = 0; j < field[0].length; j++)
                for (int k = 0; k < field[0][0].length; k++)
                    field[i][j][k] = -1;
        field[0][0][0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                for (int l = 0; l <= w; l++) {
                    // unreachable
                    if (field[i][j][l] == -1) continue;
                    // k screenshots already placed
                    if (j == k)
                        field[i + 1][j][l] = Math.max(field[i + 1][j][l],
                                field[i][j][l]);
                    else if (l + A[i] <= w) {
                        field[i + 1][j + 1][l + A[i]] =
                                Math.max(field[i + 1][j + 1][l + A[i]],
                                        field[i][j][l] + B[i]);
                        field[i + 1][j][l] =
                                Math.max(field[i + 1][j][l],
                                        field[i][j][l]);
                    } else {
                        field[i + 1][j][l] =
                                Math.max(field[i + 1][j][l],
                                        field[i][j][l]);
                    }
                }
            }
        }

        int ans = 0;
        for (int j = 0; j < field[0].length; j++) {
            for (int l = 0; l < field[0][0].length; l++) {
                ans = Math.max(ans, field[n][j][l]);
            }
        }
        System.out.println(ans);
    }
}
