class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return; 
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode secondList = reverseList(slow.next);
        slow.next = null; 

        ListNode firstList = head;
        while (secondList != null) {
            ListNode temp1 = firstList.next; 
            ListNode temp2 = secondList.next; 

            firstList.next = secondList; 
            secondList.next = temp1; 

            firstList = temp1;
            secondList = temp2;
        }
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next; 
            curr.next = prev; 
            prev = curr; 
            curr = next; 
        }
        return prev; 
    }
}