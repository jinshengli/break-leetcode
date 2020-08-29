package bit;

/**
 * create by ljs on 2020/7/30 19:42
 * description:
 *
 *      设计一个函数把两个数字相加。不得使用 + 或者其他算术运算符。
 *
 *      a^b a和b不算进位的相加
 *      a&b 求出a+b的进位位置。
 *
 */
public class Add_m1701 {


    public int add(int a, int b) {

        while ( b != 0 ) {

            int tmp = a ^ b;
            b = (a & b)<<1;
            a = tmp;
        }

        return a;

    }

    public static void main(String[] args) {

        char t = 75;
        Long e = 8888L;

        System.out.println(t);
        System.out.println(e);

    }
}


