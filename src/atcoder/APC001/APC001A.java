package atcoder.APC001;

import java.util.Scanner;

public class APC001A {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        if (x % y != 0) {
            System.out.println(x);
        } else {
            System.out.println(-1);
        }
    }
}
