package string_for;

public class ModifyString1576 {

    public static String modifyString(String s) {

        if (s == null || s.isEmpty())
            return s;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            char head = i == 0 ? ' ' : chars[i-1];
            char tail = i == chars.length - 1 ? ' ' : chars[i+1];
            if (chars[i] == '?') {
                char tmp = 'a';
                while (head == tmp || tail == tmp)
                    tmp++;
                chars[i] = tmp;
            }
        }
        return new String(chars);
    }


    public static void main(String[] args) {

        String a = "acxdb?avd?v";

        String s = ModifyString1576.modifyString(a);
        System.out.println(s);


    }


}
