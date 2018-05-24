package atcoder.ABC009;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ABC009C {
    int n, k;
    char[] cs;

    public static void main(String args[]) {
        new ABC009C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        k = sc.nextInt();
        cs = sc.next().toCharArray();
        solve();
    }

    void solve() {
        SortedMap<Character, Integer> sMap = new TreeMap<>();
        SortedMap<Character, Integer> tMap = new TreeMap<>();
        for (int i = 0; i < cs.length; i++) {
            if (!sMap.containsKey(cs[i])) {
                sMap.put(cs[i], 1);
                tMap.put(cs[i], 1);
            } else {
                sMap.put(cs[i], sMap.get(cs[i]) + 1);
                tMap.put(cs[i], tMap.get(cs[i]) + 1);
            }
        }
        int count = 0;
        char[] ans = new char[cs.length];
        for (int i = 0; i < n; i++) {
            char first = tMap.firstKey();
            //System.out.println(cs[i] + " " + first);
            if (first == cs[i]) {
                if (sMap.get(first) == 1) {
                    sMap.remove(first);
                } else {
                    sMap.put(first, sMap.get(first) - 1);
                }
                if (tMap.get(first) == 1) {
                    tMap.remove(first);
                } else {
                    tMap.put(first, tMap.get(first) - 1);
                }
            } else {
                count++;
                if (sMap.get(first) == 1) {
                    sMap.remove(first);
                } else {
                    sMap.put(first, sMap.get(first) - 1);
                }
                if (tMap.get(first) == 1) {
                    tMap.remove(first);
                } else {
                    tMap.put(first, tMap.get(first) - 1);
                }
                int misMatch = cs.length - i - 1;
                for (int j = 0; j < 26; j++) {
                    int sNum = sMap.getOrDefault((char)(j + 'a'), 0);
                    int tNum = tMap.getOrDefault((char)(j + 'a'), 0);
                    misMatch -= Math.min(sNum, tNum);
                }
                //System.out.println(misMatch);
                if (count + 1 + misMatch > k) {
                    if (!sMap.containsKey(first)) {
                        sMap.put(first, 1);
                    } else {
                        sMap.put(first, sMap.get(first) + 1);
                    }
                    for (int j = i; j < cs.length; j++) {
                        if (sMap.containsKey(cs[j])) {
                            ans[j] = cs[j];
                            if (sMap.get(cs[j]) == 1) {
                                sMap.remove(cs[j]);
                            } else {
                                sMap.put(cs[j], sMap.get(cs[j]) - 1);
                             }
                        }
                    }
                    //System.out.println(Arrays.toString(ans));
                    for (int j = i; j < cs.length; j++) {
                        if (ans[j] == 0) {
                            char next = sMap.firstKey();
                            ans[j] = next;
                            if (sMap.get(next) == 1) {
                                sMap.remove(next);
                            } else {
                                sMap.put(next, sMap.get(next) - 1);
                            }
                        }
                    }
                    for (int j = 0; j < cs.length; j++) {
                        System.out.print(ans[j]);
                    }
                    System.out.println();
                    return;
                }

            }
            ans[i] = first;
        }
        for (int i = 0; i < cs.length; i++) {
            System.out.print(ans[i]);
        }
        System.out.println();
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
