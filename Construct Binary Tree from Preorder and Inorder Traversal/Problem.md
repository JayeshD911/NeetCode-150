# 105. Construct Binary Tree from Preorder and Inorder Traversal

🔗 Problem: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

---

# Problem

You are given two integer arrays:

```
preorder
inorder
```

Where:

```
preorder = preorder traversal of a binary tree
inorder  = inorder traversal of the same tree
```

Your task is to **reconstruct the binary tree and return its root**. :contentReference[oaicite:0]{index=0}

Assumptions:

```
All node values are unique
Both arrays represent the same tree
```

---

# Example

### Example 1

Input
```
preorder = [3,9,20,15,7]
inorder  = [9,3,15,20,7]
```

Output
```
[3,9,20,null,null,15,7]
```

Explanation

```
Preorder: Root → Left → Right
Inorder : Left → Root → Right
```

Tree structure:

```
        3
       / \
      9   20
         /  \
        15   7
```

How it forms:

```
Root = first element of preorder = 3
```

Find `3` in inorder:

```
[9 | 3 | 15,20,7]
```

Left subtree:

```
[9]
```

Right subtree:

```
[15,20,7]
```

So we recursively build:

```
Left subtree → 9
Right subtree → [20,15,7]
```

---

### Example 2

Input
```
preorder = [-1]
inorder  = [-1]
```

Output
```
[-1]
```

Explanation

Single node tree.

---

# Key Idea

The key observation:

```
Preorder → first element is always the root
```

```
Inorder → root splits left and right subtrees
```

So the process is:

```
1️⃣ Pick root from preorder
2️⃣ Find root index in inorder
3️⃣ Elements left of root → left subtree
4️⃣ Elements right of root → right subtree
```

Using this information we can **recursively construct the tree**. :contentReference[oaicite:1]{index=1}

---

# Intuition

Consider:

```
preorder = [3,9,20,15,7]
inorder  = [9,3,15,20,7]
```

Step 1

```
Root = 3
```

Step 2

Split inorder

```
Left  = [9]
Right = [15,20,7]
```

Step 3

Next preorder elements correspond to those subtrees:

```
Left subtree root = 9
Right subtree root = 20
```

Continue recursively.

---

# Strategy (Divide and Conquer)

Steps:

```
1️⃣ Create hashmap for inorder indices

2️⃣ Maintain preorder index

3️⃣ Recursively build tree
```

Recursive rule:

```
root = preorder[index]

split inorder around root

build left subtree
build right subtree
```

---

# Optimal Java Solution

```java
class Solution {

    int preIndex = 0;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int left, int right){

        if(left > right) return null;

        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        int mid = map.get(rootVal);

        root.left = build(preorder, left, mid - 1);
        root.right = build(preorder, mid + 1, right);

        return root;
    }
}
```

---

# Dry Run

Input

```
preorder = [3,9,20,15,7]
inorder  = [9,3,15,20,7]
```

Step 1

```
Root = 3
```

Split inorder

```
[9 | 3 | 15,20,7]
```

Step 2

Left subtree

```
preorder = 9
inorder  = [9]
```

Step 3

Right subtree

```
preorder = [20,15,7]
inorder  = [15,20,7]
```

Continue recursively.

Final tree

```
        3
       / \
      9   20
         /  \
        15   7
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

Each node is processed once.

Using a hashmap ensures **O(1)** lookup for inorder index.

---

### Space Complexity

```
O(n)
```

For:

```
recursion stack
hashmap
```

Worst case (skewed tree):

```
O(n)
```

---

# Key Tricks

### 1️⃣ Preorder gives root

```
root = preorder[index]
```

---

### 2️⃣ Inorder splits tree

```
Left subtree
Right subtree
```

---

### 3️⃣ Use hashmap

```
map[value] = index in inorder
```

This avoids `O(n²)` searching.

---

# Pattern Recognition

This problem belongs to the **Tree Construction Pattern**.

Similar problems:

```
Construct Binary Tree from Inorder and Postorder
Convert Sorted Array to BST
Serialize and Deserialize Binary Tree
```

Also uses:

```
Divide and Conquer
```

---

# Summary

Core idea

```
Use preorder to find root
Use inorder to split tree
Recursively construct left and right subtrees
```

Final complexity

```
Time  : O(n)
Space : O(n)
```

---

# Takeaway

Whenever you see problems involving:

```
reconstruct tree
preorder + inorder
postorder + inorder
```

Think immediately:

```
Root from preorder/postorder
Split using inorder
Build tree recursively
```


https://neetcode.io/problems/binary-tree-from-preorder-and-inorder-traversal/question

https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/