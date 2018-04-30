package atcoder.ABC091;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class ABC091C {
    int n;
    Point[] rs, bs;

    public static void main(String args[]) {
        new ABC091C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        rs = new Point[n];
        bs = new Point[n];
        for (int i = 0; i < n; i++) {
            rs[i] = new Point(sc.nextInt(), sc.nextInt());
        }
        for (int i = 0; i < n; i++) {
            bs[i] = new Point(sc.nextInt(), sc.nextInt());
        }
        solve();
    }

    void solve() {
        int count = 0;
        boolean[] paired = new boolean[n];
        Arrays.sort(bs, new sortByX());
        for (int i = 0; i < n; i++) {
            Point b = bs[i];
            int index = -1;
            int maxY = -1;
            for (int j = 0; j < n; j++) {
                if (paired[j] || rs[j].x >= b.x || rs[j].y >= b.y) {
                    continue;
                }
                if (rs[j].y > maxY) {
                    index = j;
                    maxY = rs[j].y;
                }
            }
            if (maxY > -1) {
                paired[index] = true;
                count++;
            }
        }
        System.out.println(count);
    }

    class sortByX implements Comparator<Point> {
        public int compare(Point a, Point b) {
            return a.x - b.x;
        }
    }

    class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class FastReader {
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
