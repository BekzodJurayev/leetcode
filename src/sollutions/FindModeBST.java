package sollutions;

import models.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;

public class FindModeBST {
    public int[] findMode(TreeNode r) {
        HashMap<Integer, Integer> m = new HashMap<>();
        check(r, m);
        LinkedList<Integer> l = new LinkedList<> ();
        int y = 0, t;
        for (Integer k : m.keySet()) {
            t = m.get(k);
            if (t > y) {
                l.clear();
                y = t;
            }
            if (t >= y)
                l.add(k);
        }
        int[] ar = new int[l.size()];
        y = 0;
        for (Integer i : l)
            ar [y++] = i;
        return ar;
    }

    private void check(TreeNode r, HashMap<Integer, Integer> m) {
        if (r == null)
            return;
        Integer p = m.get(r.val);
        m.put(r.val, 1 + (p == null ? 0 : p));
        check(r.left, m);
        check(r.right, m);
    }
}
