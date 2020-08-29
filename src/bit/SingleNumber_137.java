package bit;

/**
 * create by ljs on 2020/7/29 12:05
 * description:  137. 只出现一次的数字 II
 *
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，
 * 其余每个元素均出现了三次。找出那个只出现了一次的元素。
 *
 *
 * //TODO 没有完成。
 */
public class SingleNumber_137  {

    public int singleNumber(int[] nums) {

        // 3 * 3 = 9 //

        return 0;
    }


    public static int getSum(int a, int b) {
        while(b != 0){
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {

        int sum = getSum(100, -1);
        System.out.println(sum);


        System.out.println(-1^100);
        System.out.println(-1&100);

    }



}
