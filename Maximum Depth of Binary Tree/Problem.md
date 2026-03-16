# 104. Maximum Depth of Binary Tree

🔗 Problem: https://leetcode.com/problems/maximum-depth-of-binary-tree/

---

# Problem

Given the **root of a binary tree**, return its **maximum depth**.

The **maximum depth** of a binary tree is the number of nodes along the **longest path from the root node down to the farthest leaf node**. :contentReference[oaicite:0]{index=0}

A **leaf node** is a node with **no children**.

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
3
```

Explanation

Longest path:

```
3 → 20 → 15
```

Depth = **3 nodes**

---

### Example 2

Input

```
root = [1,null,2]
```

Output

```
2
```

---

# Key Idea

The maximum depth of a binary tree is determined by:

```
1 + max(depth of left subtree, depth of right subtree)
```

At every node:

```
depth = 1 + max(leftDepth, rightDepth)
```

If the node is `null`, the depth is **0**.

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

Depth of left subtree:

```
1 → 2
depth = 2
```

Depth of right subtree:

```
1 → 3 → 4
depth = 3
```

Maximum depth:

```
max(2,3) = 3
```

---

# Recursive Strategy (DFS)

Steps:

```
1. If node is null → return 0
2. Recursively compute left depth
3. Recursively compute right depth
4. Return 1 + max(leftDepth, rightDepth)
```

---

# Java Solution (Recursive DFS)

```java
class Solution {

    public int maxDepth(TreeNode root) {

        if(root == null)
            return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return 1 + Math.max(leftDepth, rightDepth);
    }
}
```

---

# Dry Run

Input tree

```
        3
       / \
      9  20
         / \
        15  7
```

Execution

```
maxDepth(3)
  ├─ maxDepth(9) = 1
  └─ maxDepth(20)
        ├─ maxDepth(15) = 1
        └─ maxDepth(7)  = 1
        → depth = 2
```

Final result

```
1 + max(1,2) = 3
```

---

# Iterative Solution (BFS)

Another approach is **level-order traversal** using a queue.

Algorithm:

```
1. Push root into queue
2. Process nodes level by level
3. Increase depth after each level
```

---

### Java BFS Solution

```java
class Solution {

    public int maxDepth(TreeNode root) {

        if(root == null)
            return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int depth = 0;

        while(!q.isEmpty()){

            int size = q.size();

            for(int i = 0; i < size; i++){

                TreeNode node = q.poll();

                if(node.left != null)
                    q.offer(node.left);

                if(node.right != null)
                    q.offer(node.right);
            }

            depth++;
        }

        return depth;
    }
}
```

---

# Complexity Analysis

### Time Complexity

```
O(n)
```

Every node is visited exactly once. :contentReference[oaicite:1]{index=1}

---

### Space Complexity

Recursive DFS:

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

# Pattern Recognition

This problem belongs to the **Binary Tree DFS pattern**.

Similar problems:

```
Minimum Depth of Binary Tree
Diameter of Binary Tree
Balanced Binary Tree
Same Tree
Binary Tree Level Order Traversal
```

---

# Summary

Core idea:

```
Depth(node) = 1 + max(depth(left), depth(right))
```

Base case:

```
null node → depth = 0
```

---

# Takeaway

Whenever a problem asks:

```
height of tree
maximum depth
longest root-to-leaf path
```

Think immediately:

```
DFS recursion on binary tree
```

https://neetcode.io/problems/depth-of-binary-tree/question?list=neetcode150

https://leetcode.com/problems/maximum-depth-of-binary-tree/submissions/1950149656/