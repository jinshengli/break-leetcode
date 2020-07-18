package divide_conquer;

/**
 * create by ljs on 2020/7/8 11:59
 * description:
 *
 * TODO 计算 pow(x,n)
 *
 *
 *  采用分治算法：
 *
 *
 *  合并结果
 *
 *
 *
 */
public class PowX_50 {


    public double myPow(double x, int n) {

        long N = n;
        if ( N == 0 )
            return 1.0;
        return N < 0 ? 1.0 / fastPow(x,-N) : fastPow(x, N);
    }

    private double fastPow(double x, long n) {

        if ( n == 0 ) {
            return 1.0;
        }

        double result = fastPow(x, n/2); // 分治算法；这一层我只计算一半
        return n % 2 == 0 ? result*result: result*result*x;
    }

    public static void main(String[] args) {

        PowX_50 powX_50 = new PowX_50();

        double v = powX_50.myPow(34.00515, -3);
        System.out.println(v);

    }


}
