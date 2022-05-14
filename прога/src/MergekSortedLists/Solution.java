package MergekSortedLists;

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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));


        for (ListNode head : lists) {
            if (head != null) pq.add(head);
        }


        ListNode p = new ListNode();
        ListNode dummy = p;

        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            p.next = minNode;

            if (minNode.next != null) {
                pq.add(minNode.next);
            }

            p = p.next;
        }

        return dummy.next;

    }
}