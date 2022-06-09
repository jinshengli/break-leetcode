package dynamic_programming;

import java.util.ArrayList;
import java.util.List;


/**
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 */
public class Generate_118 {

    /**
     * 199
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        for (int i = 0; i <= rowIndex; ++i) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || i == j) {
                    cur.add(1);
                } else {
                    cur.add(pre.get(j-1) + pre.get(j));
                }
            }
            pre = cur;
        }
        return pre;
    }


    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < i + 1; ++j) {
                if (j == 0 || i == j) {
                    row.add(1);
                } else {
                    row.add(ans.get(i -1).get(j - 1) + ans.get(i-1).get(j));
                }
            }
            ans.add(row);
        }
        return ans;
    }

    /**
     * 非常朴素，冗余代码比较多。
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate01(int numRows) {
        int dp[][] = new int[numRows][numRows];
        dp[0][0] = 1;

        for (int i = 1; i < numRows; ++i) {
            for (int j = 0; j < i + 1; ++j) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i  = 0; i < numRows; ++i) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < i + 1; ++j) {
                tmp.add(dp[i][j]);
            }
            ans.add(tmp);
        }
        return ans;
    }

    public static void main(String[] args) {
        Generate_118 generate_118 = new Generate_118();
        List<List<Integer>> generate = generate_118.generate(3);
        for (List<Integer> integers : generate) {
            System.out.println(integers);
        }

        List<Integer> row = generate_118.getRow(2);
        System.out.println("row"  + row);
    }
}
