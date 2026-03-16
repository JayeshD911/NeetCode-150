# 226. Invert Binary Tree

🔗 Problem: https://leetcode.com/problems/invert-binary-tree/

---

# Problem

Given the **root of a binary tree**, invert the tree and return its root. :contentReference[oaicite:1]{index=1}

Inverting a binary tree means **swapping the left and right child of every node**, producing a mirror image of the original tree. :contentReference[oaicite:2]{index=2}

---

# Example

### Example 1

Input

```
root = [4,2,7,1,3,6,9]
```

Tree

```
        4
       / \
      2   7
     / \ / \
    1  3 6  9
```

Output

```
[4,7,2,9,6,3,1]
```

Inverted tree

```
        4
       / \
      7   2
     / \ / \
    9  6 3  1
```

---

### Example 2

Input

```
root = [2,1,3]
```

Output

```
[2,3,1]
```

---

### Example 3

Input

```
root = []
```

Output

```
[]
```

---

# Key Idea

The tree becomes a **mirror image** when every node swaps its children.

At every node:

```
swap(left, right)
```

Then recursively perform the same operation on the subtrees. :contentReference[oaicite:3]{index=3}

---

# Intuition

Consider the tree:

```
        4
       / \
      2   7
```

If we swap children of `4`:

```
        4
       / \
      7   2
```

But the subtrees must also be inverted.

Therefore we recursively invert:

```
left subtree
right subtree
```

---

# Recursive Strategy

Steps:

```
1. If node is null → return null
2. Swap left and right children
3. Recursively invert left subtree
4. Recursively invert right subtree
5. Return root
```

---

# Java Solution (DFS Recursion)

```java
class Solution {

    public TreeNode invertTree(TreeNode root) {

        if(root == null)
            return null;

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = invertTree(right);
        root.right = invertTree(left);

        return root;
    }
}
```

---

# Dry Run

Input

```
      1
     / \
    2   3
```

Step 1

Swap children of `1`

```
      1
     / \
    3   2
```

Step 2

Recursively invert subtrees

Final result

```
      1
     / \
    3   2
```

---

# Complexity Analysis

### Time Complexity

```
O(n)
```

Every node is visited exactly once. :contentReference[oaicite:4]{index=4}

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

# Alternative Approach (BFS)

We can also invert the tree using **level-order traversal**.

Algorithm:

```
1. Use a queue
2. Visit nodes level by level
3. Swap left and right children
```

---

# Pattern Recognition

This problem belongs to:

```
Tree
DFS
Recursion
```

Similar problems:

```
Binary Tree Level Order Traversal
Same Tree
Maximum Depth of Binary Tree
Symmetric Tree
```

---

# Summary

Key idea:

```
Swap left and right child of every node
Apply recursively to entire tree
```

Final complexity:

```
Time  : O(n)
Space : O(h)
```

---

# Takeaway

Whenever a problem asks to:

```
mirror a tree
swap children
reverse structure
```

Think immediately:

```
DFS recursion on binary tree
```

https://neetcode.io/problems/invert-a-binary-tree/question?list=neetcode150

https://leetcode.com/problems/invert-binary-tree/description/