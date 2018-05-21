package atcoder.CODE_FESTIVAL_2014_qual_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class CODE_FESTIVAL_2014_qual_B_C {
    char[] s1, s2, s3;

    public static void main(String args[]) {
        new CODE_FESTIVAL_2014_qual_B_C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        s1 = sc.next().toCharArray();
        s2 = sc.next().toCharArray();
        s3 = sc.next().toCharArray();
        solve();
    }

    void solve() {
        Map<Character, Integer> s1Map = new HashMap<>();
        for (int i = 0; i < s1.length; i++) {
            if (!s1Map.containsKey(s1[i])) {
                s1Map.put(s1[i], 1);
            } else {
                s1Map.put(s1[i], s1Map.get(s1[i]) + 1);
            }
        }
        Map<Character, Integer> s2Map = new HashMap<>();
        for (int i = 0; i < s2.length; i++) {
            if (!s2Map.containsKey(s2[i])) {
                s2Map.put(s2[i], 1);
            } else {
                s2Map.put(s2[i], s2Map.get(s2[i]) + 1);
            }
        }
        Map<Character, Integer> s3Map = new HashMap<>();
        for (int i = 0; i < s3.length; i++) {
            if (!s3Map.containsKey(s3[i])) {
                s3Map.put(s3[i], 1);
            } else {
                s3Map.put(s3[i], s3Map.get(s3[i]) + 1);
            }
        }
        boolean flag = true;
        int s1MinNum = 0;
        int s1MaxNum = 0;
        for (Map.Entry<Character, Integer> entry : s3Map.entrySet()) {
            char c = entry.getKey();
            int s3Value = entry.getValue();
            int s1Value = s1Map.getOrDefault(c, 0);
            int s2Value = s2Map.getOrDefault(c, 0);
            int minNum = Math.max(0, s3Value - s2Value);
            int maxNum = Math.min(s1Value, s3Value);
            if (maxNum < minNum) {
                flag = false;
                break;
            }
            s1MinNum += minNum;
            s1MaxNum += maxNum;
        }
        int n = s3.length / 2;
        if (s1MinNum > n || n > s1MaxNum) {
            flag = false;
        }
        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
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
