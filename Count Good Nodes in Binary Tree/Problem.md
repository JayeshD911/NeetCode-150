# 1448. Count Good Nodes in Binary Tree

🔗 Problem: https://leetcode.com/problems/count-good-nodes-in-binary-tree/

---

# Problem

Given a binary tree `root`, a node `X` in the tree is called **good** if on the path from the root to `X` there are **no nodes with a value greater than `X.val`**. :contentReference[oaicite:0]{index=0}

Return the **number of good nodes** in the binary tree.

---

# Example

### Example 1

Input
```
root = [3,1,4,3,null,1,5]
```

Output
```
4
```

Explanation

```
        3
       / \
      1   4
     /   / \
    3   1   5
```

Check each root-to-node path:

```
Node 3 (root) → good
Path: [3]

Node 1 → not good
Path: [3,1] → 3 > 1

Node 4 → good
Path: [3,4]

Node 3 → good
Path: [3,1,3] → max so far = 3

Node 1 → not good
Path: [3,4,1] → 4 > 1

Node 5 → good
Path: [3,4,5]
```

Good nodes:

```
3, 4, 3, 5
```

Total:

```
4
```

---

### Example 2

Input
```
root = [3,3,null,4,2]
```

Output
```
3
```

Explanation

```
      3
     /
    3
   / \
  4   2
```

Check paths:

```
3 → good
3 → good
4 → good
2 → not good (3 > 2)
```

Total good nodes:

```
3
```

---

# Key Idea

A node is **good** if its value is **greater than or equal to the maximum value encountered so far on the path from the root**. :contentReference[oaicite:1]{index=1}

So during traversal we keep track of:

```
maximum value seen on the current root-to-node path
```

If

```
node.val >= maxSoFar
```

then the node is **good**.

---

# Intuition

While traversing the tree from root to leaves, we track the **maximum value seen so far**.

Example:

```
        3
       / \
      1   4
```

Start at root:

```
maxSoFar = 3
```

Move left:

```
node = 1
1 < 3 → not good
```

Move right:

```
node = 4
4 >= 3 → good
update maxSoFar = 4
```

So every recursive call carries:

```
current node
maximum value so far
```

---

# Strategy (DFS Traversal)

Steps:

```
1️⃣ Start DFS from root

2️⃣ Track the maximum value seen on the path

3️⃣ If node.val >= maxSoFar
      count it as a good node

4️⃣ Update maxSoFar

5️⃣ Continue recursion for left and right children
```

DFS is ideal because we naturally follow **root-to-leaf paths**.

---

# Optimal Java Solution

```java
class Solution {

    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    public int dfs(TreeNode node, int maxSoFar){

        if(node == null) return 0;

        int count = 0;

        if(node.val >= maxSoFar){
            count = 1;
            maxSoFar = node.val;
        }

        count += dfs(node.left, maxSoFar);
        count += dfs(node.right, maxSoFar);

        return count;
    }
}
```

---

# Dry Run

Input

```
root = [3,1,4,3,null,1,5]
```

Tree

```
        3
       / \
      1   4
     /   / \
    3   1   5
```

Steps

```
Start at root = 3
maxSoFar = -∞

3 >= -∞ → good
count = 1
maxSoFar = 3
```

Left subtree:

```
node = 1
1 < 3 → not good
```

Next:

```
node = 3
3 >= 3 → good
count++
```

Right subtree:

```
node = 4
4 >= 3 → good
maxSoFar = 4
```

Next:

```
node = 1
1 < 4 → not good
```

Next:

```
node = 5
5 >= 4 → good
```

Total:

```
4 good nodes
```

---

# Complexity Analysis

### Time Complexity

```
O(n)
```

Where

```
n = number of nodes
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

Used by recursion stack.

Worst case (skewed tree):

```
O(n)
```

---

# Key Tricks

### 1️⃣ Track maximum value along the path

```
maxSoFar
```

---

### 2️⃣ Use DFS traversal

```
root → left → right
```

Because we need to follow **root-to-node paths**.

---

### 3️⃣ Update max dynamically

```
maxSoFar = max(maxSoFar, node.val)
```

---

# Pattern Recognition

This problem belongs to the **Tree DFS + Path Tracking Pattern**.

Similar problems:

```
Maximum Difference Between Node and Ancestor
Path Sum
Binary Tree Maximum Path Sum
```

---

# Summary

Core idea:

```
Traverse tree using DFS
Track maximum value on the path
If node >= maxSoFar → good node
Count it
Continue traversal
```

Final complexity:

```
Time  : O(n)
Space : O(h)
```

---

# Takeaway

Whenever a problem involves:

```
root-to-node path
ancestor comparisons
tracking maximum/minimum along a path
```

Think immediately:

```
DFS + pass state (maxSoFar) down recursion
```

https://neetcode.io/problems/count-good-nodes-in-binary-tree/question?list=neetcode150

https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/