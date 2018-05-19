package library.algorithm;

class BinarySearch {
    static int lower_bound(int[] arr, int key) {
        return lower_bound(arr, 0, arr.length - 1, key);
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

    static int upper_bound(int[] arr, int key) {
        return upper_bound(arr, 0, arr.length - 1, key);
    }

    static int upper_bound(int[] arr, int beginIndex, int endIndex, int key) {
        int low = beginIndex;
        int high = endIndex;
        while (high - low >= 0) {
            int mid = (low + high) / 2;
            if (key < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
