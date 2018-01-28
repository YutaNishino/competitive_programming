package atcoder.ABC085;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ABC085D {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int h = sc.nextInt();
        int count = 0;
        ArrayList<Integer> attack = new ArrayList<>();
        ArrayList<Integer> throwPoint = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            attack.add(sc.nextInt());
            throwPoint.add(sc.nextInt());
        }
        int maxAttack = Collections.max(attack);
        Collections.sort(throwPoint, Collections.reverseOrder());
        for (int point : throwPoint) {
            if (maxAttack < point) {
                h -= point;
                count++;
                if (h <= 0) {
                    System.out.println(count);
                    return;
                }
            }
        }
        while (h > 0) {
            h -= maxAttack;
            count++;
        }
        System.out.println(count);
    }
}
