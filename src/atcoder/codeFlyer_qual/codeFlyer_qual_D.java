package atcoder.codeFlyer_qual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class codeFlyer_qual_D {
    int h, w, n, m;
    boolean[][] hanko;

    public static void main(String args[]) {
        new codeFlyer_qual_D().run();
    }

    void run() {
        FastReader sc = new FastReader();
        h = sc.nextInt();
        w = sc.nextInt();
        n = sc.nextInt();
        m = sc.nextInt();
        hanko = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            char[] cs = sc.next().toCharArray();
            for (int j = 0; j < m; j++) {
                hanko[i][j] = cs[i] == '#';
            }
        }
        solve();
    }

    void solve() {
        long upAns = upDown(0, Math.min(h - n - 1, n - 2));
        long downAns = upDown(Math.max(h - n, n - 1), h - 1);

        long centAns = 0;
        if (h - 2 * n + 2 > 0) {
            PriorityQueue<Pair> pQueue = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (hanko[i][j]) {
                        pQueue.offer(new Pair(j, w - m + j));
                    }
                }
            }
            if (!pQueue.isEmpty()) {
                Pair tempP = pQueue.poll();
                while (!pQueue.isEmpty()) {
                    Pair p = pQueue.poll();
                    if (tempP.r < p.l) {
                        //fullMerged.add(tempP);
                        centAns += tempP.r - tempP.l + 1;
                        tempP = p;
                    } else if (tempP.r >= p.r) {
                        continue;
                    } else {
                        tempP = new Pair(tempP.l, p.r);
                    }
                }
                centAns += tempP.r - tempP.l + 1;
            }
            centAns *= h - 2 * n + 2;
        }
        System.out.println(upAns);
        System.out.println(centAns);
        System.out.println(downAns);
        System.out.println(upAns + centAns + downAns);
    }

    long upDown(int start, int end) {
        if (end < start) {
            return 0;
        }
        List<Pair> mergedList = new ArrayList<>();
        long ans = 0;
        for (int i = start; i <= end; i++) {
            System.out.println(i);
            List<Pair> list = new ArrayList<>();
            //long num = 0;
            for (int j = 0; j < m; j++) {
                if (hanko[i - start][j]) {
                    list.add(new Pair(j, w - m + j));
                }
            }
            for (int k = 0; k < list.size(); k++) {
                System.out.println(i + " " + list.get(k).l + " " + list.get(k).r);
            }
            List<Pair> tempMerge = new ArrayList<>();
            if (list.size() > 0) {
                int index = 1;
                Pair temp = list.get(0);
                while (index < list.size()) {
                    if (temp.r >= list.get(index).l) {
                        temp = new Pair(temp.l, list.get(index).r);
                    } else {
                        //num += temp.r - temp.l + 1;
                        tempMerge.add(temp);
                        temp = list.get(index);
                    }
                    index++;
                }
                tempMerge.add(temp);
            }
            List<Pair> newMerged = new ArrayList<>();
            PriorityQueue<Pair> pQueue = new PriorityQueue<>();
            Iterator<Pair> me = mergedList.iterator();
            Iterator<Pair> te = tempMerge.iterator();
            while (me.hasNext()) {
                pQueue.offer(me.next());
            }
            while (te.hasNext()) {
                pQueue.offer(te.next());
            }
            if (!pQueue.isEmpty()) {
                Pair tempP = pQueue.poll();
                while (!pQueue.isEmpty()) {
                    Pair p = pQueue.poll();
                    if (tempP.r < p.l) {
                        newMerged.add(tempP);
                        ans += tempP.r - tempP.l + 1;
                        tempP = p;
                    } else if (tempP.r >= p.r) {
                        continue;
                    } else {
                        tempP = new Pair(tempP.l, p.r);
                    }
                }
                newMerged.add(tempP);
                ans += tempP.r - tempP.l + 1;
                mergedList = newMerged;
            }
        }
        return ans;
    }

    class Pair implements Comparable<Pair> {
        int l;
        int r;

        public Pair(int l, int r) {
            this.l = l;
            this.r = r;
        }

        @Override
        public int compareTo(Pair o) {
            return this.l - o.l;
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
