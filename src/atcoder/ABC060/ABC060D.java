package atcoder.ABC060;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ABC060D {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        long w1;
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for (int i = 0; i < 4; i++) al.add(new ArrayList<>());
        w1 = sc.nextInt();
        al.get(0).add(sc.nextInt());
        for (int i = 1; i < n; i++) {
            al.get((int)(sc.nextInt() - w1)).add(sc.nextInt());
        }
        for (ArrayList<Integer> a : al) {
            Collections.sort(a, Collections.reverseOrder());
        }

        long ans = 0;
        for (int i = 0; i <= al.get(0).size(); i++) {
            for (int j = 0; j <= al.get(1).size(); j++) {
                for (int k = 0; k <= al.get(2).size(); k++) {
                    for (int l = 0; l <= al.get(3).size(); l++) {
                        long weight = (i + j + k + l) * w1 + j + 2 * k + 3 * l;
                        if (weight > w) continue;
                        long candidate = 0;
                        for (int m = 0; m < i; m++) candidate += al.get(0).get(m);
                        for (int m = 0; m < j; m++) candidate += al.get(1).get(m);
                        for (int m = 0; m < k; m++) candidate += al.get(2).get(m);
                        for (int m = 0; m < l; m++) candidate += al.get(3).get(m);
                        if (ans < candidate) {
                            ans = candidate;
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
