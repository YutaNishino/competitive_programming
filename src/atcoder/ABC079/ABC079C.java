package atcoder.ABC079;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC079C {
    int n;
    int[] nums;
    String[] ops;

    public static void main(String args[]) {
        new ABC079C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        solve();
    }

    void solve() {
        nums = new int[4];
        ops = new String[3];
        for (int i = 0; i < 4; i++) {
            nums[3 - i] = n % 10;
            n /= 10;
        }
        if (dfs(1, nums[0])) {
            System.out.println(nums[0] + ops[0] + nums[1] + ops[1] +
                    nums[2] + ops[2] + nums[3] + "=7");
        }
    }

    boolean dfs(int i, int sum) {
        if (i == 4) {
            return sum == 7;
        }
        ops[i - 1] = "+";
        if (dfs(i + 1, sum + nums[i])) {
            return true;
        }
        ops[i - 1] = "-";
        if (dfs(i + 1, sum - nums[i])) {
            return true;
        }
        ops[i - 1] = "";
        return false;
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
