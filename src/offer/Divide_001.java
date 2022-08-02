package offer;


/**
 * 剑指 Offer II 001. 整数除法
 * 给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。
 *
 *
 *
 * 注意：
 *
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31, 2^31−1]。本题中，如果除法结果溢出，则返回 2^31 − 1
 *
 *
 * -2^31 <= a, b <= 2^31 - 1
 * b != 0
 */
public class Divide_001 {


    public int divide(int a, int b) {
        if (b == -1) {
            return a == Integer.MIN_VALUE ? Integer.MAX_VALUE : -a;
        }
        if (b == 1) {
            return a;
        }
        if (a == 0) {
            return 0;
        }
        int flag = (a > 0) ^ (b > 0) ? -1 : 1;
        if (a > 0) a = -a;
        if (b > 0) b = -b;
        int ans = 0;
        while (a <= b) {
            int cnt = 1;
            int base = b;
            while (a - base <= base) {
                cnt = cnt << 1;
                base = base << 1;
            }
            ans += cnt;
            a = a - base;
        }
        return ans * flag;
    }

    public int divide02(int a, int b) {
        int flag = (a > 0) ^ (b > 0) ? -1 : 1;
        long dividend = a;
        long divisor = b;
        dividend = dividend > 0 ? dividend : -dividend;
        divisor = divisor > 0 ? divisor : -divisor;

        long ans = div(dividend, divisor);
        return ans * flag > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) (ans * flag);
    }

    private long div(long dividend, long divisor) {
        if (dividend < divisor) {
            return 0;
        }
        long count = 1;
        long d = divisor;
        while ((d + d) < dividend) {
            count += count;
            d += d;
        }
        return count + div(dividend - d, divisor);
    }

    public int divide01(int a, int b) {
        // z = a/b
        if (a == Integer.MIN_VALUE) {
            if (b == -1) {
                return Integer.MAX_VALUE;
            }
            if (b == -1) {
                return Integer.MIN_VALUE;
            }
        }

        if (b == Integer.MIN_VALUE) {
            return a == Integer.MIN_VALUE ? 1 : 0;
        }

        if (a == 0) {
            return 0;
        }

        boolean rev = false;
        if (a > 0) {
            a = -a;
            rev = !rev;
        }

        if (b > 0) {
            b = -b;
            rev = !rev;
        }

        int left = 1, right = Integer.MAX_VALUE, ans = 0;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            boolean check = quickAdd(b, mid, a);
            if (check) {
                ans = mid;
                if (mid == Integer.MAX_VALUE) {
                    break;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return rev ? -ans : ans;
    }

    private boolean quickAdd(int y, int z, int x) {
        // x 和 y 是负数，z是正数
        // 需要判断 z*y >= x 是否成立
        int result = 0, add = y;
        while (z != 0) {
            if ((z & 1) != 0) {
                if (result < x - add) {
                    return false;
                }
                result += add;
            }

            if (z != 1) {
                if (add < x - add) {
                    return false;
                }
                add += add;
            }

            z >>= 1;
        }
        return true;
    }
}
