package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * create by ljs on 2020/7/19 8:47
 * description:
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 *  输入: [
 *          [1,3],
 *          [2,6],
 *          [8,10],
 *          [15,18]
 *       ]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 *
 *
 */
public class Merge {


    /**
     *  排序 + 贪心算法
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {

        if ( intervals.length < 1 )
            return intervals;

        // 将二维数组按照 最左的位置去排序
        Arrays.sort(intervals, Comparator.comparingInt(o->o[0]));
        List<int []> result = new ArrayList<>();
        result.add(intervals[0]);

        for ( int i =1; i < intervals.length; ++i ) {

            int []curInterval = intervals[i];
            int []preInterval = result.get(result.size()-1);

            if ( curInterval[0] <= preInterval[1] ) {
                // 合并重叠的区间; 就是修改当前区间的 右边界
                preInterval[1] = Math.max(preInterval[1], curInterval[1]);

            } else {
                result.add(intervals[i]);
            }

        }

        return result.toArray(new int[result.size()][]);
    }

}
