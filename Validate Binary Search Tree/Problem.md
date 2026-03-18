# 98. Validate Binary Search Tree

🔗 Problem: https://leetcode.com/problems/validate-binary-search-tree/

---

# Problem

Given the root of a binary tree, determine if it is a **valid Binary Search Tree (BST)**.

A valid BST is defined as follows:

```
The left subtree of a node contains only nodes with values less than the node's value.
The right subtree of a node contains only nodes with values greater than the node's value.
Both the left and right subtrees must also be binary search trees.
```

Return `true` if the tree is a valid BST, otherwise return `false`.

---

# Example

### Example 1

Input
```
root = [2,1,3]
```

Output
```
true
```

Explanation

```
    2
   / \
  1   3
```

Check BST rules:

```
1 < 2
3 > 2
```

Both left and right subtrees also satisfy BST conditions.

So the tree is a valid BST.

---

### Example 2

Input
```
root = [5,1,4,null,null,3,6]
```

Output
```
false
```

Explanation

```
    5
   / \
  1   4
     / \
    3   6
```

At first glance, node `4` looks fine because:

```
4 < 5 on the right? No, that is already wrong
```

More importantly, every node in the **right subtree of 5** must be:

```
greater than 5
```

But node `3` is in the right subtree of `5` and:

```
3 < 5
```

So this tree is **not** a valid BST.

---

# Key Idea

The biggest mistake in this problem is checking only:

```
node.left < node
node.right > node
```

That is **not enough**.

Why?

Because every node must satisfy the rule not just with its parent, but with **all its ancestors**.

So for each node, we must maintain:

```
lower bound
upper bound
```

A node is valid only if:

```
lower < node.val < upper
```

---

# Intuition

Consider this tree:

```
    5
   / \
  1   4
     / \
    3   6
```

Node `4` is on the **right side of 5**, so it should be greater than `5`.

But:

```
4 < 5
```

So the tree is invalid.

Now think about node `3`.

It is the left child of `4`, so locally:

```
3 < 4
```

which seems correct.

But globally, since it lies in the **right subtree of 5**, it must also satisfy:

```
3 > 5
```

which is false.

So local checks are not enough.

That is why we pass valid ranges during recursion.

---

# Strategy

For every node, maintain the valid range:

```
(min, max)
```

Rules:

```
1️⃣ If node is null → return true
2️⃣ If node.val <= min or node.val >= max → return false
3️⃣ Recurse left with range (min, node.val)
4️⃣ Recurse right with range (node.val, max)
```

This ensures every node respects the BST rules from all ancestors.

---

# Optimal Java Solution

```java
class Solution {

    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean dfs(TreeNode node, long min, long max) {

        if(node == null) return true;

        if(node.val <= min || node.val >= max) return false;

        return dfs(node.left, min, node.val) &&
               dfs(node.right, node.val, max);
    }
}
```

---

# Dry Run

Input

```
root = [5,1,4,null,null,3,6]
```

Tree

```
    5
   / \
  1   4
     / \
    3   6
```

Steps

```
Start at root = 5
Valid range = (-∞, +∞)

5 is valid
```

Go left:

```
node = 1
range = (-∞, 5)

1 is valid
```

Go right:

```
node = 4
range = (5, +∞)
```

Now check:

```
4 <= 5
```

This violates the BST rule.

So return:

```
false
```

---

# Complexity Analysis

### Time Complexity

```
O(n)
```

Where

```
n = number of nodes in the tree
```

Each node is visited exactly once.

---

### Space Complexity

```
O(h)
```

Where

```
h = height of the tree
```

This is the recursion stack space.

Worst case for a skewed tree:

```
O(n)
```

---

# Key Tricks

### 1️⃣ Use range checking, not just parent checking

```
Each node must satisfy all ancestor constraints
```

---

### 2️⃣ Left subtree gets upper bound

```
(max = current node value)
```

---

### 3️⃣ Right subtree gets lower bound

```
(min = current node value)
```

---

### 4️⃣ Use long instead of int

```
Long.MIN_VALUE
Long.MAX_VALUE
```

This avoids edge case issues when node values are at integer limits.

---

# Pattern Recognition

This problem belongs to the **Tree DFS + Bounds Pattern**.

Similar problems:

```
Lowest Common Ancestor
Construct BST from Sorted Array
Kth Smallest Element in BST
Delete Node in a BST
```

Also related:

```
Inorder Traversal of BST
```

because inorder of a valid BST is strictly increasing.

---

# Summary

Core idea:

```
A valid BST needs global validation, not local validation
Pass min and max bounds during DFS
Every node must lie strictly between those bounds
```

Final complexity:

```
Time  : O(n)
Space : O(h)
```

---

# Takeaway

Whenever a problem asks:

```
validate BST
check if tree follows BST rules
```

Think immediately:

```
DFS + lower bound + upper bound
```

Do not just compare with the parent.

That is the key to solving **Validate Binary Search Tree** correctly.


https://neetcode.io/problems/valid-binary-search-tree/question

https://leetcode.com/problems/validate-binary-search-tree/description/