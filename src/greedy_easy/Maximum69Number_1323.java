package greedy_easy;

public class Maximum69Number_1323 {

    public static int maximum69Number (int num) {
        int tmp = num;
        int add = 0;
        int indexShi = 1;
        while (tmp != 0) {
            if (tmp % 10 == 6) {
                add = indexShi;
            }
            tmp = tmp / 10;
            indexShi = indexShi * 10;
        }
        return num + add*3;
    }


    public static int maximum69Number04 (int num) {
        int tmp = num;
        int firstIndexOf6 = -1;
        int index = 0;
        while (tmp != 0) {
            if (tmp % 10 == 6) {
                firstIndexOf6 = index;
            }
            tmp = tmp / 10;
            index++;
        }

        int add = firstIndexOf6 != -1 ? 3 : 0;
        for (int i = 0; i < firstIndexOf6; ++i) {
            add = add * 10;
        }
        return num + add;
    }


    // StringBuilder。感觉不符合题目要求
    public static int maximum69Number03 (int num) {
        String s = String.valueOf(num);
        return Integer.valueOf(s.replaceFirst("6", "9"));
    }

    public static int maximum69Number02 (int num) {
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(num));
        for (int i = 0; i < stringBuilder.length(); ++i) {
            if (stringBuilder.charAt(i) == '6') {
                stringBuilder.deleteCharAt(i);
                stringBuilder.insert(i, '9');
                break;
            }
        }
        return Integer.valueOf(stringBuilder.toString());
    }

    // 这个解法有点挫。模拟法
    public static int maximum69Number01 (int num) {
        int mx = 1;
        int tmp = num;
        while (tmp != 0) {
            tmp = tmp / 10;
            mx = mx * 10;
        }

        int ans = 0;
        boolean t = true;
        while (num != 0) {
            int first = num / mx;
            if (first == 6 && t) {
                first = 9;
                t = false;
            }
            ans = ans + first * mx;
            num = num % mx;
            mx = mx / 10;
        }
        return ans;
    }


    public static void main(String[] args) {
        int i = maximum69Number04(996);
        System.out.println(i);
    }


}
