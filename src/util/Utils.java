package util;

import models.ListNode;

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
}
