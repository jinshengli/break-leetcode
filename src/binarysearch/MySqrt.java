package binarysearch;

/**
 * create by ljs on 2020/7/21 8:29
 * description:
 *     69. x 的平方根
 *
 *     计算并返回 x 的平方根，其中 x 是非负整数。
 *
 *
 */
public class MySqrt {

    public int mySqrt(int x) {

        if ( x == 0 || x == 1 ) {
            return x;
        }

        int left = 0, right = x;

        while ( left-1 < right ) {

            int mid = (left+right)/2;
            if ( (long) mid*mid > x ) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        return left;

    }

    private int binary_search(int left, int right, int target) {

        while ( left <= right ) {
            int mid = (left+right)/2;
            if ( mid < target/mid ) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }


}
