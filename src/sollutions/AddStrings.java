package sollutions;

@SuppressWarnings("unused")
public class AddStrings {
    public String addStrings(String num1, String num2) {
        int l1 = num1.length(), l2 = num2.length(), l = (Math.max(l1, l2)) + 1;
        char[] ch = new char[l];
        int dil = 0, c;
        char c1, c2;
        while (dil > 0 || l1 > 0 || l2 > 0) {
            if (l1 > 0)
                c1 = num1.charAt(--l1);
            else c1 = '0';
            if (l2 > 0)
                c2 = num2.charAt(--l2);
            else c2 = '0';
            c = dil + c1 + c2 - '0';
            dil = c > '9' ? 1 : 0;
            c -= dil == 1 ? 10 : 0;
            ch[--l] = (char) c;
        }
        return String.valueOf(ch, l, ch.length - l);
    }
}
