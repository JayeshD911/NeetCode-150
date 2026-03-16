# 110. Balanced Binary Tree

🔗 Problem: https://leetcode.com/problems/balanced-binary-tree/

---

# Problem

Given the **root of a binary tree**, determine if the tree is **height-balanced**. :contentReference[oaicite:0]{index=0}

A **height-balanced binary tree** is defined as a tree where **for every node**, the difference between the heights of its **left and right subtrees is at most 1**. :contentReference[oaicite:1]{index=1}

Return:

```
true  → if the tree is balanced
false → otherwise
```

---

# Example

### Example 1

Input

```
root = [3,9,20,null,null,15,7]
```

Tree

```
        3
       / \
      9  20
         / \
        15  7
```

Output

```
true
```

Explanation

For every node:

```
|height(left) - height(right)| ≤ 1
```

---

### Example 2

Input

```
root = [1,2,2,3,3,null,null,4,4]
```

Tree

```
        1
       / \
      2   2
     / \
    3   3
   / \
  4   4
```

Output

```
false
```

Explanation

At node `2`:

```
left subtree height = 2
right subtree height = 0
difference = 2 > 1
```

So the tree is **not balanced**.

---

# Key Idea

A tree is balanced if **every node satisfies**:

```
|height(left) - height(right)| ≤ 1
```

To verify this efficiently, we compute the **height of each subtree** while checking if the subtree itself is balanced.

Instead of calculating heights multiple times (which leads to **O(n²)**), we compute height **bottom-up in one traversal**, achieving **O(n)** time. :contentReference[oaicite:2]{index=2}

---

# Intuition

Consider this tree:

```
        1
       / \
      2   3
     /
    4
```

Heights:

```
height(4) = 1
height(2) = 2
height(3) = 1
```

Check at node `1`:

```
|2 - 1| = 1  → balanced
```

But if the left subtree were deeper:

```
|3 - 1| = 2  → not balanced
```

---

# Optimal Strategy (Bottom-Up DFS)

Instead of checking height separately for every node:

```
1. Recursively compute left subtree height
2. Recursively compute right subtree height
3. If |leftHeight - rightHeight| > 1 → return -1
4. Otherwise return height = 1 + max(leftHeight, rightHeight)
```

We use `-1` as a signal that the subtree is **not balanced**.

---

# Java Solution (Optimal O(n))

```java
class Solution {

    public int dfs(TreeNode root){

        if(root == null)
            return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        if(left == -1 || right == -1)
            return -1;

        if(Math.abs(left - right) > 1)
            return -1;

        return 1 + Math.max(left, right);
    }

    public boolean isBalanced(TreeNode root) {

        return dfs(root) != -1;
    }
}
```

---

# Dry Run

Input

```
        1
       / \
      2   2
     / 
    3
   /
  4
```

Step-by-step:

```
Node 4 → height = 1
Node 3 → height = 2
Node 2 → height = 3
Node 2(right) → height = 1
```

Check at root:

```
|3 - 1| = 2 → not balanced
```

Return

```
false
```

---

# Complexity Analysis

### Time Complexity

```
O(n)
```

Every node is visited exactly once during DFS. :contentReference[oaicite:3]{index=3}

---

### Space Complexity

```
O(h)
```

Where

```
h = height of tree
```

Worst case (skewed tree):

```
O(n)
```

Balanced tree:

```
O(log n)
```

---

# Brute Force Approach (Not Optimal)

Naive approach:

```
for every node:
    compute height(left)
    compute height(right)
```

This recalculates heights repeatedly.

Time complexity:

```
O(n²)
```

---

# Pattern Recognition

This problem belongs to:

```
Binary Tree
DFS
Post-order Traversal
Tree Height Problems
```

Very similar problems:

```
Maximum Depth of Binary Tree
Diameter of Binary Tree
Minimum Depth of Binary Tree
Binary Tree Maximum Path Sum
```

---

# Summary

Core rule:

```
|height(left) - height(right)| ≤ 1
```

Optimal idea:

```
Compute height and balance in one DFS traversal
```

---

# Takeaway

Whenever a problem asks:

```
check if tree is balanced
compare subtree heights
```

Think immediately:

```
Post-order DFS + height calculation
```


https://neetcode.io/problems/balanced-binary-tree/question?list=neetcode150

https://leetcode.com/problems/balanced-binary-tree/