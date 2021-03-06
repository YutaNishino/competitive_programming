package library.datastructure.SegmentTree;

public class RangeMaxQuery {
    private final int[] tree;
    private final int N;
    private final int paddedN;
    int MIN = -(1 << 30);

    RangeMaxQuery(int[] arr) {
        this.N = arr.length;
        int n = 2;
        while (n < arr.length) {
            n <<= 1;
        }
        paddedN = n;
        tree = new int[2 * n - 1];
        int j = 0;
        for (int i = n - 1; i < n - 1 + arr.length; i++, j++) {
            tree[i] = arr[j];
        }
        for (int i = n - 1 + arr.length; i < tree.length; i++) {
            tree[i] = MIN;
        }
        build(0, 0, paddedN, arr);
    }

    void build(int k, int l, int r, int[] arr) {
        if (r - l == 1) {
            tree[k] = arr[l];
        } else {
            int mid = (l + r) >> 1;
            int lChild = (k << 1) + 1;
            int rChild = (k << 1) + 2;
            build(lChild, l, mid, arr);
            build(rChild, mid, r, arr);
            tree[k] = Math.max(tree[lChild], tree[rChild]);
        }
    }

    // returns maximum value from [a, b).
    int query(int a, int b) {
        return query(a, b, 0, 0, paddedN);
    }

    int query(int a, int b, int k, int l, int r) {
        if (r <= a || b <= l) {
            return MIN;
        }
        if (a <= l && r <= b) {
            return tree[k];
        }
        int mid = (l + r) >> 1;
        int lMax = query(a, b, (k << 1) + 1, l, mid);
        int rMax = query(a, b, (k << 1) + 2, mid, r);
        return Math.max(lMax, rMax);
    }

    void add_point(int index, int val) {
        index += paddedN - 1;
        tree[index] += val;
        while (index > 0) {
            index = (index - 1) >> 1;
            tree[index] = Math.max(tree[(index << 1) + 1], tree[(index << 1) + 2]);
        }
    }

    void update_point(int index, int val) {
        index += paddedN - 1;
        tree[index] = val;
        while (index > 0) {
            index = (index - 1) >> 1;
            tree[index] = Math.max(tree[(index << 1) + 1], tree[(index << 1) + 2]);
        }
    }
}
