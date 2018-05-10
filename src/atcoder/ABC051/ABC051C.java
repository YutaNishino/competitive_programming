package atcoder.ABC051;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC051C {
    int sx, sy, tx, ty;

    public static void main(String args[]) {
        new ABC051C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        sx = sc.nextInt();
        sy = sc.nextInt();
        tx = sc.nextInt();
        ty = sc.nextInt();
        solve();
    }

    void solve() {
        int xDiff = Math.abs(tx - sx);
        int yDiff = Math.abs(ty - sy);
        StringBuilder firstRight = new StringBuilder();
        StringBuilder firstLeft = new StringBuilder();
        StringBuilder firstUp = new StringBuilder();
        StringBuilder firstDown = new StringBuilder();
        for (int i = 0; i < xDiff; i++) {
            firstRight.append('R');
            firstLeft.append('L');
        }
        for (int i = 0; i < yDiff; i++) {
            firstUp.append('U');
            firstDown.append('D');
        }
        StringBuilder sb = new StringBuilder();
        sb.append(firstRight);
        sb.append(firstUp);
        sb.append(firstLeft);
        sb.append(firstDown);
        sb.append("DR");
        sb.append(firstRight);
        sb.append(firstUp);
        sb.append("ULU");
        sb.append(firstLeft);
        sb.append("LD");
        sb.append(firstDown);
        sb.append('R');
        System.out.println(sb);
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
