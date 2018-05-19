package atcoder.indeed_now2015A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class indeed_now2015AB {
    int n;

    public static void main(String args[]) {
        new indeed_now2015AB().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        Map<Character, Integer> correctMap = new HashMap<>();
        correctMap.put('i', 1);
        correctMap.put('n', 2);
        correctMap.put('d', 2);
        correctMap.put('e', 2);
        correctMap.put('o', 1);
        correctMap.put('w', 1);
        for (int i = 0; i < n; i++) {
            Map<Character, Integer> map = new HashMap<>();
            char[] cs = sc.next().toCharArray();
            for (int j = 0; j < cs.length; j++) {
                if (!map.containsKey(cs[j])) {
                    map.put(cs[j], 1);
                } else {
                    map.put(cs[j], map.get(cs[j]) + 1);
                }
            }
            if (map.equals(correctMap)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
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
