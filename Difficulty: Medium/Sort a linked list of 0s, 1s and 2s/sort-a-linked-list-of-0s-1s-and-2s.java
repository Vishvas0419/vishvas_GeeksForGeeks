//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}


// } Driver Code Ends

// User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution {
    // Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) {
        if(head == null || head.next == null) return head;
        Node middle = findMiddle(head);
        Node leftHead = head;
        Node rightHead = middle.next;
        middle.next = null;
        leftHead = segregate(leftHead);
        rightHead = segregate(rightHead);
        return mergeTwoLists(leftHead,rightHead);
    }
    public static Node findMiddle(Node head)
    {
        Node slow = head;
        Node fast = head.next;
        while(fast!=null && fast.next!=null) 
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static Node mergeTwoLists(Node list1,Node list2)
    {
        Node t1 = list1; //temp 1
        Node t2 = list2; //temp 2
        Node dNode = new Node(-1);  //dummy node
        Node temp = dNode;
        while(t1 != null && t2 != null)
        {
            if(t1.data < t2.data)
            {
                temp.next = t1;
                temp = t1;
                t1 = t1.next;
            }
            else{
                temp.next = t2;
                temp = t2;
                t2 = t2.next;
            }
        }
        // if t1 or t2 still have any nodes remaining
        if(t1!=null) temp.next = t1; //just pick it up
        else temp.next = t2;
        return dNode.next; //new Head 
        // add your code here
    }
}



//{ Driver Code Starts.

class GFG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); i++) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }
            head = new Solution().segregate(head);
            printList(head);
        }
    }
}
// } Driver Code Ends