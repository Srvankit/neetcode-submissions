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

        //basecase
        if(head == null && head.next ==null){
            return;
        }

        //find the middle 
        ListNode slow= head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow= slow.next;
            fast = fast.next.next;
        }

        //sepratate second half
        ListNode second = slow.next;
        slow.next = null;

        //reverse the seond half

        ListNode prev = null;
        ListNode curr = second;
        while(curr !=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        second = prev;

        //merge both the halves
        ListNode first = head;
        
        while(second != null){
            ListNode firstNext = first.next;
        ListNode secondNext = second.next;

        first.next = second;
        second.next = firstNext;

        first = firstNext;
        second = secondNext;
        }
    }
}
