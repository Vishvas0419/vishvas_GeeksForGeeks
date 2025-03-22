//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(new Solution().infixToPostfix(br.readLine().trim()));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String s) {
        int n = s.length();
        // int i = 0;
        Stack<Character>st = new Stack<>();
        String ans = new String("");
        for(int i=0;i<n;i++)
        {
            //if there is any number or alphabets just add to ans
            if((s.charAt(i)>='A' && s.charAt(i)<='Z') ||
                (s.charAt(i)>='a' && s.charAt(i)<='z') ||
                (s.charAt(i)>='0' && s.charAt(i)<='9'))
            {
                ans += s.charAt(i);   
            }
            //if it is a opening bracket '(' then just push it to the stack
            else if(s.charAt(i)=='(') st.push(s.charAt(i));
            // if it is a closing bracket ')' then keep adding operators to the ans untill you see a opening bracket '('
            else if(s.charAt(i)==')')
            {
                while(!st.isEmpty() && st.peek()!='(')
                {
                    ans += st.pop();
                }
                st.pop(); //pop out the opening bracket '(' in the end
            }
            //else its definitely is an operator
            else{
                //check for the priority and pop to the ans accordingly. Higher prio op will go to ans and lesser prio remains in the stack
                while(!st.isEmpty() && priority(s.charAt(i))<=priority(st.peek()))
                {
                    ans += st.pop();
                }
                //if the op have higher priority than the top element of the stack just push that into stack
                st.push(s.charAt(i));
                
            }
            // i++;  //after all, go to the next iteration 
        }
        //after all iterations add or pop out all remaining operators from stack to ans one by one
        while(!st.isEmpty())
        {
            ans += st.pop();
        }
        return ans; //at the end return ans which will be our postfix expression
    }
    public static int priority(char operator)
    {
        if(operator=='^') return 3;
        else if(operator=='*'||operator=='/') return 2;
        else if(operator=='+'||operator=='-') return 1;
        else return -1;
    }
}