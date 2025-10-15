/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    public int lengthOfLoop(Node head) {
        if(head==null) return 0;
        Node slow = head; Node fast = head;
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast) return findLength(slow);
        }
         return 0;
    }
    static int findLength(Node slow)
    {
        int count = 1;
        Node temp = slow;
        while(temp.next!=slow)
        {
            count++;
            temp = temp.next;
        }
        return count;
    }
}