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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        
        int rem = 0;
        
        int currVal = 0;
        
        ListNode head = new ListNode((curr1.val + curr2.val + rem) % 10);
        rem = (curr1.val + curr2.val)/10;
        ListNode headop = head;
        curr1 = curr1.next;
        curr2 = curr2.next;
        int a = 0;
        int b = 0;
        while(curr1!=null || curr2!=null){
            
            if(curr1 == null){
                 a = 0;
            }
            else{
                a = curr1.val;
            }
            if(curr2 == null){
                b = 0;
            }
            else{
                b = curr2.val;
            }
            ListNode newN = new ListNode((a + b + rem) % 10);
            
            rem = (a + b + rem)/10;
            
            if(curr1!=null)
            curr1 = curr1.next;
            if(curr2!=null)
            curr2 = curr2.next;
            
            headop.next = newN;
            headop = headop.next;
            
        }
        
        if(rem!=0){
            headop.next = new ListNode(rem);
        }
        
        return head;
        
    }
}