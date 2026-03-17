# 235. Lowest Common Ancestor of a Binary Search Tree

🔗 Problem: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

---

# Problem

Given a **Binary Search Tree (BST)**, find the **lowest common ancestor (LCA)** of two given nodes `p` and `q`.

According to the definition of LCA:

```
The lowest common ancestor is the lowest node in the tree
that has both p and q as descendants.
```

A node can also be a **descendant of itself**. :contentReference[oaicite:0]{index=0}

---

# Example

### Example 1

Input
```
root = [6,2,8,0,4,7,9,null,null,3,5]
p = 2
q = 8
```

Output
```
6
```

Explanation

```
             6
           /   \
          2     8
         / \   / \
        0   4 7   9
           / \
          3   5
```

Node `6` is the **lowest node that has both 2 and 8 as descendants**, so it is the **Lowest Common Ancestor**.

---

### Example 2

Input
```
root = [6,2,8,0,4,7,9,null,null,3,5]
p = 2
q = 4
```

Output
```
2
```

Explanation

```
             6
           /   \
          2     8
         / \
        0   4
           / \
          3   5
```

Node `2` is an **ancestor of node 4**, and since a node can be its own descendant, the **LCA is 2**.

---

### Example 3

Input
```
root = [2,1]
p = 2
q = 1
```

Output
```
2
```

Explanation

```
      2
     /
    1
```

Node `2` is the **ancestor of node 1**, so the LCA is `2`.

---

# Key Idea

This problem becomes easier because the tree is a **Binary Search Tree (BST)**.

BST property:

```
left subtree values  < root
right subtree values > root
```

This property allows us to determine **which direction to move in the tree**.

---

# Intuition

Suppose we are at node `root`.

Three situations can occur:

### Case 1 — Both nodes are smaller

```
p < root
q < root
```

Both nodes must be in the **left subtree**.

Move left.

---

### Case 2 — Both nodes are larger

```
p > root
q > root
```

Both nodes must be in the **right subtree**.

Move right.

---

### Case 3 — Nodes split

```
p < root < q
or
q < root < p
```

This means:

```
one node is in left subtree
one node is in right subtree
```

So the **current node is the LCA**.

---

# Strategy (BST Traversal)

Starting from the root:

```
1️⃣ If both p and q are smaller → go left
2️⃣ If both p and q are larger → go right
3️⃣ Otherwise → current node is LCA
```

Because of the BST ordering, we **never need to search both sides**.

---

# Optimal Java Solution

```java
class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);

        if(root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);

        return root;
    }
}
```

---

# Dry Run

Input

```
root = [6,2,8,0,4,7,9,null,null,3,5]
p = 2
q = 8
```

Tree

```
             6
           /   \
          2     8
         / \   / \
        0   4 7   9
```

Steps

```
Start at root = 6

p = 2
q = 8

Check conditions:

2 < 6
8 > 6
```

One node is on the **left side**, one node is on the **right side**.

Therefore:

```
6 is the Lowest Common Ancestor
```

Return:

```
6
```

---

# Complexity Analysis

### Time Complexity

```
O(h)
```

Where:

```
h = height of the BST
```

In a balanced tree:

```
O(log n)
```

Worst case (skewed tree):

```
O(n)
```

---

### Space Complexity

Recursive solution:

```
O(h)
```

Iterative solution could be:

```
O(1)
```

---

# Key Tricks

### 1️⃣ Use BST property

```
Left subtree < root
Right subtree > root
```

This allows **single-path traversal**.

---

### 2️⃣ Detect split point

The moment `p` and `q` lie on **different sides of a node**, that node is the LCA.

---

### 3️⃣ Early return

Once we find the split point:

```
return root immediately
```

---

# Pattern Recognition

This problem belongs to the **Binary Search Tree Traversal Pattern**.

Related problems:

```
Validate Binary Search Tree
Insert Into BST
Delete Node in BST
Kth Smallest Element in BST
```

Also related LCA problem:

```
Lowest Common Ancestor of a Binary Tree (Harder)
```

---

# Summary

Core ideas:

```
Use BST ordering property
Move left if both nodes are smaller
Move right if both nodes are larger
Return root when nodes split
```

Final complexity:

```
Time  : O(h)
Space : O(h) recursion
```

---

# Takeaway

Whenever a problem involves:

```
Lowest Common Ancestor
Binary Search Tree
```

Think immediately:

```
Use BST property to decide traversal direction
Find the split point
```

That split node is the **Lowest Common Ancestor**.


https://neetcode.io/problems/lowest-common-ancestor-in-binary-search-tree/question

https://leetcode.com/problems/same-tree/submissions/1950915515/