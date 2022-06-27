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

    // long 防止溢出
    public int mySqrt04(int x) {
        long left = 0, right = x;
        while(left < right) {
            long mid = left + (right - left + 1) / 2;
            if (mid*mid > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int)left;
    }

    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        int left = 0, right = x/2;
        while(left < right) {
            int mid = left + (right - left + 1) / 2;  // 这个会溢出啊。
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public static int mySqrt03(int x) throws InterruptedException {
        int left = 0, right = x;
        while(left < right) {
            int mid = left + (right - left + 1) / 2;  // 这个会溢出啊。
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid;
            }
            System.out.println("left: " + left + " mid: " + mid + " right: " + right);
            Thread.sleep(1000L);
        }
        return left;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Integer.MAX_VALUE);
        int i = mySqrt(2147483647);
        System.out.println(i);
    }

    public int mySqrt02(int x) {

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


    public int mySqrt01(int x) {
        if ( x <= 1) {
            return x;
        }

        int left = 1, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int tmp = x / mid;
            if (tmp == mid) {
                return mid;
            } else if (tmp < mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }


}
