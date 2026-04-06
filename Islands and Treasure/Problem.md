# Islands and Treasure (Walls and Gates)

🔗 Problem: https://neetcode.io/problems/islands-and-treasure/question

---

# Problem

You are given an `m x n` grid initialized with:

```
-1 → water (cannot pass)
 0 → treasure chest
INF (2147483647) → land (empty cell)
```

Your task:

```
Fill each land cell with the distance to its nearest treasure chest
```

Rules:

```
• Move only up, down, left, right
• If a cell cannot reach any treasure → keep it as INF
• Modify the grid in-place
``` 
:contentReference[oaicite:0]{index=0}

---

# Example

### Example 1

Input
```
[
  [INF,-1,0,INF],
  [INF,INF,INF,-1],
  [INF,-1,INF,-1],
  [0,-1,INF,INF]
]
```

Output
```
[
  [3,-1,0,1],
  [2,2,1,-1],
  [1,-1,2,-1],
  [0,-1,3,4]
]
```

Explanation

```
Each cell stores distance to nearest 0 (treasure)
```

---

### Example 2

Input
```
[
  [0,-1],
  [INF,INF]
]
```

Output
```
[
  [0,-1],
  [1,2]
]
```

---

# Key Idea

Brute force approach:

```
From every cell → run BFS to nearest treasure
```

Time:

```
O((m * n)^2) ❌ too slow
```

Better idea:

```
Reverse the thinking
```

Instead of:

```
each cell → nearest treasure
```

Do:

```
all treasures → spread distances outward
```

👉 This is called:

```
Multi-Source BFS
``` 
:contentReference[oaicite:1]{index=1}

---

# Intuition

Think of all treasure cells (`0`) as starting points:

```
They expand simultaneously like waves
```

Level by level:

```
Distance = 1 → neighbors
Distance = 2 → neighbors of neighbors
```

So:

```
First time we reach a cell → shortest distance
```

---

# Strategy (Multi-Source BFS)

Steps:

```
1️⃣ Create a queue

2️⃣ Add all treasure cells (grid[i][j] == 0)

3️⃣ Run BFS:

      for each cell:
            visit neighbors

      if neighbor == INF:
            update distance
            add to queue

4️⃣ Continue until queue empty
```

---

# Optimal Java Solution

```java
class Solution {
    public void islandsAndTreasure(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Add all treasure cells
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        // Step 2: BFS
        while(!queue.isEmpty()){

            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            for(int[] d : directions){

                int nr = r + d[0];
                int nc = c + d[1];

                if(nr < 0 || nc < 0 || nr >= m || nc >= n || grid[nr][nc] != Integer.MAX_VALUE){
                    continue;
                }

                grid[nr][nc] = grid[r][c] + 1;
                queue.offer(new int[]{nr, nc});
            }
        }
    }
}
```

---

# Dry Run

Input

```
[
  [INF,-1,0,INF],
  [INF,INF,INF,-1]
]
```

Step 1:

```
Queue = [(0,2)]
```

Step 2:

```
Process (0,2)
→ update neighbors to distance 1
```

Grid:

```
[INF,-1,0,1]
[INF,INF,1,-1]
```

Next:

```
Process (0,3), (1,2)
→ update distance = 2
```

Continue until all reachable cells updated.

---

# Complexity Analysis

### Time Complexity

```
O(m * n)
```

Each cell is processed once. :contentReference[oaicite:2]{index=2}

---

### Space Complexity

```
O(m * n)
```

Queue stores cells in worst case.

---

# Key Tricks

### 1️⃣ Multi-source BFS

```
Start from all treasures at once
```

---

### 2️⃣ First visit = shortest distance

```
No need to revisit nodes
```

---

### 3️⃣ Only update INF cells

```
Avoid overwriting valid values
```

---

# Pattern Recognition

This problem belongs to:

```
Grid BFS + Multi-Source BFS Pattern
```

Similar problems:

```
01 Matrix
Rotting Oranges
Shortest Path in Grid
Walls and Gates
```

---

# Summary

Core idea:

```
Start BFS from all treasure cells
Spread distances outward
First time reaching a cell gives shortest distance
```

---

# Takeaway

Whenever you see:

```
multiple sources
shortest distance from nearest source
grid traversal
```

Think immediately:

```
Multi-Source BFS
```

Because:

```
It avoids repeated work and gives optimal shortest paths
```