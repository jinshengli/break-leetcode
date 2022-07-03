package weeken.week300;

import linklist.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 6111. 螺旋矩阵 IV 显示英文描述
 * 给你两个整数：m 和 n ，表示矩阵的维数。
 *
 * 另给你一个整数链表的头节点 head 。
 *
 * 请你生成一个大小为 m x n 的螺旋矩阵，矩阵包含链表中的所有整数。链表中的整数从矩阵 左上角 开始、顺时针 按 螺旋 顺序填充。如果还存在剩余的空格，则用 -1 填充。
 *
 * 返回生成的矩阵。
 *
 * 1 <= m, n <= 10^5
 * 1 <= m * n <= 10^5
 * 链表中节点数目在范围 [1, m * n] 内
 * 0 <= Node.val <= 1000
 *
 *
 */

//[3,0,2,
// 6,8,1,
// 7,9,4,
// 2,5,5,
// 0]
public class SpiralMatrix_6111 {

    public int[][] spiralMatrix01(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; ++i) {
            Arrays.fill(matrix[i], -1);
        }

        // 1, n
//        int l = 0, r = m - 1;
//        int t = 0, b = n - 1;

        int left = 0, right = n - 1;  // 傻叉了
        int top = 0, bottom = m - 1;

        ListNode cur = head;
        while (cur != null) {
            // to right
            for (int i = left; i <= right && cur != null; ++i) {
                matrix[top][i] = cur.val;
                cur = cur.next;
            }
            top++;

            // 向下
            for (int i = top; i <= bottom && cur != null; ++i) {
                matrix[i][right] = cur.val;
                cur = cur.next;
            }
            right--;

            // 向左
            for (int i = right; i >= left && cur != null; --i) {
                matrix[bottom][i] = cur.val;
                cur = cur.next;
            }
            bottom--;

            // to up
            for (int i = bottom; i >= top && cur != null; --i) {  // 傻叉
                matrix[i][left] = cur.val;
                cur = cur.next;
            }
            left++;
        }

        return matrix;
    }

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int d = 0;
        ListNode cur = head;
        int x = 0, y = 0;
        boolean vis[][] = new boolean[m][n];
        for (int i = 0; i < m*n; ++i) {
            int value;
            if (cur != null) {
                value = cur.val;
                cur = cur.next;
            } else {
                value = -1;
            }
            matrix[x][y] = value;
            vis[x][y] = true;
            int nx = x + dir[d][0];
            int ny = y + dir[d][1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n || vis[nx][ny]) {
                d = (d + 1) % 4;
                nx = x + dir[d][0];
                ny = y + dir[d][1];
            }
            x = nx;
            y = ny;
        }
        return matrix;
    }

    public static void main(String[] args) {
        SpiralMatrix_6111 sovle = new SpiralMatrix_6111();

        int nums[] = new int[] {3,0,2,6,8,1,7,9,4,2,5,5,0};
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (int num : nums) {
            cur.next = new ListNode(num);
            cur = cur.next;
        }

        int[][] ints = sovle.spiralMatrix(3, 5, dummy.next);

        System.out.println(ints);
    }


}
