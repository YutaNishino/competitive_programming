package codeforces.Div3_479;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Div3_479F {
    int n;
    Pair[] as;

    public static void main(String args[]) {
        new Div3_479F().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        as = new Pair[n];
        for (int i = 0; i < n; i++) {
            as[i] = new Pair(sc.nextInt(), i);
        }
        solve();
    }

    void solve() {
        Arrays.sort(as, (a, b) -> a.value - b.value);
        int maxLen = 0;
        int startIndex = 0;
        int prevValue = as[0].value;
        int prevIndex = as[0].index;
        int len = 0;
        int tempStart = 0;
        for (int i = 1; i < as.length; i++) {
            if (as[i].value == prevValue + 1 && as[i].index > prevIndex) {
                len++;
                prevValue++;
                prevIndex = as[i].index;
                if (len > maxLen) {
                    maxLen = len;
                    startIndex = tempStart;
                }
            } else {
                len = 0;
                prevValue = as[i].value;
                prevIndex = as[i].index;
                tempStart = i;
            }
        }
        System.out.println(maxLen);
        for (int i = startIndex; i < startIndex + maxLen; i++) {
            System.out.print(as[i].index);
            System.out.print(as[i].value);
            if (i < startIndex + maxLen - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    class Pair {
        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
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
