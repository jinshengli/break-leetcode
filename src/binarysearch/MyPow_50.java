package binarysearch;


/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn ）。
 */
public class MyPow_50 {


    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1.0 / quickMul(x, -n);
        } else {
            return quickMul(x, n);
        }
    }

    private double quickMul(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double ans = quickMul(x, n/2);
        return n % 2 == 0 ? ans * ans : ans * ans * x;
    }

    public static void main(String[] args) {
        MyPow_50 myPow_50 = new MyPow_50();

        double v = myPow_50.myPow(2, 4);
        System.out.println(v);

        double v1 = myPow_50.myPow(0, 100);
        System.out.println(v1);

        double v2 = myPow_50.myPow(1, 0);
        System.out.println(v2);
    }
}
