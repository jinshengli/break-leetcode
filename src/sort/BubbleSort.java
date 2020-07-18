package sort;


import java.util.Arrays;

/**
 * create by ljs on 2020/7/18 14:12
 * description: 冒泡排序
 */
public class BubbleSort {

    /**
     *  消除逆序对
     * @param arr
     */
    public static void sort(int arr[]) {

        if ( arr.length == 1 || arr == null ) {
            return;
        }

        for ( int i = 0; i < arr.length; ++i ) {
            for ( int j = 0; j < arr.length-i-1; j++ ) {
                if ( arr[j] > arr[j+1] ) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {

        int arr[] = {12,31,1,2,4,32,54,2,2,2,245,5};

        // sort(arr);
        sort(arr);

        System.out.println(Arrays.toString(arr));

    }


}
