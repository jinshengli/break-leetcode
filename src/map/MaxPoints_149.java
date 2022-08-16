package map;


import java.util.HashMap;

/**
 * 149. 直线上最多的点数
 * 给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
 *
 *
 * 1 <= points.length <= 300
 * points[i].length == 2
 * -10^4 <= xi, yi <= 10^4
 * points 中的所有点 互不相同
 *
 */
public class MaxPoints_149 {

    public int maxPoints(int[][] points) {
        int ans = 0;
        for (int i = 0; i < points.length; ++i) {
            HashMap<String, Integer> map = new HashMap<>();
            int max = 0;
            for (int j = i + 1; j < points.length; ++j) {
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                int k = gcd(x, y);
                String tan = (x/k) + "/" + (y/k);
                Integer orDefault = map.getOrDefault(tan, 0);
                max = Math.max(max, orDefault + 1);
                map.put(tan, orDefault + 1);
            }
            ans = Math.max(ans, max + 1);
        }
        return ans;
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a%b);
    }

    public static void main(String[] args) {
        String tan = (1/3) + "/" + (2/2);
        System.out.println(tan);
    }
}
