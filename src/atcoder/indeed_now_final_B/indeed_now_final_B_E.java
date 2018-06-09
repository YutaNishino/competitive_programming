package atcoder.indeed_now_final_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class indeed_now_final_B_E {
    int n;
    int[] hs;

    public static void main(String args[]) {
        new indeed_now_final_B_E().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        hs = new int[n];
        for (int i = 0; i < n ; i++) {
            hs[i] = sc.nextInt();
        }
        solve();
    }

    void solve() {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(hs[i]);
        }
        if (set.size() < n) {
            System.out.println(-1);
            return;
        }
        // coordinate compression
        Person[] persons = new Person[n];
        for (int i = 0; i < n; i++) {
            persons[i] = new Person(i, hs[i]);
        }
        Arrays.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.height - o2.height;
            }
        });
        for (int i = 0; i < n; i++) {
            persons[i].compHeight = i + 1;
        }
        Arrays.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.index - o2.index;
            }
        });
        System.out.println(getInversionCost(persons));
    }

    long getInversionCost(Person[] persons) {
        long ret = 0;
        FenwickTree ft = new FenwickTree(n);
        for (int i = 0; i < n; i++) {
            ret += (long)persons[i].height * (ft.rangeSum(n) - ft.rangeSum(persons[i].compHeight));
            ft.update(persons[i].compHeight, 1);
        }
        return ret;
    }

    class Person {
        int index;
        int height;
        int compHeight;

        public Person(int index, int height) {
            this.index = index;
            this.height = height;
            compHeight = -1;
        }
    }

    class FenwickTree {
        private final int[] tree;
        private final int N;

        FenwickTree(int N){
            this.tree = new int[N + 1];
            this.N = N;
        }

        private int lsb(int x){
            return x & (-x);
        }

        void update(int position, int key){
            while (position <= N){
                tree[position] += key;
                position += lsb(position);
            }
        }

        int rangeSum(int position){
            int sum = 0;

            while (position >= 1){
                sum += tree[position];
                position -= lsb(position);
            }

            return sum;
        }

        int rangeSum(int x, int y){
            return rangeSum(y) - rangeSum(x - 1);
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
