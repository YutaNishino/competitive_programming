package atcoder.ABC028;

import java.util.Scanner;

public class ABC028B {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        char[] cs = sc.next().toCharArray();
        int[] count = new int[6];
        for (char c: cs) {
            count[c - 'A']++;
        }
        System.out.printf("%d %d %d %d %d %d\n",
                count[0], count[1], count[2], count[3], count[4], count[5]);
    }
}
