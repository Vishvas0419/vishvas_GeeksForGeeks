/*
class Node {
    int data;
    Node next;
    Node(int x) {
        data = x;
        next = null;
    }
}*/

class Solution {
    public ArrayList<Integer> printList(Node head) {
        ArrayList<Integer> list = new ArrayList<>();
        if(head==null) return new ArrayList<>();
        while(head!=null)
        {
            list.add(head.data);
            head = head.next;
        }
        return list;
    }
}