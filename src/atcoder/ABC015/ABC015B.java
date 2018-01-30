package atcoder.ABC015;

import java.util.Scanner;

public class ABC015B {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int fileCount = 0;
        int bugCount = 0;
        for (int i = 0; i < n; i++) {
            int b = sc.nextInt();
            if (b > 0) {
                fileCount++;
                bugCount += b;
            }
        }
        System.out.println((int)
                Math.ceil(Double.valueOf(bugCount) / Double.valueOf(fileCount)));
    }
}
