# 200. Number of Islands

🔗 Problem: https://leetcode.com/problems/number-of-islands/

---

# Problem

Given an `m x n` 2D binary grid `grid` where:

```
'1' = land
'0' = water
```

Return the **number of islands**.

An island is formed by connecting adjacent lands horizontally or vertically.

Important:

```
You may assume all four edges of the grid are surrounded by water
```

---

# Example

### Example 1

Input
```
grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
```

Output
```
1
```

Explanation

```
All connected land cells belong to one big island
```

Visual:

```
1 1 1 1 0
1 1 0 1 0
1 1 0 0 0
0 0 0 0 0
```

There is only:

```
1 island
```

---

### Example 2

Input
```
grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
```

Output
```
3
```

Explanation

Visual:

```
1 1 0 0 0
1 1 0 0 0
0 0 1 0 0
0 0 0 1 1
```

The islands are:

```
Island 1 → top-left block
Island 2 → middle single land
Island 3 → bottom-right block
```

So total islands:

```
3
```

---

# Key Idea

The key observation:

```
Each time we find an unvisited land cell,
we have discovered a new island
```

After finding that land cell, we must mark **all connected land cells** as visited.

This is a classic:

```
Graph / Grid Traversal problem
```

We can solve it using:

```
DFS or BFS
```

---

# Intuition

Think of every land cell as part of a connected component.

If two land cells touch:

```
up, down, left, right
```

they belong to the same island.

So the process is:

```
Scan the grid
If you see a new land cell:
    count one island
    flood-fill all connected land
```

That way, each island is counted exactly once.

---

# Strategy (DFS Flood Fill)

Steps:

```
1️⃣ Traverse every cell in the grid

2️⃣ If cell == '1':
      increment island count

3️⃣ Run DFS from that cell:
      mark current cell as visited
      explore up, down, left, right

4️⃣ Continue scanning grid
```

To mark visited, we can simply change:

```
'1' → '0'
```

This avoids using an extra visited array.

---

# Optimal Java Solution

```java
class Solution {
    public int numIslands(char[][] grid) {

        int count = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){

                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    public void dfs(char[][] grid, int r, int c){

        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0'){
            return;
        }

        grid[r][c] = '0';

        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }
}
```

---

# Dry Run

Input

```
grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
```

Steps

```
Start scanning from top-left

Cell (0,0) = '1'
→ new island found
count = 1

Run DFS
Mark all connected lands in top-left block as visited
```

Grid becomes effectively:

```
0 0 0 0 0
0 0 0 0 0
0 0 1 0 0
0 0 0 1 1
```

Continue scanning:

```
Cell (2,2) = '1'
→ new island
count = 2
```

Run DFS and mark it visited.

Continue scanning:

```
Cell (3,3) = '1'
→ new island
count = 3
```

DFS marks `(3,3)` and `(3,4)`.

Final count:

```
3
```

---

# Complexity Analysis

### Time Complexity

```
O(m * n)
```

Where:

```
m = number of rows
n = number of columns
```

Each cell is visited at most once.

---

### Space Complexity

```
O(m * n)
```

In the worst case due to recursion stack when all cells are land.

Average case is smaller, but worst case for DFS recursion is:

```
O(m * n)
```

---

# Key Tricks

### 1️⃣ Count only when you find fresh land

```
if(grid[i][j] == '1')
```

This guarantees one count per island.

---

### 2️⃣ Flood fill immediately

```
Mark all connected land as visited
```

So the same island is not counted again.

---

### 3️⃣ Modify grid in-place

```
'1' → '0'
```

Saves extra visited array space.

---

# Pattern Recognition

This problem belongs to:

```
Grid DFS / BFS / Connected Components Pattern
```

Similar problems:

```
Max Area of Island
Flood Fill
Surrounded Regions
Rotting Oranges
Number of Connected Components
```

---

# Summary

Core idea:

```
Traverse grid
Whenever you find land:
    count one island
    run DFS to mark the whole island visited
```

Final complexity:

```
Time  : O(m * n)
Space : O(m * n) worst case recursion
```

---

# Takeaway

Whenever you see:

```
2D grid
count connected groups
islands / regions / components
```

Think immediately:

```
DFS or BFS flood fill
```

Because:

```
Each connected component should be explored fully once
```

https://neetcode.io/problems/count-number-of-islands/question

https://leetcode.com/problems/number-of-islands/
