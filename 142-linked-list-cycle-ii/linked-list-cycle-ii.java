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

        //Part 1.) DETECTION
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                hasCycle = true;
                break;
            }
        }
        //Part 2.) If No Cycle exists
        if(!hasCycle){
            return null;
        } 

        //Part 3.) Entry Point Finderrr
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;

        //TC = O(n)---(Part 1) takes N steps to find a match, (Part 3) takes fewer than N steps.
        //SC = O(1)---Only slow & fast and a boolean(hasCycle) declared, tracking everything in-place without copying data structures.

    }
}