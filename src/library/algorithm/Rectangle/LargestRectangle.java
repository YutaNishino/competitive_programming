package library.algorithm.Rectangle;

import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangle {
    static int largestRectangle(int[][] board, int blocked) {
        int[][] field = new int[board.length][board[0].length];
        for (int i = 0; i < field[0].length; i++) {
            int count = 0;
            for (int j = 0; j < field.length; j++) {
                if (board[j][i] == blocked) {
                    field[j][i] = 0;
                    count = 0;
                } else {
                    field[j][i] = ++count;
                }
            }
        }
        int maximumArea = 0;
        for (int i = 0; i < board.length; i++) {
            Deque<RectPair> stack = new LinkedList<>();
            for (int j = 0; j <= board[0].length; j++) {
                RectPair rp =
                        new RectPair(j < board[0].length ? field[i][j] : 0, j);
                if (stack.isEmpty()) {
                    stack.push(rp);
                } else {
                    if (stack.peek().height < rp.height) {
                        stack.push(rp);
                    } else if (stack.peek().height > rp.height) {
                        int target = j;
                        while (!stack.isEmpty() &&
                                stack.peek().height >= rp.height) {
                            RectPair pre = stack.pop();
                            int area = pre.height * (j - pre.position);
                            maximumArea = Math.max(maximumArea, area);
                            target = pre.position;
                        }
                        rp.position = target;
                        stack.push(rp);
                    }
                }
            }
        }
        return maximumArea;
    }

    static class RectPair {
        int height;
        int position;

        RectPair(int height, int position) {
            this.height = height;
            this.position = position;
        }
    }
}
