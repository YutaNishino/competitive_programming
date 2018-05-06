package atcoder.ABC088;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC088C {
    int[][] css;

    public static void main(String args[]) {
        new ABC088C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        css = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                css[i][j] = sc.nextInt();
            }
        }
        solve();
    }

    void solve() {
        boolean flag = true;
        if (!(css[0][0] - css[0][1] == css[1][0] - css[1][1] &&
                css[1][0] - css[1][1] == css[2][0] - css[2][1])) {
            flag = false;
        } else if (!(css[0][1] - css[0][2] == css[1][1] - css[1][2] &&
                css[1][1] - css[1][2] == css[2][1] - css[2][2])) {
            flag = false;
        }
        if (flag) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
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
