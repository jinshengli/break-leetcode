package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class FindOrder_210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        int[] inDegree = new int[numCourses];
        List<Integer>[] adj = new List[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            adj[i] = new ArrayList();
        }

        for (int i = 0; i < prerequisites.length; ++i) {
            // b -> a
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            inDegree[a]++;
            adj[b].add(a);
        }

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < inDegree.length; ++i) {
            if (inDegree[i] == 0) {
                deque.addLast(i);
            }
        }

        int vis = 0;
        while (!deque.isEmpty()) {
            int cur = deque.pollFirst();
            ans[vis++] = cur;
            for (int i : adj[cur]) {
                inDegree[i]--;
                if (inDegree[i] == 0) {
                    deque.addLast(i);
                }
            }
        }
        return vis == numCourses ? ans : new int[numCourses];
    }
}
