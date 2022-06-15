package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原 IP 地址
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。
 * 你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 *
 *
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 *
 * 1 <= s.length <= 20
 * s 仅由数字组成
 *
 */
public class RestoreIpAddresses_93 {

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backTrace(s,0, path, ans);
        return ans;
    }

    private void backTrace(String s, int start, List<String> path, List<String> ans) {
        if (path.size() == 4 && start == s.length()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size(); ++i) {
                sb.append(path.get(i));
                if (i != path.size() - 1) {
                    sb.append(".");
                }
            }
            ans.add(sb.toString());
            return;
        }
        if (path.size() > 4 || start >= s.length()) {
            return;
        }

        int addrIp = 0;
        for (int endIndex = start; endIndex < s.length(); ++endIndex) {
            addrIp = addrIp * 10 + (s.charAt(endIndex) - '0');
            if (addrIp > 255) {
                return;
            }
            path.add(addrIp + "");
            backTrace(s, endIndex + 1, path, ans);
            path.remove(path.size() - 1);
            if (addrIp == 0) {
                return;
            }
        }

    }

    public static void main(String[] args) {
        RestoreIpAddresses_93 restoreIpAddresses_93 = new RestoreIpAddresses_93();
        List<String> strings = restoreIpAddresses_93.restoreIpAddresses("25525511135");
        for (String string : strings) {
            System.out.println(string);
        }
    }

}
