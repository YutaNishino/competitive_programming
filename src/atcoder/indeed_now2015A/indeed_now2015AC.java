package atcoder.indeed_now2015A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class indeed_now2015AC {
    int n, q;
    List<Integer> sn;

    public static void main(String args[]) {
        new indeed_now2015AC().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        sn = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            if (temp > 0) {
                sn.add(temp);
            }
        }
        Collections.sort(sn, Collections.reverseOrder());
        //int max = sn[n - 1];
        q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int k = sc.nextInt();
            int ans = 0;
            if (k < sn.size()) {
                ans = sn.get(k) + 1;
            }
            System.out.println(ans);
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
