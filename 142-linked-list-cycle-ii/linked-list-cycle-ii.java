/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;

        //1.) DETECTION
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                hasCycle = true;
                break;
            }
        }
        //If No Cycle exists
        if(!hasCycle){
            return null;
        } 

        //Entry Point Finderrr
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;

    }
}