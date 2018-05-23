package atcoder.ABC014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC014C {
    int n;

    public static void main(String args[]) {
        new ABC014C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        int[] nums = new int[1000002];
        for (int i = 0; i < n; i++) {
            nums[sc.nextInt()]++;
            nums[sc.nextInt() + 1]--;
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
            max = Math.max(max, nums[i]);
        }
        System.out.println(max);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}
