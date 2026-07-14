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
    public ListNode mergeTwoLists(ListNode List1, ListNode List2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while(List1 != null && List2 != null){
            if(List1.val <= List2.val){
                current.next = List1;                 //TC = O(M+N), M&N are no. of nodes in List(1&2)
                List1 = List1.next;                   //Sc = O(1), Rearranging Existing .next
            }else{
                current.next = List2;
                List2 = List2.next;
            }
            current = current.next;
        }
        //If anyone List runs out earlier
        if(List1 != null){
            current.next = List1;
        }else{
            current.next = List2;
        }
        return dummy.next;
    }
}