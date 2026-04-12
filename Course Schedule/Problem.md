# 207. Course Schedule

🔗 Problem: https://leetcode.com/problems/course-schedule/

---

# Problem

There are `numCourses` courses labeled from:

```
0 → numCourses - 1
```

You are given:

```
prerequisites[i] = [a, b]
```

Meaning:

```
To take course 'a', you must first complete course 'b'
```

Return:

```
true  → if you can finish all courses
false → if it is impossible
``` 
:contentReference[oaicite:0]{index=0}

---

# Example

### Example 1

Input
```
numCourses = 2
prerequisites = [[1,0]]
```

Output
```
true
```

Explanation

```
Take course 0 first
Then take course 1
```

---

### Example 2

Input
```
numCourses = 2
prerequisites = [[1,0],[0,1]]
```

Output
```
false
```

Explanation

```
0 → requires 1
1 → requires 0

Cycle exists → impossible
```

---

# Key Idea

This is a **graph problem**.

Model:

```
Courses → nodes
Prerequisites → directed edges
```

Example:

```
[1,0] → edge: 0 → 1
```

Core question:

```
Can we finish all nodes without cycles?
```

👉 If a **cycle exists**, it is impossible to complete all courses. :contentReference[oaicite:1]{index=1}

---

# Intuition

Think of it like dependencies:

```
Course A depends on B
Course B depends on C
Course C depends on A
```

You get stuck in a loop.

So problem reduces to:

```
Detect cycle in directed graph
```

If:

```
No cycle → valid → return true
Cycle exists → return false
```

---

# Strategy (Topological Sort - BFS / Kahn's Algorithm)

Steps:

```
1️⃣ Build graph (adjacency list)

2️⃣ Compute indegree of each node

3️⃣ Add all nodes with indegree = 0 to queue

4️⃣ While queue not empty:
      remove node
      reduce indegree of neighbors

5️⃣ Count processed nodes

6️⃣ If count == numCourses → no cycle → return true
   else → cycle exists → return false
```

Why this works:

```
If cycle exists → some nodes will never reach indegree 0
``` 
:contentReference[oaicite:2]{index=2}

---

# Optimal Java Solution (BFS - Kahn's Algorithm)

```java
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }

        // build graph
        for(int[] pre : prerequisites){
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        // add nodes with indegree 0
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        int count = 0;

        while(!queue.isEmpty()){

            int curr = queue.poll();
            count++;

            for(int nei : graph.get(curr)){
                indegree[nei]--;

                if(indegree[nei] == 0){
                    queue.offer(nei);
                }
            }
        }

        return count == numCourses;
    }
}
```

---

# Dry Run

Input

```
numCourses = 4
prerequisites = [[1,0],[2,0],[3,1],[3,2]]
```

Graph

```
0 → 1,2
1 → 3
2 → 3
```

Indegree

```
0:0, 1:1, 2:1, 3:2
```

Steps

```
Queue = [0]

Take 0 → reduce indegree of 1,2
Queue = [1,2]

Take 1 → reduce indegree of 3
Take 2 → reduce indegree of 3 → becomes 0
Queue = [3]

Take 3
```

Processed:

```
count = 4 = numCourses
```

Return

```
true
```

---

# Complexity Analysis

### Time Complexity

```
O(V + E)
```

Where:

```
V = number of courses
E = number of prerequisites
``` 
:contentReference[oaicite:3]{index=3}

---

### Space Complexity

```
O(V + E)
```

For graph + queue.

---

# Key Tricks

### 1️⃣ Convert to graph

```
Prerequisites → directed edges
```

---

### 2️⃣ Use indegree array

```
Track dependencies
```

---

### 3️⃣ Start with independent nodes

```
indegree = 0
```

---

### 4️⃣ Detect cycle via count

```
If not all nodes processed → cycle exists
```

---

# Pattern Recognition

This problem belongs to:

```
Graph + Topological Sort + Cycle Detection Pattern
```

Similar problems:

```
Course Schedule II
Alien Dictionary
Minimum Height Trees
Detect Cycle in Directed Graph
```

---

# Summary

Core idea:

```
Build graph
Perform topological sort
Check if all nodes are processed
```

Final complexity:

```
Time  : O(V + E)
Space : O(V + E)
```

---

# Takeaway

Whenever you see:

```
dependencies
prerequisites
ordering tasks
```

Think immediately:

```
Topological Sort (BFS or DFS)
```

Because:

```
Cycle detection determines feasibility
```

