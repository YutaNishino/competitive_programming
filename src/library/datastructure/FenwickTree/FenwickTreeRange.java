package library.datastructure.FenwickTree;

// This type of fenwick tree performs range update and get element
class FenwickTreeRange {
    private final int[] tree;
    private final int N;

    FenwickTreeRange(int N){
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

    // call this method like updateRange(l, r + 1, 1);
    void updateRange(int start, int end, int key) {
        update(start, key);
        update(end, -key);
    }

    int getElment(int position){
        int sum = 0;
        while (position >= 1){
            sum += tree[position];
            position -= lsb(position);
        }

        return sum;
    }
}
