package sollutions;

import models.TreeNode;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class KthLargestSum {
    public long kthLargestLevelSum(TreeNode root, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        process(root, map, 1);
        List<Integer> list =  map.values().stream()
                .distinct()
                .sorted()
                .toList();
        if (list.size() < k)
            return -1;
        return list.get(k - 1);
    }
    private void process(TreeNode root, HashMap<Integer, Integer> map, int level) {
        if (map.containsKey(level))
            map.put(root.val, map.get(level) + root.val);
        else map.put(level, root.val);

        if (root.right != null)
            process(root.right, map, level + 1);
        if (root.left != null)
            process(root.left, map, level + 1);
    }
}
