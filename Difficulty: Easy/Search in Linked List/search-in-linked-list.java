/*
  class Node {
   int data;
    Node next;

    Node(int d)  { data = d;  next = null; }
}
*/
class Solution {
    public boolean searchKey(Node head, int key) {
        if(head==null) return false;
        Node temp = head;
        while(temp!=null)
        {
            if(temp.data==key) return true;
            temp = temp.next;
        }
        return false;
    }
}