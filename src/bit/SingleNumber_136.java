package bit;

/**
 * create by ljs on 2020/7/29 12:01
 * description:  136. 只出现一次的数字
 *
 *  给定一个非空整数数组，
 *  除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 */
public class SingleNumber_136 {

    public int singleNumber(int[] nums) {

        if ( nums == null || nums.length == 0 )
            throw new IllegalArgumentException("非法参数");

        int result = nums[0];
        for ( int i = 1; i < nums.length; ++i )
            result = result ^ nums[i];

        return result;
    }

}
