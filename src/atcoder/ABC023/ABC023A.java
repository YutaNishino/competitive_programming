package atcoder.ABC023;

import java.util.Arrays;
import java.util.Scanner;

public class ABC023A {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String x = sc.next();
        System.out.println(Arrays.stream(x.split("")).map(
                Integer::valueOf).mapToInt(i->i).sum());
    }
}
