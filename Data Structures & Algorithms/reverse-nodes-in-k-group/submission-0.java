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
    public ListNode reverseKGroup(ListNode head, int k) {
        int len =0;
        ListNode curr = head;
       while(curr != null){
        len++;
        curr = curr.next;
       } 
       ListNode dummy = new ListNode(0);
       dummy.next = head;

       ListNode prevgrp = dummy;
       ListNode grpstrt = head;

       while(len>=k){
        ListNode prev = null;
        ListNode curr2 = grpstrt;

        for(int i=0; i<k;i++){
            ListNode next = curr2.next;
            curr2.next = prev;
            prev = curr2;
            curr2=next;
        }
        grpstrt.next = curr2;
        prevgrp.next = prev;

        prevgrp = grpstrt;
        grpstrt = curr2;

        len-=k;
       }
       return dummy.next;
    }
}
