package graph;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 207. 课程表
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 *
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，
 * 表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 *
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 *
 * 判断是否是有向无环图
 *
 */
public class CanFinish_207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; ++i) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            adj.get(b).add(a);
            inDegree[a]++;
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < inDegree.length; ++i) {
            if (inDegree[i] == 0) {
                deque.addLast(i);
            }
        }

        int vis = 0;
        while (!deque.isEmpty()) {
            vis++;
            int cur = deque.pollFirst();
            // 遍历临接触点。
            List<Integer> list = adj.get(cur);
            for (Integer i : list) {
                inDegree[i]--;
                if (inDegree[i] == 0) {
                    deque.addLast(i);
                }
            }
        }

        return vis == numCourses;
    }
}
