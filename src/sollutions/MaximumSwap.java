package sollutions;

public class MaximumSwap {
    public int maximumSwap(int n) {
        if (n < 10)
            return n;
        char[] c = new char[9];
        int s = 9, mi, r = n;
        char m, t;
        while (n > 0) {
            c[--s] = (char) (n % 10 + '0');
            n = (n - n % 10) / 10;
        }
        for (int j = s; j < 9; j++) {
            m = c[j];
            mi = j;
            for (int k = j + 1; k < 9; k++) {
                if (c[k] >= m && c[k] > c[j]) {
                    m = c[k];
                    mi = k;
                }
            }
            if (mi > j) {
                t = c[mi];
                c[mi] = c[j];
                c[j] = t;
                int res = 0;
                for (int l = s; l < 9; l++) {
                    res = (res * 10 + (c[l] - '0'));
                }
                return res;
            }
        }
        return r;
    }
}
