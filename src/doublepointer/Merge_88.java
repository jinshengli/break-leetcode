package doublepointer;

/**
 * create by ljs on 2020/7/28 16:00
 * description:
 *
 *      88. 合并两个有序数组
 *
 *      给你两个有序整数数组 nums1 和 nums2，
 *      请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 *
 *
 *      使用先后指针；
 *
 *      从后往前遍历’
 *
 *
 */
public class Merge_88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if ( nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 ) {
            return;
        }

        int i = m-1, j = n - 1, index = m+n-1;
        while ( i >=0 && j >= 0 && index >=0 ) {
            if ( nums1[i] >= nums2[j] ) {
                nums1[index--] = nums1[i--];
            } else {
                nums1[index--] = nums2[j--];
            }
        }

        if ( i < 0 ) {
            while (j >= 0 && index >= 0 )
                nums1[index--] = nums2[j--];
        }

        if ( j < 0 ) {
            while (i >= 0 && index >= 0 )
                nums1[index--] = nums1[i--];
        }
    }

    // 代码优化版；
    public void merge01(int[] nums1, int m, int[] nums2, int n) {

        if ( nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 ) {
            return;
        }

        int i = m-1, j = n - 1, index = m+n-1;

        while ( i >=0 && j >= 0 ) {
            nums1[index--] = nums1[i] >= nums2[j] ? nums1[i--]:nums2[j--];
        }

        if ( i < 0 ) {
            while (j >= 0 && index >= 0 )
                nums1[index--] = nums2[j--];
        }

    }

}
