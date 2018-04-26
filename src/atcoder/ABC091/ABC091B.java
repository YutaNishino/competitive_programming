package atcoder.ABC091;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ABC091B {
    public static void main(String args[]) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) ss[i] = sc.next();
        int m = sc.nextInt();
        String[] ts = new String[m];
        for (int i = 0; i < m; i++) ts[i] = sc.next();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(ss[i])) map.put(ss[i], map.get(ss[i]) + 1);
            else map.put(ss[i], 1);
        }
        for (int i = 0; i < m; i++) {
            if (map.containsKey(ts[i])) map.put(ts[i], map.get(ts[i]) - 1);
        }
        int max = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            if (count > max) max = count;
        }
        System.out.println(max);
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
}
