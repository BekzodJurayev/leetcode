package sollutions;

public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        boolean matches;
        for (int i = 1; i <= s.length() / 2; i ++) {
            matches = true;
            for (int j = i; j <= s.length() - i && matches; j += i)
                for (int k = j; k < j + i && matches; k ++)
                    matches = s.charAt(k) == s.charAt(k - j);
            if (matches && s.length() % i == 0)
                return true;
        }
        return false;
    }
}
