package greedy_easy;


/**
 * 在柠檬水摊上，每一杯柠檬水的售价为5美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 *
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 *
 * 注意，一开始你手头没有任何零钱。
 *
 * 给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。如果你能给每位顾客正确找零，返回true，否则返回 false。
 */

public class LemonadeChange_860 {

    public boolean lemonadeChange(int[] bills) {
        int count[] = new int[21];
        for (int bill : bills) {
            int needChange = bill - 5;
            count[bill]++;
            while (needChange != 0) {
                if (needChange >= 20 && count[20] > 0) {
                    needChange = needChange - 20;
                    count[20]--;
                } else if (needChange >= 10 && count[10] > 0) {
                    needChange = needChange - 10;
                    count[10]--;
                } else if (needChange >= 5 && count[5] > 0) {
                    needChange = needChange - 5;
                    count[5]--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
