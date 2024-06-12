package util;

import models.ListNode;

@SuppressWarnings("unused")
public class Utils {
    public static ListNode generateListNode(int[] nums) {
        if (nums == null || nums.length < 1)
            return null;
        ListNode h = null, c = null;
        for (int num : nums) {
            if (h == null) {
                h = new ListNode(num);
            } else if (c == null) {
                c = new ListNode(num);
                h.next = c;
            } else {
                c.next = new ListNode(num);
                c = c.next;
            }
        }
        return h;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] rows : matrix) {
            System.out.println();
            for (int cell : rows)
                System.out.printf("%d\t", cell);
        }
    }

}
