package atcoder.ABC092;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC092D {
    public static void main(String args[]) {
        FastReader sc = new FastReader();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int h = 100;
        int w = 100;
        char[][] grid = new char[h][w];
        boolean aGreater = false;
        char less = '.';
        char more = '#';
        int white = 1;
        int black = 0;
        if (a > b) {
            aGreater = true;
            less = '#';
            more = '.';
            white = 0;
            black = 1;
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                grid[i][j] = less;
            }
        }
        int rowOffset = 0;
        int columnOffset = 0;
        while (white < a && black < b) {
            grid[rowOffset][columnOffset] = more;
            grid[rowOffset][columnOffset + 1] = more;
            grid[rowOffset][columnOffset + 2] = more;
            grid[rowOffset + 1][columnOffset] = more;
            grid[rowOffset + 1][columnOffset + 2] = more;
            grid[rowOffset + 2][columnOffset] = more;
            grid[rowOffset + 2][columnOffset + 1] = more;
            grid[rowOffset + 2][columnOffset + 2] = more;
            if (columnOffset + 4 < w) columnOffset += 4;
            else {
                columnOffset = 0;
                rowOffset += 4;
            }
            white++;
            black++;
        }
        columnOffset = 0;
        rowOffset += 4;

        if (aGreater) {
            while(white < a) {
                grid[rowOffset][columnOffset] = more;
                if (columnOffset + 2 < w) columnOffset += 2;
                else {
                    columnOffset = 0;
                    rowOffset += 2;
                }
                white++;
            }
        }
        else {
            while(black < b) {
                grid[rowOffset][columnOffset] = more;
                if (columnOffset + 2 < w) columnOffset += 2;
                else {
                    columnOffset = 0;
                    rowOffset += 2;
                }
                black++;
            }
        }

        System.out.printf("%d %d\n", h, w);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
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
