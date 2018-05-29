package atcoder.ABC001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ABC001D {
    int n;

    public static void main(String args[]) {
        new ABC001D().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        BitSet b = new BitSet();
        for(int i = 0; i < n; i++) {
            String[] v = sc.next().split("-");
            int f = Integer.parseInt(v[0]);
            int t = Integer.parseInt(v[1]);
            b.set((f / 100 * 60 + f % 100) / 5 * 5, (t / 100 * 60 + t % 100 + 4) / 5 * 5 + 1);
        }
        for(int i = b.nextSetBit(0), j=b.nextClearBit(i);
            i != -1;
            i = b.nextSetBit(j), j = b.nextClearBit(i+1)) {
            System.out.printf("%04d-%04d\n", i / 60 * 100 + i % 60, j / 60 * 100 + (j - 1) % 60);
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
