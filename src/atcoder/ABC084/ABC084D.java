package atcoder.ABC084;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC084D {
    int q;

    public static void main(String args[]) {
        new ABC084D().run();
    }

    void run() {
        FastReader sc = new FastReader();
        q = sc.nextInt();
        Primes p = new Primes();
        boolean[] isPrimes = p.primeSieve(100000);
        int[] likeNums = new int[100001];
        for (int i = 1; i < 100001; i += 2) {
            if (isPrimes[i] && isPrimes[(i + 1) / 2]) {
                likeNums[i] = 1;
            }
        }
        for (int i = 1; i < 100001; i++) {
            likeNums[i] = likeNums[i - 1] + likeNums[i];
        }
        for (int i = 0; i < q; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            System.out.println(likeNums[r + 1] - likeNums[l - 1]);
        }
    }

    class Primes {
        boolean[] primeSieve(int n) {
            boolean[] isPrime = new boolean[n+1];
            for (int i = 2; i <= n; i++) {
                isPrime[i] = true;
            }

            // mark non-primes <= n using Sieve of Eratosthenes
            for (int factor = 2; factor*factor <= n; factor++) {

                // if factor is prime, then mark multiples of factor as nonprime
                // suffices to consider mutiples factor, factor+1, ...,  n/factor
                if (isPrime[factor]) {
                    for (int j = factor; factor*j <= n; j++) {
                        isPrime[factor*j] = false;
                    }
                }
            }
            return isPrime;
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
