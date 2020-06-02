public class Sorting {

    public static void main(String[] args) {
        Sorting sorting = new Sorting();
        sorting.quickSort(new int[]{64, 34, 25, 12, 22, 11, 90});
    }

    public Sorting() {
    }

    /**
     * the swap field optimizes it not to loop through when array is sorted
     * o(n*n) though
     *
     * @param arr
     */
    public void bubbleSort(int[] arr) {
        int length = arr.length;
        boolean swapped = false;
        for (int i = 0; i < length - 1; i++) {
            //TODO : so j < length - i - 1 because the last item in the array is sorted so we are going last - 1 after the inner the loop
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        printArray(arr);
    }

    private void swap(int[] arr, int j, int i2) {
        int temp = arr[j];
        arr[j] = arr[i2];
        arr[i2] = temp;
    }

    public void selectionSort(int arr[]) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            int min = i;
            // TODO : lie, I wanted yellow. okay  so J = i + 1 because the ith index would be sorted after the inner loop is done.
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) min = j;
            }
            swap(arr, i, min);
        }
        printArray(arr);
    }


    public void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;

            while (j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
        printArray(arr);
    }

    public void mergeSort(int[] arr) {
        int n = arr.length;
        if (n < 2) return;
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];
        for (int i = 0; i < mid; i++) {
            l[i] = arr[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = arr[i];
        }
        mergeSort(l);
        mergeSort(r);
        merge(arr, l, r);
        printArray(arr);
    }

    private void merge(int[] arr, int[] l, int[] r) {
        int left = l.length;
        int right = r.length;

        int i = 0, j = 0, k = 0;

        while (i < left && j < right) {
            if (l[i] < r[j]) {
                arr[k++] = l[i++];
            } else {
                arr[k++] = r[j++];
            }
        }
        while (i < left) {
            arr[k++] = l[i++];
        }
        while (j < right) {
            arr[k++] = r[j++];
        }
    }


    void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }



    public void quickSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }


    public void sort(int[] arr, int start, int end) {
        if (start >= end) {
          return;
        }
        int pivot = arr[(start + end) / 2];
        int index = partition(arr, start, end, pivot);
        sort(arr, start, index - 1);
        sort(arr, index, end);
        printArray(arr);
    }

    private int partition(int[] arr, int start, int end, int pivot) {
        while (start <= end) {
            while (arr[start] < pivot) {
                start++;
            }
            while (arr[end] > pivot) {
                end--;
            }
            if (start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        return start;
    }


}
