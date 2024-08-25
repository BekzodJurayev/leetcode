package sollutions;

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int g = 0;
        while (x > 0 || y > 0) {
            if ((char) (x % 2 + '0') != (char) (y % 2 + '0'))
                g ++;
            x = (x - x % 2) / 2;
            y = (y - y % 2) / 2;
        }
        return g;
    }
}
