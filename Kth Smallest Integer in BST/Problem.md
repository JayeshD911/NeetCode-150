# 230. Kth Smallest Element in a BST

🔗 Problem: https://leetcode.com/problems/kth-smallest-element-in-a-bst/

---

# Problem

Given the root of a **Binary Search Tree (BST)** and an integer `k`, return the **kth smallest value (1-indexed)** among all the values of the nodes in the tree. :contentReference[oaicite:0]{index=0}

A Binary Search Tree follows the rule:

```
left subtree values  < root
right subtree values > root
```

---

# Example

### Example 1

Input
```
root = [3,1,4,null,2]
k = 1
```

Output
```
1
```

Explanation

```
      3
     / \
    1   4
     \
      2
```

Inorder traversal of the BST:

```
[1,2,3,4]
```

The **1st smallest element** is:

```
1
```

---

### Example 2

Input
```
root = [5,3,6,2,4,null,null,1]
k = 3
```

Output
```
3
```

Explanation

```
        5
       / \
      3   6
     / \
    2   4
   /
  1
```

Inorder traversal:

```
[1,2,3,4,5,6]
```

The **3rd smallest element** is:

```
3
```

---

# Key Idea

The key observation is a property of **Binary Search Trees**:

```
Inorder Traversal of a BST gives nodes in sorted order.
```

Traversal order:

```
Left → Root → Right
```

This means:

```
1st visited node = smallest
2nd visited node = 2nd smallest
...
kth visited node = kth smallest
```

So we simply perform an **inorder traversal** and stop when we reach the **kth node**. :contentReference[oaicite:1]{index=1}

---

# Intuition

Consider this BST:

```
        5
       / \
      3   6
     / \
    2   4
   /
  1
```

Inorder traversal visits nodes in this order:

```
1 → 2 → 3 → 4 → 5 → 6
```

If `k = 3`, we count nodes during traversal:

```
1st node → 1
2nd node → 2
3rd node → 3  ← answer
```

Once the counter reaches `k`, we return that node.

---

# Strategy (Inorder DFS)

Steps:

```
1️⃣ Perform inorder traversal

2️⃣ Maintain a counter

3️⃣ Increment counter when visiting a node

4️⃣ When counter == k
      return that node value
```

We stop the traversal as soon as the kth node is found.

---

# Optimal Java Solution

```java
class Solution {

    int count = 0;
    int ans = 0;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return ans;
    }

    public void inorder(TreeNode node, int k){

        if(node == null) return;

        inorder(node.left, k);

        count++;

        if(count == k){
            ans = node.val;
            return;
        }

        inorder(node.right, k);
    }
}
```

---

# Dry Run

Input

```
root = [3,1,4,null,2]
k = 2
```

Tree

```
      3
     / \
    1   4
     \
      2
```

Traversal order

```
1 → 2 → 3 → 4
```

Steps

```
Visit 1 → count = 1
Visit 2 → count = 2
```

Now

```
count == k
```

Return

```
2
```

---

# Complexity Analysis

### Time Complexity

```
O(n)
```

Where:

```
n = number of nodes in the BST
```

In the worst case we may traverse the whole tree. :contentReference[oaicite:2]{index=2}

---

### Space Complexity

```
O(h)
```

Where:

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

### 1️⃣ Use inorder traversal

```
BST inorder traversal = sorted order
```

---

### 2️⃣ Maintain a counter

```
count++
```

Stop when:

```
count == k
```

---

### 3️⃣ Early termination

Once we find the kth element:

```
stop recursion
```

This avoids unnecessary traversal.

---

# Pattern Recognition

This problem belongs to the **BST + Inorder Traversal Pattern**.

Similar problems:

```
Validate Binary Search Tree
Convert BST to Sorted List
BST Iterator
Minimum Absolute Difference in BST
```

---

# Summary

Core idea:

```
Use inorder traversal of BST
Visit nodes in sorted order
Return the kth visited node
```

Final complexity:

```
Time  : O(n)
Space : O(h)
```

---

# Takeaway

Whenever you see a problem asking for:

```
kth smallest in BST
kth largest in BST
sorted order of BST
```

Think immediately:

```
Inorder Traversal
```

Because **BST inorder traversal automatically produces sorted values**.