package atcoder.indeed_now_final_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class indeed_now_final_B_B {
    int n;
    Person[] persons;

    public static void main(String args[]) {
        new indeed_now_final_B_B().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        persons = new Person[n];
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            persons[i] = new Person(s, t, i);
        }
        solve();
    }

    void solve() {
        Arrays.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.s - o2.s;
            }
        });
        int[] ss = new int[n];
        for (int i = 0; i < n; i++) {
            ss[i] = persons[i].s;
        }
        for (int i = 0; i < n; i++) {
            int tIndex = lower_bound(ss, i, n - 1, persons[i].t);
            persons[i].num = tIndex - i - 1;
        }
        Arrays.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.index - o2.index;
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(persons[i].num);
        }
    }

    class Person {
        int s;
        int t;
        int index;
        int num;

        public Person(int s, int t, int index) {
            this.s = s;
            this.t = t;
            this.index = index;
            num = 0;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }
    }

    static int lower_bound(int[] arr, int beginIndex, int endIndex, int key) {
        int low = beginIndex;
        int high = endIndex;
        while (high - low >= 0) {
            int mid = (low + high) / 2;
            if (key <= arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
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
