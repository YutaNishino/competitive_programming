package codeforces.Edu38;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Edu38A {
    public static void main(String args[]) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        String s = sc.next();
        List<String> vowels = new ArrayList<String>(Arrays.asList("a", "e", "i", "o", "u", "y"));
        boolean flag = true;
        boolean firstFlag = false;
        for (int i = 0; i < s.length(); i++) {
            if(vowels.contains(s.substring(i,i + 1))) {
                if (firstFlag) {
                    s = s.substring(0, i) +
                            s.substring(i + 1, s.length());
                    i--;
                } else {
                    firstFlag = true;
                }
            } else {
                firstFlag = false;
            }
        }
        System.out.println(s);
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
