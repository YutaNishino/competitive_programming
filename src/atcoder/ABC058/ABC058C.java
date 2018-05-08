package atcoder.ABC058;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ABC058C {
    int n;
    SortedSet<Character> set;
    List<Map<Character, Integer>> maps;

    public static void main(String args[]) {
        new ABC058C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        set = new TreeSet<>();
        maps = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] cs = sc.next().toCharArray();
            maps.add(new HashMap<>());
            for (int j = 0; j < cs.length; j++) {
                set.add(cs[j]);
                if (maps.get(i).containsKey(cs[j])) {
                    maps.get(i).put(cs[j], maps.get(i).get(cs[j]) + 1);
                } else {
                    maps.get(i).put(cs[j], 1);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        Iterator<Character> it = set.iterator();
        while (it.hasNext()) {
            char c = it.next();
            int minNum = 100;
            for (int i = 0; i < n; i++) {
                int num = 0;
                if (maps.get(i).containsKey(c)) {
                    num = maps.get(i).get(c);
                }
                if (num < minNum) {
                    minNum = num;
                }
            }
            while (minNum > 0) {
                sb.append(c);
                minNum--;
            }
        }
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
