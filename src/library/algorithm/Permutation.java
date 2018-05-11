package library.algorithm;

class Permutation {
    int[] indexes;
    int[] arr;

    Permutation(int[] arr) {
        this.arr = arr;
        indexes = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            indexes[i] = i;
        }
    }

    boolean next() {
        int n = indexes.length;

        int i = n - 1;
        while (i > 0 && indexes[i - 1] >= indexes[i]) {
            i--;
        }
        if (i <= 0) {
            return false;
        }

        int j = n - 1;
        while (indexes[j] <= indexes[i - 1]) {
            j--;
        }
        swap(indexes, i - 1, j);
        swap(arr, i - 1, j);

        int k = n - 1;
        while (i < k) {
            swap(indexes, i, k);
            swap(arr, i++, k--);
        }

        return true;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}