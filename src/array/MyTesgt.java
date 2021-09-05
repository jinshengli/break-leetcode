package array;

public class MyTesgt {

    public static void main(String[] args) {
        int ans1 = 0;
        int ans2 = 0;
        int ans3 = 0;
        for (int i = 0; i < 100; ++i) {
            if (i <= 10) {
                ans1 += i;
                continue;
            }
            if (isOdd(i)) {
                ans2 += i;
            } else {
                ans3 += i;
            }
        }
        System.out.println(ans1);
        System.out.println(ans2);
        System.out.println(ans3);
    }

    private static int testSum1() {
        int ans = 0;
        for (int i = 1; i <= 10; ++i) {
           ans += i;
        }
        return ans;
    }

    public static boolean isOdd(int num) {
        return num/10%10%2 == 0 ? true:false;
    }
}
