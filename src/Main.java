import models.ListNode;
import sollutions.PalindromeLinkedList;
import util.Utils;

public class Main {
    public static void main(String[] args) {
        ListNode h = Utils.generateListNode(new int[]{1, 2, 3, 2, 1});
        System.out.println(new PalindromeLinkedList().isPalindrome(h));
    }
}