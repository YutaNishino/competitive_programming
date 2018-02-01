package atcoder.ABC070;

import java.util.Arrays;
import java.util.Scanner;

public class ABC070B {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[4];
        for (int i = 0; i < nums.length; i++)
            nums[i] = sc.nextInt();
        if (nums[2] > nums[1] || nums[3] < nums[0]) {
            System.out.println(0);
            return;
        }
        Arrays.sort(nums);
        System.out.println(nums[2] - nums[1]);
    }
}
