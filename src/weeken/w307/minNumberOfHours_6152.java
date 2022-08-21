package weeken.w307;


/**
 * 6152. 赢得比赛需要的最少训练时长 显示英文描述
 * 你正在参加一场比赛，给你两个 正 整数 initialEnergy 和 initialExperience 分别表示你的初始精力和初始经验。
 *
 * 另给你两个下标从 0 开始的整数数组 energy 和 experience，长度均为 n 。
 *
 * 你将会 依次 对上 n 个对手。第 i 个对手的精力和经验分别用 energy[i] 和 experience[i] 表示。当你对上对手时，需要在经验和精力上都 严格 超过对手才能击败他们，
 * 然后在可能的情况下继续对上下一个对手。
 *
 * 击败第 i 个对手会使你的经验 增加 experience[i]，但会将你的精力 减少  energy[i] 。
 *
 * 在开始比赛前，你可以训练几个小时。每训练一个小时，你可以选择将增加经验增加 1 或者 将精力增加 1 。
 *
 * 返回击败全部 n 个对手需要训练的 最少 小时数目。
 *
 *
 * n == energy.length == experience.length
 * 1 <= n <= 100
 * 1 <= initialEnergy, initialExperience, energy[i], experience[i] <= 100
 */
public class minNumberOfHours_6152 {

    // 5
    // 3
    //[1,4]
    //[2,5]
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int ans = 0;
        int curEnergy = initialEnergy;
        int curEx = initialExperience;
        for (int i = 0; i < energy.length; ++i) {
            if (curEnergy <= energy[i]) {
                ans += energy[i] - curEnergy + 1;
                curEnergy = 1;
            } else {
                curEnergy = curEnergy - energy[i];
            }

            if (curEx <= experience[i]) {
                ans += experience[i] - curEx + 1;
                curEx = 2*experience[i] + 1;  // 需要考虑打败后，获取到的经验加上。
            } else {
                curEx = curEx + experience[i];
            }
        }
        return ans;
    } // 5 + 1

    // 优化。 注意思考的方式
    public int minNumberOfHours01(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int ans = 0;
        int x = initialEnergy;
        int y = initialExperience;
        for (int i = 0; i < energy.length; ++i) {
            if (x <= energy[i]) {
                int t = energy[i] - x + 1;
                ans += t;
                x += t;
            }
            if (y <= experience[i]) {
                int t = experience[i] - y + 1;
                ans += t;
                y += t;
            }
            x -= energy[i];
            y += experience[i];
        }
        return ans;
    } // 5 + 1

    public static void main(String[] args) {
        minNumberOfHours_6152 test = new minNumberOfHours_6152();
        int i = test.minNumberOfHours(1, 1, new int[]{1, 1, 1, 1}, new int[]{1, 1, 1, 50});

        System.out.println(i);
    }
}
