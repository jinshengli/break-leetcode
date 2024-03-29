package weeken.dw85;


/**
 *
 * 给你一个长度为 n 下标从 0 开始的字符串 blocks ，blocks[i] 要么是 'W' 要么是 'B' ，表示第 i 块的颜色。字符 'W' 和 'B' 分别表示白色和黑色。
 *
 * 给你一个整数 k ，表示想要 连续 黑色块的数目。
 *
 * 每一次操作中，你可以选择一个白色块将它 涂成 黑色块。
 *
 * 请你返回至少出现 一次 连续 k 个黑色块的 最少 操作次数。
 *
 * n == blocks.length
 * 1 <= n <= 100
 * blocks[i] 要么是 'W' ，要么是 'B' 。
 * 1 <= k <= n
 *
 *
 */
public class minimumRecolors_6156 {
    public int minimumRecolors(String blocks, int k) {
        int left = 0;
        int right = 0;
        char[] bc = blocks.toCharArray();
        int cntW = 0;
        while (right < k) {
            if (bc[right] == 'W') {
                cntW++;
            }
            right++;
        }
        int ans = cntW;
        while (right < bc.length) {
            if (bc[left] == 'W') {
                cntW--;
            }
            if (bc[right] == 'W') {
                cntW++;
            }
            ans = Math.min(ans, cntW);
            right++;
            left++;
        }
        return ans;
    }
}
