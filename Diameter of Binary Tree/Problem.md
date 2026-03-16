# 543. Diameter of Binary Tree

🔗 Problem: https://leetcode.com/problems/diameter-of-binary-tree/

---

# Problem

Given the **root of a binary tree**, return the **diameter of the tree**.

The **diameter** of a binary tree is the **length of the longest path between any two nodes** in the tree. This path **may or may not pass through the root**, and the length is measured by the **number of edges** between the nodes. :contentReference[oaicite:0]{index=0}

---

# Example

### Example 1

Input

```
root = [1,2,3,4,5]
```

Tree

```
        1
       / \
      2   3
     / \
    4   5
```

Output

```
3
```

Explanation

Longest path:

```
4 → 2 → 1 → 3
```

Edges = **3**

---

### Example 2

Input

```
root = [1,2]
```

Output

```
1
```

---

# Key Idea

The **longest path through a node** is:

```
height(left subtree) + height(right subtree)
```

Why?

Because the longest path that goes **through that node** must go:

```
deepest node in left subtree
        ↓
      current node
        ↓
deepest node in right subtree
```

So the candidate diameter at every node is:

```
leftHeight + rightHeight
```

The final answer is the **maximum of these values across all nodes**. :contentReference[oaicite:1]{index=1}

---

# Intuition

Consider the tree:

```
        1
       / \
      2   3
     / \
    4   5
```

Heights:

```
height(4) = 1
height(5) = 1
height(2) = 2
height(3) = 1
```

Diameter passing through node `1`:

```
left height (2) + right height (1) = 3
```

Which corresponds to:

```
4 → 2 → 1 → 3
```

---

# Optimal Strategy

We compute **height and diameter simultaneously** using DFS.

Steps:

```
1. Recursively compute height of left subtree
2. Recursively compute height of right subtree
3. Update diameter = max(diameter, leftHeight + rightHeight)
4. Return height = 1 + max(leftHeight, rightHeight)
```

This avoids recalculating heights multiple times.

---

# Java Solution (DFS)

```java
class Solution {

    int diameter = 0;

    public int dfs(TreeNode root){

        if(root == null)
            return 0;

        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);

        diameter = Math.max(diameter, leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public int diameterOfBinaryTree(TreeNode root) {

        dfs(root);

        return diameter;
    }
}
```

---

# Dry Run

Tree

```
        1
       / \
      2   3
     / \
    4   5
```

Step-by-step:

```
Node 4 → height = 1
Node 5 → height = 1

Node 2
leftHeight = 1
rightHeight = 1
diameter = 2
height = 2

Node 3 → height = 1

Node 1
leftHeight = 2
rightHeight = 1
diameter = 3
```

Final answer:

```
3
```

---

# Complexity Analysis

### Time Complexity

```
O(n)
```

Each node is visited once during DFS traversal. :contentReference[oaicite:2]{index=2}

---

### Space Complexity

```
O(h)
```

Where:

```
h = height of the tree
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

# Brute Force (Not Optimal)

A naive solution would:

```
For every node:
    compute height(left)
    compute height(right)
```

This causes repeated height calculations.

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
Tree Height
```

Similar problems:

```
Maximum Depth of Binary Tree
Balanced Binary Tree
Binary Tree Maximum Path Sum
Binary Tree Level Order Traversal
```

---

# Summary

Key observation:

```
Diameter through node = leftHeight + rightHeight
```

Algorithm:

```
DFS
compute subtree heights
update global diameter
```

---

# Final Takeaway

Whenever a tree problem involves:

```
longest path
maximum distance
diameter
```

Think immediately:

```
DFS + subtree height calculation
```

This pattern appears frequently in **tree interview problems**.


https://neetcode.io/problems/binary-tree-diameter/question?list=neetcode150

https://leetcode.com/problems/diameter-of-binary-tree/description/  