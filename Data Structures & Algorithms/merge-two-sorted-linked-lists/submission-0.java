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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode curr1 = list1;
        ListNode curr2 = list2;
        ListNode curr = new ListNode(0); //write
        ListNode head = curr;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else if (list1.val > list2.val) {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
            //System.out.println(curr.val);
            if (list1 == null) {
                curr.next = list2;
            }
            if (list2 == null) {
                curr.next = list1;
            }
        }
        return head.next;
    }
}