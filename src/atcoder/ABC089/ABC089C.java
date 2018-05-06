package atcoder.ABC089;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC089C {
    int n;
    int[] march = new int[5];

    public static void main(String args[]) {
        new ABC089C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            switch (sc.next().charAt(0)) {
                case 'M':
                    march[0]++;
                    break;
                case 'A':
                    march[1]++;
                    break;
                case 'R':
                    march[2]++;
                    break;
                case 'C':
                    march[3]++;
                    break;
                case 'H':
                    march[4]++;
                    break;
            }
        }
        solve();
    }

    void solve() {
        long count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 4; j++) {
                for (int k = j + 1; k < 5; k++) {
                    count += (long)march[i] * march[j] * march[k];
                }
            }
        }
        System.out.println(count);
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
