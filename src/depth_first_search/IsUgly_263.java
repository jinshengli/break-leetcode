package depth_first_search;

/**
 * create by ljs on 2020/8/12 21:28
 * description:
 *
 *  263. 丑数
 *
 *  编写一个程序判断给定的数是否为丑数。
 *
 *  丑数就是只包含质因数 2, 3, 5 的正整数。
 *
 */
public class IsUgly_263 {

    public boolean isUgly(int num) {

        if ( num <= 0 ) {  // 输入 小于等于 0 ；出现无限递归。
            return false;
        }

        if ( num == 1 ) {
            return true;
        }

        if ( num % 2 == 0 ) {
            return isUgly(num/2);
        }

        if ( num % 3 == 0 ) {
            return isUgly(num/3);
        }

        if ( num % 5 == 0 ) {
            return isUgly(num/5);
        }

        return false;
    }

    public static void main(String[] args) {

        IsUgly_263 isUgly_263 = new IsUgly_263();
        boolean ugly = isUgly_263.isUgly(0);
        System.out.println(ugly);
    }


}
