package codeforces.Edu43;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Edu43C {
    int n;
    Event[] events;

    public static void main(String args[]) {
        new Edu43C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        events = new Event[n];
        for (int i = 0; i < n; i++) {
            events[i] = new Event(sc.nextInt(), sc.nextInt(), i + 1);
        }
        solve();
    }

    void solve() {
        Arrays.sort(events, (a, b) -> ((a.l != b.l) ? (a.l - b.l) : b.r - a.r));
        int rMax = 0;
        int index = -1;
        for (Event e : events) {
            if (rMax >= e.r) {
                System.out.println(e.index + " " + index);
                return;
            } else {
                rMax = e.r;
                index = e.index;
            }
        }
        System.out.println("-1 -1");
    }

    class Event {
        int l;
        int r;
        int index;

        Event(int l, int r, int index) {
            this.l = l;
            this.r = r;
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
