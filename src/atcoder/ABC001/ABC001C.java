package atcoder.ABC001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC001C {
    double deg, dis;

    public static void main(String args[]) {
        new ABC001C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        deg = sc.nextInt();
        dis = sc.nextInt();
        solve();
    }

    void solve() {
        String sDeg = "";
        if (112.5 <= deg && deg < 337.5) {
            sDeg = "NNE";
        } else if (337.5 <= deg && deg < 562.5) {
            sDeg = "NE";
        } else if (562.5 <= deg && deg < 787.5) {
            sDeg = "ENE";
        } else if (787.5 <= deg && deg < 1012.5) {
            sDeg = "E";
        } else if (1012.5 <= deg && deg < 1237.5) {
            sDeg = "ESE";
        } else if (1237.5 <= deg && deg < 1462.5) {
            sDeg = "SE";
        } else if (1462.5 <= deg && deg < 1687.5) {
            sDeg = "SSE";
        } else if (1687.5 <= deg && deg < 1912.5) {
            sDeg = "S";
        } else if (1912.5 <= deg && deg < 2137.5) {
            sDeg = "SSW";
        } else if (2137.5 <= deg && deg < 2362.5) {
            sDeg = "SW";
        } else if (2362.5 <= deg && deg < 2587.5) {
            sDeg = "WSW";
        } else if (2587.5 <= deg && deg < 2812.5) {
            sDeg = "W";
        } else if (2812.5 <= deg && deg < 3037.5) {
            sDeg = "WNW";
        } else if (3037.5 <= deg && deg < 3262.5) {
            sDeg = "NW";
        } else if (3262.5 <= deg && deg < 3487.5) {
            sDeg = "NNW";
        } else {
            sDeg = "N";
        }
        int sDis = 0;
        if (dis < 15) {
            sDis = 0;
        } else if (15 <= dis && dis < 93) {
            sDis = 1;
        } else if (93 <= dis && dis < 201) {
            sDis = 2;
        } else if (201 <= dis && dis < 327) {
            sDis = 3;
        } else if (327 <= dis && dis < 477) {
            sDis = 4;
        } else if (477 <= dis && dis < 645) {
            sDis = 5;
        } else if (645 <= dis && dis < 831) {
            sDis = 6;
        } else if (831 <= dis && dis < 1029) {
            sDis = 7;
        } else if (1029 <= dis && dis < 1245) {
            sDis = 8;
        } else if (1245 <= dis && dis < 1467) {
            sDis = 9;
        } else if (1467 <= dis && dis < 1707) {
            sDis = 10;
        } else if (1707 <= dis && dis < 1959) {
            sDis = 11;
        } else {
            sDis = 12;
        }
        if (sDis == 0) {
            sDeg = "C";
        }
        System.out.println(sDeg + " " + sDis);
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
