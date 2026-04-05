# 133. Clone Graph

🔗 Problem: https://leetcode.com/problems/clone-graph/

---

# Problem

You are given a reference to a node in a **connected undirected graph**.

Each node contains:

```
val       → integer value
neighbors → list of adjacent nodes
```

Your task is to return a **deep copy (clone)** of the graph.

Important:

```
The cloned graph must be completely independent
(no references to original nodes)
``` 
:contentReference[oaicite:0]{index=0}

---

# Example

### Example 1

Input
```
adjList = [[2,4],[1,3],[2,4],[1,3]]
```

Output
```
[[2,4],[1,3],[2,4],[1,3]]
```

Explanation

Graph structure:

```
1 -- 2
|    |
4 -- 3
```

Cloned graph should have:

```
same structure
different node instances
```

---

### Example 2

Input
```
adjList = [[]]
```

Output
```
[[]]
```

Explanation

```
Single node with no neighbors
```

---

### Example 3

Input
```
adjList = []
```

Output
```
[]
```

Explanation

```
Empty graph
```

---

# Key Idea

This is a **graph traversal + cloning problem**.

Main challenges:

```
1. Graph may contain cycles
2. Nodes may be revisited multiple times
```

So we must:

```
Avoid infinite loops
Avoid duplicating nodes
```

Solution:

```
Use HashMap to store original → cloned mapping
``` 
:contentReference[oaicite:1]{index=1}

---

# Intuition

Think of cloning like this:

```
Original node → create copy
Neighbors → recursively clone neighbors
```

But problem:

```
If graph has cycle:
A → B → A → B → ...
```

We will loop forever.

So:

```
Store visited nodes in HashMap
```

If node already cloned:

```
return existing clone
```

---

# Strategy (DFS + HashMap)

Steps:

```
1️⃣ Use HashMap:
      original node → cloned node

2️⃣ For each node:
      if already cloned → return it

3️⃣ Otherwise:
      create new node

4️⃣ Store mapping immediately

5️⃣ Recursively clone neighbors

6️⃣ Return cloned node
```

---

# Optimal Java Solution

```java
class Solution {

    Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {

        if(node == null) return null;

        if(map.containsKey(node)){
            return map.get(node);
        }

        Node copy = new Node(node.val);
        map.put(node, copy);

        for(Node neighbor : node.neighbors){
            copy.neighbors.add(cloneGraph(neighbor));
        }

        return copy;
    }
}
```

---

# Dry Run

Input

```
1 -- 2
|    |
4 -- 3
```

Steps

```
clone(1)
→ create copy(1)
→ map[1] = copy(1)
```

```
clone(2)
→ create copy(2)
→ map[2] = copy(2)
```

```
clone(1) again
→ already in map → return copy(1)
```

Continue:

```
clone(3), clone(4)
```

All nodes cloned exactly once.

---

# Complexity Analysis

### Time Complexity

```
O(V + E)
```

Where:

```
V = number of nodes
E = number of edges
```

We visit each node and edge once. :contentReference[oaicite:2]{index=2}

---

### Space Complexity

```
O(V)
```

For:

```
HashMap + recursion stack
```

---

# Key Tricks

### 1️⃣ Use HashMap for visited nodes

```
original → cloned
```

---

### 2️⃣ Store mapping BEFORE recursion

```
Prevents infinite loops
```

---

### 3️⃣ Handle cycles correctly

```
Return existing clone if visited
```

---

# Pattern Recognition

This problem belongs to:

```
Graph DFS / BFS + HashMap Pattern
```

Similar problems:

```
Number of Islands
Course Schedule
Graph Traversal Problems
Deep Copy Linked List
```

---

# Summary

Core idea:

```
Traverse graph
Clone each node
Use HashMap to avoid duplicates
Build neighbor relationships
```

Final complexity:

```
Time  : O(V + E)
Space : O(V)
```

---

# Takeaway

Whenever you see:

```
clone graph
deep copy
graph with cycles
```

Think immediately:

```
DFS/BFS + HashMap (visited map)
```

Because:

```
You must track already cloned nodes to avoid duplication
```

https://neetcode.io/problems/clone-graph/question?list=neetcode150

https://leetcode.com/problems/clone-graph/description/