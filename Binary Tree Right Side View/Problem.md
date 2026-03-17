# 199. Binary Tree Right Side View

🔗 Problem: https://leetcode.com/problems/binary-tree-right-side-view/

---

# Problem

Given the root of a binary tree, imagine yourself standing on the **right side** of it. Return the values of the nodes you can see **ordered from top to bottom**. :contentReference[oaicite:0]{index=0}

In other words:

```
For every level of the tree,
return the rightmost node.
```

---

# Example

### Example 1

Input
```
root = [1,2,3,null,5,null,4]
```

Output
```
[1,3,4]
```

Explanation

```
        1
       / \
      2   3
       \   \
        5   4
```

Visible nodes from the **right side**:

```
Level 0 → 1
Level 1 → 3
Level 2 → 4
```

Final result

```
[1,3,4]
```

---

### Example 2

Input
```
root = [1,null,3]
```

Output
```
[1,3]
```

Explanation

```
    1
     \
      3
```

Rightmost nodes:

```
Level 0 → 1
Level 1 → 3
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

Explanation

The tree is empty, so there are no visible nodes.

---

# Key Idea

From the right side of the tree, only the **rightmost node at each level** is visible. :contentReference[oaicite:1]{index=1}

So the problem reduces to:

```
Find the rightmost node of each level.
```

The most natural way to process levels is using **Breadth-First Search (BFS)**.

---

# Intuition

Consider this tree:

```
        1
       / \
      2   3
       \   \
        5   4
```

Level traversal:

```
Level 0 → [1]
Level 1 → [2,3]
Level 2 → [5,4]
```

At every level, we only take:

```
last node in that level
```

So we get:

```
1
3
4
```

---

# Strategy (Level Order Traversal)

Steps:

```
1️⃣ If root is null → return empty list

2️⃣ Use a queue for BFS

3️⃣ For each level
      determine number of nodes
      process nodes in that level

4️⃣ The last node processed in that level
      is the rightmost node

5️⃣ Add it to the result list
```

---

# Optimal Java Solution

```java
class Solution {

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        if(root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){

            int size = q.size();

            for(int i = 0; i < size; i++){

                TreeNode node = q.poll();

                if(i == size - 1){
                    ans.add(node.val);
                }

                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
        }

        return ans;
    }
}
```

---

# Dry Run

Input

```
root = [1,2,3,null,5,null,4]
```

Tree

```
        1
       / \
      2   3
       \   \
        5   4
```

Queue simulation

```
Queue = [1]

Level 0
Nodes → [1]
Rightmost → 1

Queue = [2,3]

Level 1
Nodes → [2,3]
Rightmost → 3

Queue = [5,4]

Level 2
Nodes → [5,4]
Rightmost → 4
```

Result

```
[1,3,4]
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

Every node is visited exactly once.

---

### Space Complexity

```
O(n)
```

Queue may hold all nodes of the widest level.

---

# Key Tricks

### 1️⃣ Level Size

```
int size = queue.size()
```

Allows processing nodes level by level.

---

### 2️⃣ Capture Last Node

```
if(i == size - 1)
```

This identifies the **rightmost node**.

---

### 3️⃣ Use BFS

```
Queue ensures level order traversal.
```

---

# Pattern Recognition

This problem belongs to the **Tree BFS Pattern**.

Similar problems:

```
Binary Tree Level Order Traversal
Binary Tree Left Side View
Binary Tree Zigzag Level Order Traversal
Average of Levels in Binary Tree
```

---

# Summary

Core idea:

```
Traverse the tree level by level
Take the rightmost node at each level
Store it in the result
```

Final complexity:

```
Time  : O(n)
Space : O(n)
```

---

# Takeaway

Whenever a problem asks for:

```
nodes visible from right side
right view of a tree
```

Think immediately:

```
BFS + take last node of each level
```

That gives the **Right Side View of the Binary Tree**.

https://neetcode.io/problems/binary-tree-right-side-view/question

https://leetcode.com/problems/binary-tree-right-side-view/description/