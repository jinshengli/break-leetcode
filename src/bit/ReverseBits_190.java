package bit;

/**
 * create by ljs on 2020/7/29 11:08
 * description:
 *
 *  颠倒给定的 32 位无符号整数的二进制位。
 */
public class ReverseBits_190 {



    public int reverseBits(int n) {

        int result = 0;
        for ( int i=0; i < 32; ++i ) {
            result = (result<<1) + (n&1); // 位运算要用括号包围，优先级好像低于 +
            n = n >> 1;
        }
        return result;
    }

    // 每次移动到目标位置。 i 移动到 31-i的位置。、
    public int reverseBits01(int n) {

        int result = 0;
        for ( int i=0; i < 32; ++i ) {
            result = result + ((n&1)<<(31-i)) ;
            n = n >> 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println( 0 << 1);
    }
}
