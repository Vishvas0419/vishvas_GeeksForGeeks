/* Linklist node structure
class Node
{
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/
class Solution {
    Node deleteNode(Node head, int x) {
        if(head==null) return head;
        if(x==1)
        {
            head = head.next;
            return head;
        }
        int count = 0;
        Node temp = head;
        Node prev = null;
        while(temp!=null)
        {
            count++;
            if(count==x)
            {
                prev.next = prev.next.next;
            }
            else{
                prev = temp;
                temp=temp.next;
            }
        }
        return head;
        
    }
}