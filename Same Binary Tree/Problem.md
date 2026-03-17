# 100. Same Tree

🔗 Problem: https://leetcode.com/problems/same-tree/

---

# Problem

Given the roots of two binary trees `p` and `q`, write a function to determine whether the two trees are **identical**.

Two binary trees are considered the same if:

```
1. They have the exact same structure
2. Every corresponding node has the same value
```

If any node differs in value or structure, the trees are **not the same**. :contentReference[oaicite:0]{index=0}

---

# Example

### Example 1

Input

```
p = [1,2,3]
q = [1,2,3]
```

Tree

```
    1         1
   / \       / \
  2   3     2   3
```

Output

```
true
```

---

### Example 2

Input

```
p = [1,2]
q = [1,null,2]
```

Tree

```
    1         1
   /           \
  2             2
```

Output

```
false
```

---

### Example 3

Input

```
p = [1,2,1]
q = [1,1,2]
```

Output

```
false
```

---

# Key Idea

We compare the two trees **node by node using DFS**.

At each pair of nodes:

```
1. If both nodes are null → trees match
2. If one node is null → trees differ
3. If values differ → trees differ
4. Otherwise check left subtree and right subtree
```

Two trees are the same **only if all corresponding nodes match in both value and position**. :contentReference[oaicite:1]{index=1}

---

# Intuition

Consider two trees:

```
Tree p:        Tree q:

     1             1
    / \           / \
   2   3         2   3
```

Comparison steps:

```
compare root (1,1) ✔
compare left (2,2) ✔
compare right (3,3) ✔
```

If all nodes match → trees are identical.

---

# Recursive Strategy (DFS)

Algorithm:

```
1. If both nodes are null → return true
2. If one node is null → return false
3. If values differ → return false
4. Recursively compare:
      left subtree
      right subtree
```

---

# Optimal Java Solution (DFS)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null)
            return true;

        if (p == null || q == null)
            return false;

        if (p.val != q.val)
            return false;

        return isSameTree(p.left, q.left)
            && isSameTree(p.right, q.right);
    }
}
```

---

# Dry Run

Example

```
p = [1,2,3]
q = [1,2,3]
```

Execution

```
isSameTree(1,1)
 ├─ isSameTree(2,2)
 │   ├─ isSameTree(null,null) → true
 │   └─ isSameTree(null,null) → true
 │
 └─ isSameTree(3,3)
     ├─ isSameTree(null,null) → true
     └─ isSameTree(null,null) → true
```

Final result:

```
true
```

---

# Complexity Analysis

### Time Complexity

```
O(n)
```

We may need to visit every node in the trees once. :contentReference[oaicite:2]{index=2}

---

### Space Complexity

```
O(h)
```

Where

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

# Iterative Solution (Stack)

Instead of recursion, we can compare nodes using a stack.

Algorithm:

```
1. Push both root nodes into stack
2. Pop nodes in pairs
3. Compare values and children
4. Push children pairs
```

---

# Pattern Recognition

This problem belongs to:

```
Binary Tree
DFS
Recursion
Tree Comparison
```

Related problems:

```
Symmetric Tree
Subtree of Another Tree
Maximum Depth of Binary Tree
Balanced Binary Tree
```

---

# Summary

Key rule:

```
Two trees are identical if:
value(p) == value(q)
AND
left subtree matches
AND
right subtree matches
```

---

# Takeaway

Whenever a problem asks:

```
compare two trees
check structural equality
```

Think immediately:

```
DFS traversal of both trees simultaneously
```

https://neetcode.io/problems/same-binary-tree/question?list=neetcode150

https://leetcode.com/problems/same-tree/description/