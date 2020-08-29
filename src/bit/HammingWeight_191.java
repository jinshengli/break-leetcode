package bit;

/**
 * create by ljs on 2020/7/29 9:52
 * description:
 *
 *  191. 位1的个数
 *
 *  编写一个函数，输入是一个无符号整数，
 *  返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 *
 */
public class HammingWeight_191 {


    // you need to treat n as an unsigned value
    // 如果 while中写了 n != 0; n是负数，一定是死循环；因为java都是有符号的。
    // 这个不能是负数； 不能通过测试
    public int hammingWeight(int n) {

          int count = 0;
          while ( n > 0 ) { // 在这里判断了n一定不能小于0；
              if ( (n & 1) == 1 ) {
                  count++;
              }
              n = n >> 1; // 左移一位
          }
        return count;
    }


    // 和 原来的数字的 每一位比较，计算出1,。
    public int hammingWeight01(int n) {

        int count = 0;
        int mask = 1;
        while ( mask != 0 ) {
            if ( (n & mask) != 0 ) {  // 注意判断条件是 != 0
                count++;
            }
            mask = mask << 1;
        }
        return count;
    }

    // 规定32次的查看每一个二进制位，
    public int hammingWeight02(int n) {
        int count = 0, mask = 1;
        for ( int i = 0; i < 32; ++i ) {
            if ( (n & mask) != 0 )
                count++;
            mask = mask << 1;
        }
        return count;
    }


    /**
     *  最优的解法：
     *      每次清除 n 的最后一个1；成功清除一次1；count
     *      一次一。 知道n为0；
     * @param n
     * @return
     */
    public int hammingWeight03(int n) {

        int count = 0;
        while ( n != 0 ) {
            n = n & (n-1);
            count ++;
        }
        return count;
    }


    public static void main(String[] args) {

        HammingWeight_191 h = new HammingWeight_191();
        int i = h.hammingWeight01(-11);
        System.out.println(i);
        int i1 = h.hammingWeight03(-11);
        System.out.println(i1);

    }

}
