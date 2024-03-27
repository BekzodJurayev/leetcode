package sollutions;

import models.ListNode;

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        ListNode t = head, left, cur = null, right = head;
        int size = 0;
        do {
            size++;
            t = t.next;
            if (size % 2 == 1) {
                left = cur;
                cur = right;
                right = right.next;
                cur.next = left;
            }
        } while (t != null);

        if (size % 2 == 1)
            cur = cur.next;

        while (right != null && cur != null) {
            if (right.val != cur.val)
                return false;
            right = right.next;
            cur = cur.next;
        }
        return right == null && cur == null;
    }
}
