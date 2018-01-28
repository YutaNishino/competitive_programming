package atcoder.ABC087;

import java.util.*;

public class ABC087D {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<LinkedList<Tuple>> list = new ArrayList<>();
        for(int i = 0; i <= n; i++) list.add(new LinkedList<>());
        int[] memo = new int[3];
        for (int i = 0; i < m; i++) {
            memo[0] = sc.nextInt();
            memo[1] = sc.nextInt();
            memo[2] = sc.nextInt();
            list.get(memo[0]).add(new Tuple(memo[1], memo[2]));
            list.get(memo[1]).add(new Tuple(memo[0], -memo[2]));
        }
        // DFS
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[n + 1];
        int[] distance = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                distance[i] = 0;
                visit[i] = true;
                queue.add(i);
                while (!queue.isEmpty()) {
                    int curr = queue.poll();
                    Iterator<Tuple> it = list.get(curr).iterator();
                    while(it.hasNext()) {
                        Tuple next = it.next();
                        if (!visit[next.x]) {
                            visit[next.x] = true;
                            distance[next.x] = distance[curr] - next.y;
                            queue.add(next.x);
                        } else {
                            if (distance[next.x] != distance[curr] - next.y) {
                                System.out.println("No");
                                return;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Yes");
    }

    static class Tuple {
        final int x;
        final int y;
        Tuple(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
