package bit;

/**
 * create by ljs on 2020/7/29 10:44
 * description:
 *
 *  给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 */
public class IsPowerOfTwo_231 {


    /**
     *  判断二进制位有且只有一个1， 清除最右的1之后，肯定变成0，if x 是2的幂次方
     *
     *  n 判断不能是 n != 0; 特殊 OX80000000
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {

        return n > 0 && (n & (n-1)) == 0;

    }

    /**
     *  获取最右的1； x&-x ;  true <-> x & -x == x
     * @param n
     * @return
     */
    public boolean isPowerOfTwo01(int n) {

        return n > 0 && (n & -n) == n;

    }



    public static void main(String[] args) {
        IsPowerOfTwo_231 two231 = new IsPowerOfTwo_231();
        boolean b = two231.isPowerOfTwo(-4);
        System.out.println(b);

        boolean b1 = two231.isPowerOfTwo01(-2147483648);
        System.out.println(b1);

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
