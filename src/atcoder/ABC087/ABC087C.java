package atcoder.ABC087;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ABC087C {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] field = new int[2][n];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                field[i][j] = sc.nextInt();
            }
        }
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = IntStream.of(Arrays.copyOfRange(field[0], 0, i + 1)).sum();
            array[i] += IntStream.of(Arrays.copyOfRange(field[1], i, n)).sum();
        }
        System.out.println(Arrays.stream(array).max().getAsInt());
    }
}