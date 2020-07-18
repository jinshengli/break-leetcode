package sort;

import java.util.Arrays;

/**
 * create by ljs on 2020/7/18 8:45
 * description: 插入排序模板
 */
public class InsertSort {


    /**
     *  在未排序的后半部分: 第一个未排序元素，插入到已排序的合适位置。
     *
     *  需要数组的移动。
     * @param arr
     */
    public static void sort(int arr[]) {

        if ( arr.length == 1 || arr == null ) {
            return;
        }
        for ( int i = 1; i < arr.length; ++i ) {
            for ( int j = i; j > 0 && arr[j-1] > arr[j]; j-- ) {
                int tmp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = tmp;
            }

        }

        System.out.println(Arrays.toString(arr));
    }

    public static void sortGood(int arr[]) {

        if ( arr.length == 1 || arr == null ) {
            return;
        }

        for ( int i = 1; i < arr.length; ++i ) {
            int tmp = arr[i];
            int j = i - 1;
            for ( ; j >= 0 && tmp < arr[j]; --j ) {
                arr[j+1] = arr[j];
            }
            // j + 1 的位置才是满足条件的
            arr[j+1] = tmp;
        }

    }


    public static void main(String[] args) {

        int arr[] = {12,31,1,2,4,32,54,2,2,2,245,5};

        // sort(arr);
        sortGood(arr);

        System.out.println(Arrays.toString(arr));

    }



}
