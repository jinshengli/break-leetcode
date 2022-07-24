package weeken.dw83;


/**
 *
 * 下述是从好到坏你可能持有的 手牌类型 ：
 *
 * "Flush"：同花，五张相同花色的扑克牌。
 * "Three of a Kind"：三条，有 3 张大小相同的扑克牌。
 * "Pair"：对子，两张大小一样的扑克牌。
 * "High Card"：高牌，五张大小互不相同的扑克牌。
 * 请你返回一个字符串，表示给定的 5 张牌中，你能组成的 最好手牌类型 。
 *
 * 注意：返回的字符串 大小写 需与题目描述相同
 *
 * ranks.length == suits.length == 5
 * 1 <= ranks[i] <= 13
 * 'a' <= suits[i] <= 'd'
 * 任意两张扑克牌不会同时有相同的大小和花色。
 *
 *
 */
public class BestHand_6128 {

    public String bestHand(int[] ranks, char[] suits) {
        int[] ranksMap = new int[13];
        int[] suitsMap = new int[4];
        for (int i = 0; i < ranks.length; ++i) {
            ranksMap[ranks[i]]++;
        }
        for (int i = 0; i < suits.length; ++i) {
            suitsMap[suits[i]  - 'a']++;
        }

        for (int count : suitsMap) {
            if (count == 5) {
                return "Flush";
            }
        }

        for (int i = 0; i < ranksMap.length; ++i) {
            if (ranksMap[i] >= 3) {
                return "Three of a Kind";
            }
        }

        for (int i = 0; i < ranksMap.length; ++i) {
            if (ranksMap[i] >= 2) {
                return "Pair";
            }
        }
        return "High Card";
    }

}
