package array;

/**
 * create by ljs on 2020/7/20 19:07
 * description:
 *
 *  给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 *
 */
public class TwoSum_167 {


    public static int[] twoSum(int[] numbers, int target) {

        if ( numbers == null || numbers.length < 2 ) {
            return null;
        }
        int left = 0, right = numbers.length-1;
        while ( left < right ) {

            System.out.println("left" + left + "right" + right);
            if ( numbers[left] + numbers[right] == target) {
                return new int[]{left+1, right+1};
            } else if ( numbers[left] + numbers[right] < target ) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1,-1};

    }

    public static void main(String[] args) {

        int arr[] = {2,7,11,15};

        int[] ints = twoSum(arr, 9);
        System.out.println(ints[0]);
        System.out.println(ints[1]);

    }

}
