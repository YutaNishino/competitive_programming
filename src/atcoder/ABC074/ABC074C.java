package atcoder.ABC074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC074C {
    int a, b, c, d, e, f;

    public static void main(String args[]) {
        new ABC074C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();
        e = sc.nextInt();
        f = sc.nextInt();
        solve();
    }

    void solve() {
        double concentration = -1.0;
        int mass = -1;
        int sugar = -1;
        for (int i = 0; i * 100 * a < f; i++) {
            for (int j = 0; j * 100 * b < f; j++) {
                for (int k = 0; k * c < f; k++) {
                    for (int l = 0; l * d < f; l++) {
                        if (i == 0 && j == 0 && k == 0 && l == 0) {
                            continue;
                        }
                        int tempMass = i * 100 * a + j * 100 * b + k * c + l * d;
                        if (tempMass > f) {
                            continue;
                        }
                        int tempSugar = k * c + l * d;
                        if (100 * tempSugar * (100 + e) > 100 * e * (tempMass)) {
                            continue;
                        }
                        double tempConcentration = 100.0 * tempSugar / tempMass;
                        if (tempConcentration > concentration) {
                            concentration = tempConcentration;
                            mass = tempMass;
                            sugar = tempSugar;
                        }
                    }
                }
            }
        }
        System.out.println(mass + " " + sugar);
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
