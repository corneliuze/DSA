public class Sorting {

    public static void main(String[] args) {
        Sorting sorting = new Sorting();
        sorting.insertionSort(new int[]{64, 34, 25, 12, 22, 11, 90});
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
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false) break;
        }
        printArray(arr);
    }

    public void selectionSort(int arr[]) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) min = j;
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
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


    void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }


    //TODO : WRITE CODE FOR MERGE SORT, REVISIT OLD SORTS, LEARN QUICK SORT

}
