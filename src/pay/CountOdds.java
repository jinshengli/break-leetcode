package pay;

/**
 * create by ljs on 2020/7/25 22:32
 * description:
 *
 * 1 2 3 4 5 6 7 8 9 10 11
 *
 * if low is odd and high is odd
 *
 *
 */
public class CountOdds {


    public static int countOdds(int low, int high) {

        if ( low % 2 == 1 && high % 2 == 1 ) {
            return (high - low)/2 + 1;
        }

        return (high-low+1) / 2;

    }

    public static void main(String[] args) {
        int res = countOdds(1,100);
        System.out.println(res);

    }


}
