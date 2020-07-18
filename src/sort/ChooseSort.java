package sort;

import java.util.Arrays;

/**
 * create by ljs on 2020/7/17 21:24
 * description:  选择排序模板
 */
public class ChooseSort {



    public static void sort( int []arr ) {
        for ( int i = 0; i < arr.length; ++i ) {
            int index = i;
            for (int j = i; j < arr.length; ++j) {  // [i,arr.length) 中最小的
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            // 在 i 位置和 最小值的位置值对换
            int tmp = arr[i];
            arr[i] = arr[index];
            arr[index] = tmp;
        }
    }

    public static void main(String[] args) {

        int arr[] = {12,31,1,2,4,32,54,2,2,2,245,5};

        sort(arr);

        System.out.println(Arrays.toString(arr));

    }



}
