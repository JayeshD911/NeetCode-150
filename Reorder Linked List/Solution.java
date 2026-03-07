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

        if (head == null || head.next == null ) return;

        // Find the middle of the list
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the list

        ListNode head2 = slow.next;
        slow.next = null;  // cut the linked list
        ListNode prev = null;

        while(head2 != null){
            ListNode temp = head2.next;
            head2.next = prev;
            prev = head2;
            head2 = temp;
        }
        // prev is now the head of the reversed part

        // Merge the two halves

        ListNode first = head;
        ListNode second = prev;

        while (second != null){
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }

    }
}