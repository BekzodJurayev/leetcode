package sollutions;

public class LicenceKeyFormatting {
    public String licenseKeyFormatting(String s, int k) {
        int l = s.length(), i = 0, j = l - 1, m = 0;
        char[] c = new char[l * 2];
        byte b;
        boolean f = true;
        while (j >= 0) {
            b = (byte) s.charAt(j--);
            if (b != 45) {
                if (m == k && !f) {
                    c[2 * l - i++ - 1] = '-';
                    m = 0;
                }
                f = false;
                c[2 * l - i++ - 1] = (char) (b > 96 && b < 122 ? b - 32 : b);
                m ++;
            } 
        }
        return String.copyValueOf(c, 2 * l - i, i);
    }
}