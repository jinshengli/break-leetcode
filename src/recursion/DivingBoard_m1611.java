package recursion;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * create by ljs on 2020/7/15 15:41
 * description:
 *
 *  面试题 16.11. 跳水板
 *
 *  木板； 有两种类型，长的和短的
 *
 *  请你选择k块木板，请求出它们的任意组合长度？
 *
 *
 *      k 层梦境。 每一层有两种选择。 最后它们的状态树是啥？
 *
 *
 */
public class DivingBoard_m1611 {


    private HashSet<Integer> set;

    public int[] divingBoard(int shorter, int longer, int k) {

        set = new HashSet<>();

        if ( k == 0 ) {
            return new int[0];
        }

        if ( shorter == longer ) {
            return new int[]{shorter*k};
        }

        dfs(shorter, longer, k, 0, 0);

        int []ans = new int[set.size()];
        int i=0;
        for (Integer integer : set) {
            ans[i++] = integer;
        }
        return ans;
    }

    private void dfs(int shorter, int longer, int k, int level, int s) {

        if ( level >= k ) { // 到达 k 层
            set.add(s);
            return;
        }
        // 当前层选择长；并且进入下一层
        dfs(shorter, longer, k, level+1, s + longer);
        // 选择短
        dfs(shorter, longer, k, level+1, s + shorter);
        // 回溯
    }

    public static void main(String[] args) {

        int[] ints = new int[0];
        System.out.println(ints);
    }

}
