package sort;

import java.util.Arrays;

/**
 * create by ljs on 2020/7/18 19:22
 * description:
 */
public class QuickSort {


    public static void sort(int arr[]) {

        quickSort(arr, 0, arr.length-1);
    }

    public static void quickSort(int arr[], int left, int right) {

        if ( left >= right ) {
            return;
        }
        int pivot = partition(arr, left, right);
        quickSort(arr, left, pivot-1);
        quickSort(arr, pivot+1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = left;
        int index = left + 1;
        for ( int i = index; i <= right; ++i ) {
            if ( arr[i] <= arr[pivot] ) {  // index 以前的后应该小于arr[pivot]
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index-1);
        return index-1;
    }

    private static void swap(int[] arr, int i, int index) {
        int tmp = arr[i];
        arr[i] = arr[index];
        arr[index] = tmp;
    }

    public static void main(String[] args) {

        int arr[] = {12,31,1,2,4,32,54,2,2,2,245,5};

        // sort(arr);
        sort(arr);

        System.out.println(Arrays.toString(arr));

    }


}
