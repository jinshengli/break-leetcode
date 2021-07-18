package offer;

/**
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 *
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 *
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 */

public class SingleNumbers_56 {

    /**
     * 思路：
     *     1）将这个数组的元素全部异或处理；得到其中两个不同元素的异或结果
     *
     *     如何将其中不同的两个元素划到不同的分组中，
     *     然后将这两个分组的元素做个异或操作，就求出分组中的那个不同的元素。
     *
     * @param nums
     * @return
     */
    public static int[] singleNumbers(int[] nums) {

        int res = 0;
        for (int n : nums) {
            res = res ^ n;
        }
        int flag = 1;
        while ( (flag&res) == 0 ) {  // 为0代表改为两个数二进制在这位都相等。
            flag = flag << 1;
        }

        // flag 对应的二进制位低位是不同的【对于结果的两位】
        int a = 0;
        int b = 0;
        for (int n : nums) {
            if ( (flag & n) != 0 ) {  //
                a = a ^ n;
            } else {
                b = b ^ n;
            }
        }
        return new int[]{a,b};
    }

    public static void main(String[] args) {
        int num[] = {1,2,2,5};

        int[] ints = singleNumbers(num);
        System.out.println(ints[0]);
        System.out.println(ints[1]);

        System.out.println(0^0);
    }

}
