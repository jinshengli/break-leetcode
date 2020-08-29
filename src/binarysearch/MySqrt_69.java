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
public class MySqrt_69 {

    public int mySqrt(int x) {

        if ( x == 0 || x == 1 )
            return x;

        int left = 0, right = x;

        while ( left <= right ) {

            int mid = left + (right-left)/2;
            if ( (long)mid*mid < x ) {
                left = mid + 1;
            } else if ( (long)mid*mid > x ) {
                right = mid - 1;
            } else if ( (long) mid*mid == x ) {
                return mid;
            }
        }

        return right;
    }



}
