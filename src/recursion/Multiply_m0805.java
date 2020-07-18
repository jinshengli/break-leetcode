package recursion;

/**
 * create by ljs on 2020/7/15 12:03
 * description:
 */
public class Multiply_m0805 {


    int ans = 0;
    public int multiply(int A, int B) {
        ans = 0;
        dfs(A,B);
        return ans;
    }

    private void dfs(int a, int b) {

        if ( b <= 0 ) {
            return;
        }

        ans += a;
        dfs(a,b-1);
    }

    public static void main(String[] args) {

        int multiply = new Multiply_m0805().multiply(91879592, 1);
        System.out.println(multiply);

    }


}
