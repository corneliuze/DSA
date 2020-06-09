package heaps;

import java.util.Arrays;

public class Heap {
    private int[] arr;
    int largest = 0;

//new int{3,2,1,5,6,4}
    public static void main(String[] args) {
        Heap h = new Heap(6);
        HeapProblem hh = new HeapProblem();

        h.findKthLargest(new int[] {2,1}, 2);
        System.out.println("ans : " + Arrays.toString(hh.topKFrequent(new int[]{4, 5, 5, 2, 1, 1, 1, 5, 2, 3, 3, 5, 2}, 3)));
    }

    public Heap(int size) {
        arr = new int[size];
    }

    /**
     * max_heapify
     */
    public void maxHeapify(int[] arr, int i, int size) {
        int left = 2 * i;
        int right = 2 * i + 1;
        largest = i;
        if (left <= size && arr[left] > arr[i]) largest = left;
        if (right <= size && arr[right] > arr[largest]) largest = right;
        if (largest != i) {
            swap(arr, i, largest);
            maxHeapify(arr, largest, i);
        }

    }

    /**
     * build_max_heap O(n) i.e log n in n/2 times.
     * from n/2 downTo 1 asper n/2 + 1 ... to n are leaves
     */
    public void buildMaxHeap(int[] arr, int size) {
        for (int i = size / 2; i >= 1; i--) {
            maxHeapify(arr, i, size);
        }
    }

    /**
     * heap_sort
     * O(n log * n)
     */
    public void heapSort(int[] arr, int size) {
        int heapSize = size;
        buildMaxHeap(arr, size);
        for (int i = size; i >= 2; i--) {
            swap(arr, i, 1);
            heapSize--;
            maxHeapify(arr, 1, heapSize);
        }

    }


    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
    public int findKthLargest(int[] nums, int k) {
        int  heapsize = nums.length - 1;
        buildHeap(nums, heapsize);
        while (k > 1) {
            int temp = nums[heapsize];
            nums[heapsize] = nums[0];
            nums[0] = temp;
            heapsize--;
            heapify(nums, 0, heapsize);
            k--;
        }
        return nums[0];


    }

    public void heapify(int[] arr, int i, int n) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if(left <= n && arr[left] > arr[i]) largest = left;
        if(right <= n && arr[right] > arr[largest]) largest = right;
        if(largest != i) {
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            heapify(arr, largest, n);
        }
    }

    public void buildHeap(int[] arr, int n) {
        for(int i = n/2; i >= 0; i--) {
            heapify(arr, i, n);
        }
    }
}
