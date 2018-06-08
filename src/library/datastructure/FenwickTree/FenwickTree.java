package library.datastructure.FenwickTree;

// This type of femwick tree performs point update and range sum
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
