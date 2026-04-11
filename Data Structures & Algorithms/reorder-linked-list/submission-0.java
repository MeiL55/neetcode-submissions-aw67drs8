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
    public void reorderList(ListNode head) {
        //one from the start and one from the end - store in an array
        //while i < j
        //node[i++].next = node[j]
        //node[j--].next=node[i]
        //node[i]
        List<ListNode> nodes = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            nodes.add(cur);
            cur = cur.next;
        }
        int i = 0;
        int j = nodes.size()-1;
        while (i < j) {
            nodes.get(i++).next = nodes.get(j);
            nodes.get(j--).next = nodes.get(i);
            if (j <= i) {
                break;
            }
        }
        nodes.get(i).next = null;
    }
}
