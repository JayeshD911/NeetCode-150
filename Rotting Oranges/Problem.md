# 994. Rotting Oranges

🔗 Problem: https://leetcode.com/problems/rotting-oranges/

---

# Problem

You are given an `m x n` grid where:

```
0 → empty cell
1 → fresh orange
2 → rotten orange
```

Every minute:

```
Any fresh orange adjacent (up, down, left, right) to a rotten orange becomes rotten
``` 
:contentReference[oaicite:0]{index=0}

Return:

```
Minimum number of minutes until no fresh orange remains
OR
-1 if impossible
```

---

# Example

### Example 1

Input
```
grid = [
  [2,1,1],
  [1,1,0],
  [0,1,1]
]
```

Output
```
4
```

Explanation

```
Minute 0:
2 1 1
1 1 0
0 1 1

Minute 1:
2 2 1
2 1 0
0 1 1

Minute 2:
2 2 2
2 2 0
0 1 1

Minute 3:
2 2 2
2 2 0
0 2 1

Minute 4:
2 2 2
2 2 0
0 2 2
```

All oranges become rotten in:

```
4 minutes
```

---

### Example 2

Input
```
grid = [
  [2,1,1],
  [0,1,1],
  [1,0,1]
]
```

Output
```
-1
```

Explanation

```
Some oranges are unreachable → cannot rot
```

---

# Key Idea

This is a **multi-source BFS problem**.

Observation:

```
Rot spreads level by level (minute by minute)
```

So instead of simulating each orange separately:

```
Start BFS from all rotten oranges simultaneously
``` 
:contentReference[oaicite:1]{index=1}

---

# Intuition

Think of rotten oranges as:

```
starting points of infection
```

Each minute:

```
infection spreads to neighbors
```

This is exactly:

```
BFS level traversal
```

Each level =

```
1 minute
```

---

# Strategy (Multi-Source BFS)

Steps:

```
1️⃣ Traverse grid:
      add all rotten oranges (2) to queue
      count fresh oranges

2️⃣ While queue not empty:

      process all nodes at current level
      for each rotten orange:
            infect adjacent fresh oranges

      decrease fresh count
      increment time

3️⃣ After BFS:
      if fresh > 0 → return -1
      else return time
```

---

# Optimal Java Solution

```java
class Solution {
    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        // Step 1: initialize
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                if(grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }

                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        int time = 0;

        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        // Step 2: BFS
        while(!queue.isEmpty() && fresh > 0){

            int size = queue.size();

            for(int i = 0; i < size; i++){

                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];

                for(int[] d : directions){

                    int nr = r + d[0];
                    int nc = c + d[1];

                    if(nr < 0 || nc < 0 || nr >= m || nc >= n || grid[nr][nc] != 1){
                        continue;
                    }

                    grid[nr][nc] = 2;
                    queue.offer(new int[]{nr, nc});
                    fresh--;
                }
            }

            time++;
        }

        return fresh == 0 ? time : -1;
    }
}
```

---

# Dry Run

Input

```
grid = [
  [2,1,1],
  [1,1,0],
  [0,1,1]
]
```

Step 1:

```
Queue = [(0,0)]
fresh = 6
```

Step 2:

```
Minute 1:
→ infect neighbors
fresh = 4

Minute 2:
→ infect next layer
fresh = 2

Minute 3:
→ infect next layer
fresh = 1

Minute 4:
→ infect last orange
fresh = 0
```

Result:

```
time = 4
```

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

Queue stores grid cells in worst case. :contentReference[oaicite:3]{index=3}

---

# Key Tricks

### 1️⃣ Multi-source BFS

```
Start from all rotten oranges
```

---

### 2️⃣ Process level by level

```
Each level = 1 minute
```

---

### 3️⃣ Track fresh count

```
If fresh > 0 after BFS → return -1
```

---

### 4️⃣ Avoid revisiting

```
Mark fresh → rotten immediately
```

---

# Pattern Recognition

This problem belongs to:

```
Grid BFS + Multi-Source BFS Pattern
```

Similar problems:

```
Walls and Gates
01 Matrix
Shortest Path in Grid
Islands and Treasure
```

---

# Summary

Core idea:

```
Start BFS from all rotten oranges
Spread rot level by level
Count time using BFS layers
Check if any fresh orange remains
```

---

# Takeaway

Whenever you see:

```
spreading process
minimum time
multiple starting points
```

Think immediately:

```
Multi-Source BFS
```

Because:

```
BFS naturally models level-by-level spreading
```

https://neetcode.io/problems/rotting-fruit/question?list=neetcode150

https://leetcode.com/problems/rotting-oranges/
