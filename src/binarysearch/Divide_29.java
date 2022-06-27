package binarysearch;


/**
 * 29. 两数相除
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31, 2^31− 1]。本题中，如果除法结果溢出，则返回 2^31− 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Divide_29 {
    public int divide(int dividend, int divisor) {
        int flag = 1;
        long x = dividend;
        long y = divisor;
        if (x < 0) {
            x = -x;
            flag = -flag;
        }
        if (y < 0) {
            y = -y;
            flag = -flag;
        }

        // x/y = z   z*y = x
        long l = 0, r = x;
        while (l < r) {
            long mid = l + (r - l + 1) / 2;
            if (mul(mid, y) > x) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        if (l*flag > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return (int) l * flag;
    }

    // x * y quick mul
    private long mul(long x, long y) {
        long ans = 0;
        while (y != 0) {
            if ((y & 1) == 1) ans = ans + x;
            x = x + x;
            y = y >> 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Divide_29 divide_29 = new Divide_29();
        int divide = divide_29.divide(10, 3);

        System.out.println(divide);
    }
}
