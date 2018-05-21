package codeforces.Div2_478;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Div2_478C {
    int n, q;
    long[] as, ks;

    public static void main(String args[]) {
        new Div2_478C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        q = sc.nextInt();
        as = new long[n];
        ks = new long[q];
        for (int i = 0; i < n; i++) {
            as[i] = sc.nextInt();
        }
        for (int i = 0; i < q; i++) {
            ks[i] = sc.nextLong();
        }
        solve();
    }

    void solve() {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += as[i];
        }
        long[] sumStrengths = new long[n];
        sumStrengths[0] = as[0];
        for (int i = 1; i < n; i++) {
            sumStrengths[i] = sumStrengths[i - 1] + as[i];
        }
        long tempSum = sum;
        int firstStanding = 0;
        long firstStandingStrength = as[firstStanding];
        for (int i = 0; i < q; i++) {
            //System.out.printf("i: %d\n", i);
            //System.out.printf("%d %d\n", tempSum, ks[i]);
            if (tempSum <= ks[i]) {
                tempSum = sum;
                firstStanding = 0;
                firstStandingStrength = as[firstStanding];
                System.out.println(n);
            } else {
                long remainAttack = ks[i] - firstStandingStrength;
                if (remainAttack < 0) {
                    firstStandingStrength -= ks[i];
                    tempSum -= ks[i];
                    System.out.println(n - firstStanding);
                } else if (remainAttack == 0) {
                    firstStanding++;
                    firstStandingStrength = as[firstStanding];
                    tempSum -= ks[i];
                    System.out.println(n - firstStanding);
                } else {
                    firstStanding++;
                    //firstStandingStrength = as[firstStanding];
                    //System.out.println(Arrays.toString(sumStrengths));
                    //System.out.println(remainAttack + sumStrengths[firstStanding - 1]);
                    int index = lower_bound(sumStrengths,
                            remainAttack + sumStrengths[firstStanding - 1]);
                    //int index = binarySearch(sumStrengths,
                    //        remainAttack + sumStrengths[firstStanding - 1], firstStanding);
                    //int index = Arrays.binarySearch(sumStrengths, firstStanding, sumStrengths.length,
                    //        remainAttack + sumStrengths[firstStanding - 1]);
                    if (index < 0) {
                        index = ~index;
                    }
                    /*
                    if (index == n) {
                        firstStanding = 0;
                        firstStandingStrength = as[firstStanding];
                        tempSum = sum;
                        System.out.println(n);
                        continue;
                    }
                    */
                    //System.out.println(index);
                    //System.out.println(sumStrengths[index]);
                    //System.out.println(remainAttack + sumStrengths[firstStanding - 1]);
                    if (sumStrengths[index] == remainAttack + sumStrengths[firstStanding - 1]) {
                        //System.out.println("++");
                        index = (index + 1) % n;
                        firstStandingStrength = as[index];
                    } else {
                        firstStandingStrength = as[index] - (
                                sumStrengths[index] - remainAttack
                                        - sumStrengths[firstStanding - 1]);
                    }
                    firstStanding = index;
                    tempSum -= ks[i];
                    System.out.println(n - firstStanding);
                }
            }
        }
    }

    int lower_bound(long[] arr, long key) {
        int low = 0;
        int high = arr.length - 1;
        while (high - low > 0) {
            int mid = (low + high) / 2;
            if (key <= arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    int binarySearch(long[] sums, long key, int low) {
        int high = sums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (sums[mid] < key) {
                low = mid + 1;
            } else if (sums[mid] > key) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return low;
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
