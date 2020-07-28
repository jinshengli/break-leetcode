package sort;

import java.util.Arrays;

/**
 * create by ljs on 2020/7/18 20:08
 * description:  归并排序
 */
public class MergeSort {


    public static void sort(int arr[]) {
        mergeSort(arr,0,arr.length-1);
    }


    private static void mergeSort(int[] arr, int left, int right) {
        if ( left < right ) {
            int mid = (left+right)/2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge01(arr, left, mid, right);
        }
    }


    private static void merge01(int[] arr, int left, int mid, int right) {
        // [left, mid]; [mid+1,right] 这两个区间都是有序的，现在将它们合成有序数组

        int []tmp = new int[right-left+1];
        int  len = 0;
        int i = left, j = mid+1;
        while ( i <= mid && j <= right ) {
            if ( arr[i] < arr[j] )
                tmp[len++] = arr[i++];
            else
                tmp[len++] = arr[j++];
        }

        while ( i <= mid ) {
            tmp[len++] = arr[i++];
        }

        while ( j <= right ) {
            tmp[len++] = arr[j++];
        }

        for ( int p = 0; p < len; ++p ) {
            arr[left+p] = tmp[p];
        }

    }




    private static void merge(int[] arr, int left, int mid, int right) {
        // [left, mid]; [mid+1,right] 这两个区间都是有序的，现在将它们合成有序数组

        int []tmp = new int[right-left+1];
        int  k = 0;
        int i = left, j = mid+1;
        while ( i <= mid && j <= right ) {
            while ( i <=mid && j <= right && arr[i] <= arr[j] )
                tmp[k++] = arr[i++];
            while ( i <=mid && j <= right && arr[j] <= arr[i] )
                tmp[k++] = arr[j++];
        }

        while ( i <= mid ) {
            tmp[k++] = arr[i++];
        }

        while ( j <= right ) {
            tmp[k++] = arr[j++];
        }

        for ( int p = 0; p < k; ++p ) {
            arr[left+p] = tmp[p];
        }

    }




    public static void main(String[] args) {

        int arr[] = {12,31,1,2,4,32,54,2,2,2,245,5};

        // sort(arr);
        sort(arr);

        System.out.println(Arrays.toString(arr));

    }



}
