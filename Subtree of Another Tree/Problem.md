# 572. Subtree of Another Tree

🔗 Problem: https://leetcode.com/problems/subtree-of-another-tree/

---

# Problem

Given the roots of two binary trees `root` and `subRoot`, return **true** if there is a subtree of `root` with the same structure and node values as `subRoot`, and **false** otherwise.

A subtree of a binary tree is a node in that tree and **all of this node’s descendants**. The tree itself can also be considered a subtree of itself.

---

# Example

### Example 1

Input
```
root = [3,4,5,1,2]
subRoot = [4,1,2]
```

Output
```
true
```

Explanation

```
root:

        3
       / \
      4   5
     / \
    1   2

subRoot:

      4
     / \
    1   2
```

The subtree starting at node **4** in the main tree matches `subRoot` exactly in both **structure and node values**, so the answer is `true`.

---

### Example 2

Input
```
root = [3,4,5,1,2,null,null,null,null,0]
subRoot = [4,1,2]
```

Output
```
false
```

Explanation

```
root:

        3
       / \
      4   5
     / \
    1   2
         \
          0

subRoot:

      4
     / \
    1   2
```

Even though node `4` exists in `root`, the subtree rooted at `4` is **not identical** to `subRoot` because there is an **extra node (0)** in the main tree.

---

# Key Idea

This problem is a combination of **tree traversal** and **tree comparison**.

The main challenge is:

```
subRoot can start at any node inside root
```

So at every node of `root`, we must check:

```
Does the subtree starting here look exactly like subRoot?
```

That means we need two things:

1. A function to check whether **two trees are identical**
2. A function to traverse `root` and try matching at every node

---

# Intuition

Suppose:

```
root = [3,4,5,1,2]
subRoot = [4,1,2]
```

Visual:

```
root:

        3
       / \
      4   5
     / \
    1   2

subRoot:

      4
     / \
    1   2
```

We start from node `3`.

```
Is subtree rooted at 3 equal to subRoot? → No
```

Then move left.

```
Is subtree rooted at 4 equal to subRoot? → Yes
```

So answer becomes `true`.

The idea is:

```
Traverse root
At each node:
    compare current subtree with subRoot
```

This comparison itself is exactly the **Same Tree** problem.

---

# Recursive Strategy

At each node in `root`:

```
1️⃣ Check if current subtree matches subRoot
2️⃣ If not, recurse on left subtree
3️⃣ If not, recurse on right subtree
```

For comparing two trees:

```
1️⃣ If both nodes are null → true
2️⃣ If only one is null → false
3️⃣ If values differ → false
4️⃣ Recurse on left and right children
```

---

# Optimal Java Solution

```java
class Solution {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if(subRoot == null) return true;
        if(root == null) return false;

        if(isSame(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) ||
               isSubtree(root.right, subRoot);
    }

    public boolean isSame(TreeNode p, TreeNode q) {

        if(p == null && q == null) return true;

        if(p == null || q == null) return false;

        if(p.val != q.val) return false;

        return isSame(p.left, q.left) &&
               isSame(p.right, q.right);
    }
}
```

---

# Dry Run

Input

```
root = [3,4,5,1,2]
subRoot = [4,1,2]
```

Tree

```
        3
       / \
      4   5
     / \
    1   2
```

Steps

```
Start at node 3

Check isSame(3,4) → false

Move to left subtree

Check isSame(4,4)

Values match

Check left children
isSame(1,1) → true

Check right children
isSame(2,2) → true

Both subtrees match

Return true
```

Output

```
true
```

---

# Complexity Analysis

### Time Complexity

```
O(n * m)
```

Where:

```
n = number of nodes in root
m = number of nodes in subRoot
```

In the worst case we compare `subRoot` with every node in `root`.

---

### Space Complexity

```
O(n)
```

Due to recursion stack in the worst case (skewed tree).

More precisely:

```
O(h1 + h2)
```

Where:

```
h1 = height of root
h2 = height of subRoot
```

---

# Key Tricks

### 1️⃣ Split the problem into two recursive functions

```
isSubtree() → searches every node
isSame()    → checks exact tree match
```

---

### 2️⃣ Exact match requires both structure and values

```
Values alone are not enough
Tree structure must also match
```

---

### 3️⃣ Apply Same Tree at every node

```
Traverse main tree
Run Same Tree comparison at each node
```

---

# Pattern Recognition

This problem belongs to the **Tree DFS Pattern**.

Similar problems:

```
Same Tree
Balanced Binary Tree
Diameter of Binary Tree
Invert Binary Tree
Symmetric Tree
```

---

# Summary

Core ideas:

```
Traverse the main tree
At every node try matching subRoot
Use recursive tree comparison
Return true once a valid match is found
```

Final complexity:

```
Time  : O(n * m)
Space : O(n)
```

---

# Takeaway

Whenever a problem asks for:

```
check whether one tree exists inside another tree
match subtree exactly
same structure and same values
```

Think immediately:

```
DFS traversal + Same Tree comparison
```