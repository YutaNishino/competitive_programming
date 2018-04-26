package atcoder.ABC091;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class ABC091C {
    public static void main(String args[]) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        Pair[] reds = new Pair[n];
        Pair[] blues = new Pair[n];
        for(int i = 0; i < n; i++) {
            reds[i] = new Pair(sc.nextInt(), sc.nextInt());
        }
        for(int i = 0; i < n; i++) {
            blues[i] = new Pair(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(reds, Collections.reverseOrder());
        Arrays.sort(blues);

        int ans = check(reds, blues);
        System.out.println(ans);
    }

    static int check(Pair[] reds, Pair[] blues) {
        if (reds.length == 1) {
            System.out.printf("%d %d %d %d\n", reds[0].x, reds[0].y, blues[0].x, blues[0].y);
            if (goodPair(reds[0], blues[0])) return 1;
            else return 0;
        }
        int max = 0;
        int temp = 0;
        for (int i = 0; i < reds.length; i++) {
            Pair red = reds[i];
            for (int j = 0; j < blues.length; j++) {
                Pair blue = blues[j];
                Pair[] newReds = new Pair[reds.length - 1];
                int offsetRed = 0;
                for (int k = 0; k < newReds.length; k++) {
                    if (k != i) newReds[k] = reds[k + offsetRed];
                    else offsetRed = 1;
                }
                Pair[] newBlues = new Pair[blues.length - 1];
                int offsetBlue = 0;
                for (int k = 0; k < newBlues.length; k++) {
                    if (k != i) newBlues[k] = blues[k + offsetBlue];
                    else offsetBlue = 1;
                }
                int sub = check(newReds, newBlues);
                if (goodPair(red, blue)) {
                    temp =  sub + 1;
                } else {
                    temp = sub;
                }
                if (temp > max) max = temp;
            }
        }
        return max;
    }

    static boolean goodPair(Pair red, Pair blue) {
        if (red.x < blue.x && red.y < blue.y) return true;
        else return false;
    }

    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
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

        String nextLine()
        {
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

    static class Pair implements Comparable<Pair> {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Pair p) {
            return this.x - p.x;
        }
    }
}
