# 102. Binary Tree Level Order Traversal

🔗 Problem: https://leetcode.com/problems/binary-tree-level-order-traversal/

---

# Problem

Given the root of a binary tree, return the **level order traversal of its nodes' values**.

Level order traversal means visiting nodes **level by level from left to right**. :contentReference[oaicite:0]{index=0}

The output should be a **list of lists**, where each inner list represents one level of the tree.

---

# Example

### Example 1

Input
```
root = [3,9,20,null,null,15,7]
```

Output
```
[[3],[9,20],[15,7]]
```

Explanation

```
        3
       / \
      9   20
         /  \
        15   7
```

Level by level traversal:

```
Level 0 → [3]
Level 1 → [9,20]
Level 2 → [15,7]
```

Final result

```
[[3],[9,20],[15,7]]
```

---

### Example 2

Input
```
root = [1]
```

Output
```
[[1]]
```

Explanation

Only one node exists, so the traversal contains a single level.

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

Explanation

The tree is empty, so there are no levels to traverse.

---

# Key Idea

Level order traversal is equivalent to **Breadth-First Search (BFS)** on a tree. :contentReference[oaicite:1]{index=1}

BFS explores nodes **level by level**, ensuring all nodes at the current depth are processed before moving to the next level.

To achieve this we use a:

```
Queue (FIFO structure)
```

The queue keeps track of nodes waiting to be processed.

---

# Intuition

Imagine the tree being explored **layer by layer**.

```
        3
       / \
      9   20
         /  \
        15   7
```

Processing order:

```
Level 0 → 3
Level 1 → 9,20
Level 2 → 15,7
```

Queue behavior:

```
Start queue = [3]

Process 3
Add children → [9,20]

Process 9,20
Add children → [15,7]

Process 15,7
```

Each loop processes **exactly one level**.

---

# Strategy (BFS Traversal)

Steps:

```
1️⃣ If root is null → return empty list

2️⃣ Initialize queue and add root

3️⃣ While queue is not empty
      get current level size
      process all nodes in that level
      add their children to queue

4️⃣ Store each level's values in result
```

Key trick:

```
Queue size tells how many nodes exist at the current level
```

---

# Optimal Java Solution

```java
class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if(root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){

            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for(int i = 0; i < size; i++){

                TreeNode node = q.poll();
                level.add(node.val);

                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }

            ans.add(level);
        }

        return ans;
    }
}
```

---

# Dry Run

Input

```
root = [3,9,20,null,null,15,7]
```

Tree

```
        3
       / \
      9   20
         /  \
        15   7
```

Queue simulation

```
Queue = [3]

Process level 0
→ remove 3
→ add children 9,20

Queue = [9,20]

Process level 1
→ remove 9
→ remove 20
→ add children 15,7

Queue = [15,7]

Process level 2
→ remove 15
→ remove 7
```

Result

```
[[3],[9,20],[15,7]]
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
O(n)
```

Queue may store up to one entire level of nodes.

Worst case (complete tree):

```
n/2 nodes in queue
```

---

# Key Tricks

### 1️⃣ Use a queue

```
Queue ensures BFS order
```

---

### 2️⃣ Capture level size

```
int size = queue.size()
```

This isolates nodes belonging to the same level.

---

### 3️⃣ Add children in order

```
left child first
right child second
```

This preserves **left → right traversal**.

---

# Pattern Recognition

This problem belongs to the **Tree BFS Pattern**.

Common problems using this pattern:

```
Binary Tree Level Order Traversal
Binary Tree Right Side View
Binary Tree Zigzag Level Order Traversal
Average of Levels in Binary Tree
Minimum Depth of Binary Tree
```

---

# Summary

Core idea

```
Use Breadth-First Search
Traverse tree level by level
Use queue to process nodes
Group nodes by levels
```

Final complexity

```
Time  : O(n)
Space : O(n)
```

---

# Takeaway

Whenever a problem asks for:

```
level by level traversal
breadth first traversal
nodes grouped by depth
```

Think immediately:

```
BFS + Queue
```

That is the standard approach for **Level Order Traversal**.


https://neetcode.io/problems/level-order-traversal-of-binary-tree/question?list=neetcode150

https://leetcode.com/problems/binary-tree-level-order-traversal/description/