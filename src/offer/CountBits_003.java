package offer;

public class CountBits_003 {

    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for (int i = 0; i <= n; ++i) {
            ans[i] = countBit(i);
        }
        return ans;
    }

    private int countBit(int x) {
        int cnt = 0;
        while (x != 0) {
            x = x & (x - 1);
            cnt++;
        }
        return cnt;
    }

    private int countBit01(int x) {
        int cnt = 0;
        while (x != 0) {
            if ((x & 1) == 1) {
                cnt++;
            }
            x = x >> 1;
        }
        return cnt;
    }

}
