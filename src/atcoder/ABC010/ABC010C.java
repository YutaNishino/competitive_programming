package atcoder.ABC010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC010C {
    int txa, tya, txb, tyb, t, v, n;

    public static void main(String args[]) {
        new ABC010C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        txa = sc.nextInt();
        tya = sc.nextInt();
        txb = sc.nextInt();
        tyb = sc.nextInt();
        t = sc.nextInt();
        v = sc.nextInt();
        n = sc.nextInt();
        int movedDistance = t * v;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            double distanceA = Math.sqrt((x - txa) * (x - txa) + (y - tya) * (y - tya));
            double distanceB = Math.sqrt((x - txb) * (x - txb) + (y - tyb) * (y - tyb));
            if (distanceA + distanceB <= movedDistance) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
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
