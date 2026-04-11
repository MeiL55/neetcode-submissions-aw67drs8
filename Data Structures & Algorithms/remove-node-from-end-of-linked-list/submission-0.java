/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //one pass: we need a slow pointer, and a fast pointer that are just n steps away
        //how to do it: count n and the place where fast resides
        //and then slow and fast both moving till fast reaches the null
        //slow is the exact node we want to delete
        //but to delete that, we need access to the one node in front of that
        //so change confition to fast reaches end
        //slow.next = slow.next.next;
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;
        ListNode fast = head;
        while (fast != null) {
            if (n == 0) {
                break;
            }
            fast = fast.next;
            n--;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}