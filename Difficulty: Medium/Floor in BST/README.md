<h2><a href="https://www.geeksforgeeks.org/problems/implementing-floor-in-bst/1">Floor in BST</a></h2><h3>Difficulty Level : Difficulty: Medium</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Given a Binary search tree and a value X,&nbsp; the task is to complete the function which will return the floor of x.</span></p>

<p><span style="font-size:18px"><strong>Note: </strong>Floor(X) is an element that is either equal to X or immediately smaller to X. If no such element exits return -1. </span></p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:
</strong>       8
&nbsp;    /  \
&nbsp;   5    9
&nbsp;  / \    \
&nbsp; 2   6   10
X = 3
<strong>Output: </strong>2<strong>
Explanation: </strong>Floor of 3 in the given BST
is 2</span></pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:
</strong>       3
&nbsp;    /   \
&nbsp;   2     5
&nbsp;       /  \
&nbsp;      4    7
&nbsp;     /
&nbsp;    3
X = 1
<strong>Output: </strong>-1<strong>
Explanation: </strong>No smaller element exits</span></pre>

<p><span style="font-size:18px"><strong>Your task:</strong><br>
You don't need to worry about the insert function, just complete the function <strong>floor</strong>() which should return the floor of X.&nbsp;If no such element exits return -1.</span></p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:&nbsp;</strong>O(Height of the BST)<br>
<strong>Expected Auxiliary Space:&nbsp;</strong>O(Height of the BST).</span></p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1 &lt;= Number of nodes&nbsp;&lt;= 10<sup>5</sup><br>
1 &lt;= X, Value of Node &lt;= 10<sup>6</sup></span></p>
</div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Binary Search Tree</code>&nbsp;<code>Data Structures</code>&nbsp;