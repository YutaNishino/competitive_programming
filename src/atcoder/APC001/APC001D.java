package atcoder.APC001;

import java.util.*;

public class APC001D {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        if ( m == n - 1) {
            System.out.println(0);
            return;
        }
        if (n < 2 * (n - m - 1)) {
            System.out.println("Impossible");
            return;
        }
        int[] weights = new int[n];
        ArrayList<LinkedList<Integer>> forest = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
            forest.add(new LinkedList<>());
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            forest.get(x).add(y);
            forest.get(y).add(x);
        }
        // DFS to find connected components
        long ans = 0;
        int count = 0;
        boolean[] visited = new boolean[n];
        PriorityQueue<Integer> remainCosts = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]){
                List<Integer> costs = new ArrayList<>();
                Stack<Integer> stack = new Stack<>();
                stack.push(i);
                while (!stack.isEmpty()) {
                    int vertex = stack.pop();
                    visited[vertex] = true;
                    costs.add(weights[vertex]);
                    LinkedList<Integer> edges = forest.get(vertex);
                    for (int edge : edges) {
                        if (!visited[edge]) {
                            stack.push(edge);
                        }
                    }
                }
                Collections.sort(costs);
                ans += costs.get(0);
                count++;
                for (int j = 1; j < costs.size(); j++) {
                    remainCosts.add(costs.get(j));
                }
            }
        }
        for (int i = count; i < 2 * (n - m - 1); i++) {
            ans += remainCosts.poll();
        }
        System.out.println(ans);
    }
}
