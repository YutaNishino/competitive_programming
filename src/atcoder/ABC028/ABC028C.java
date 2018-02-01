package atcoder.ABC028;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ABC028C {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> q = new PriorityQueue<>(
                10, Collections.reverseOrder());
        int[] nums = new int[5];
        for (int i = 0; i < 5; i++) {
            nums[i] = sc.nextInt();
        }
        for (int i = 0; i < 3; i++) {
            for(int j = i + 1; j < 4; j++) {
                for (int k = j + 1; k < 5; k++) {
                    q.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }

        int ans = q.poll();
        ans = q.poll();
        ans = q.poll();
        System.out.println(ans);
    }
}
