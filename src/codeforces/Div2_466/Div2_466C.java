package codeforces.Div2_466;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Div2_466C {
    public static void main(String args[]) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int k = sc.nextInt();
        Character[] ss = sc.next().chars().mapToObj(c -> (char)c).toArray(Character[]::new);
        ArrayList<Character> unique = new ArrayList<>(Arrays.asList(
                Arrays.stream(ss).distinct().toArray(Character[]::new)));
        Collections.sort(unique);
        char[] ans = new char[k];
        boolean done = false;
        for (int i = k - 1; i >= 0; i--) {
            if (i >= n){
                ans[i] = unique.get(0);
                done = true;
            } else if (done) ans[i] = ss[i];
            else {
                int index = unique.indexOf(ss[i]);
                if (index == unique.size() - 1) {
                    ans[i] = unique.get(0);
                } else {
                    ans[i] = unique.get(index + 1);
                    done = true;
                }
            }
        }
        System.out.println(String.valueOf(ans));
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
