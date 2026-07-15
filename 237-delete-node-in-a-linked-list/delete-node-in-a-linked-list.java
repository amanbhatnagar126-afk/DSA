/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
                                
        node.next = node.next.next;
    }
}
//TC = O(1) performed exactly two constant-time oper., No loops/No traversals.
//SC = O(1) X allocated any new variables or use extra space.