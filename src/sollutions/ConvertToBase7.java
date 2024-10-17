package sollutions;

public class ConvertToBase7 {

    public String convertToBase7(int n) {
        boolean neg = n < 0;
        n = neg ? -n : n;
        int l = (int) Math.ceil(Math.log(n) / Math.log(7)) + 2;
        char[] c = new char[l];
        int k = 0;
        while (n > 0) {
            c [l - k++ - 1] = (char) (n % 7 + '0');
            n = (n - n % 7) / 7;
        }
        if (neg)
            c [l - k++ - 1] = '-';
        return String.valueOf(c, l - k, k);
    }
}
