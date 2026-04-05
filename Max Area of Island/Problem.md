# 695. Max Area of Island

🔗 Problem: https://leetcode.com/problems/max-area-of-island/

---

# Problem

You are given an `m x n` binary matrix `grid` where:

```
1 = land
0 = water
```

An island is a group of connected `1`s connected:

```
horizontally or vertically
```

Return the **maximum area of an island** in the grid.

The area of an island is:

```
the number of cells with value 1 in that connected component
```

If there is no island, return:

```
0
```

---

# Example

### Example 1

Input
```
grid = [
  [0,0,1,0,0,0,0,1,0,0,0,0,0],
  [0,0,0,0,0,0,0,1,1,1,0,0,0],
  [1,1,1,1,1,0,0,0,0,0,0,0,0],
  [0,0,0,1,1,0,0,0,1,1,1,0,0],
  [0,0,0,0,0,0,0,0,1,1,1,0,0]
]
```

Output
```
6
```

Explanation

There are multiple islands in the grid.

One of the largest islands is:

```
1 1 1
1 1 1
```

Its area is:

```
6
```

So the maximum island area is:

```
6
```

---

### Example 2

Input
```
grid = [
  [0,0,0,0,0,0,0,0]
]
```

Output
```
0
```

Explanation

There is no land cell, so there is no island.

---

# Key Idea

This problem is almost the same pattern as **Number of Islands**, but instead of counting how many islands exist, we compute:

```
area of each island
```

Then keep track of:

```
maximum area found so far
```

So whenever we find a new land cell:

```
run DFS/BFS
compute size of that connected component
update max area
```

---

# Intuition

Every island is a connected component of land cells.

If we start DFS from one land cell, we can visit:

```
all land cells belonging to that island
```

While exploring, we count:

```
how many land cells are part of this island
```

That gives us the area of one island.

Then we compare it with the global maximum.

---

# Strategy (DFS Flood Fill)

Steps:

```
1️⃣ Traverse every cell in the grid

2️⃣ If cell == 1:
      run DFS to calculate island area

3️⃣ In DFS:
      mark current cell as visited
      return 1 + area of 4 neighbors

4️⃣ Update maxArea with returned island area

5️⃣ Return maxArea
```

We mark visited cells by changing:

```
1 → 0
```

So we do not revisit the same island.

---

# Optimal Java Solution

```java
class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        int maxArea = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){

                if(grid[i][j] == 1){
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }

        return maxArea;
    }

    public int dfs(int[][] grid, int r, int c){

        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0){
            return 0;
        }

        grid[r][c] = 0;

        return 1
             + dfs(grid, r + 1, c)
             + dfs(grid, r - 1, c)
             + dfs(grid, r, c + 1)
             + dfs(grid, r, c - 1);
    }
}
```

---

# Dry Run

Input

```
grid = [
  [0,0,1,0],
  [0,1,1,0],
  [0,0,1,0],
  [1,0,0,0]
]
```

Grid visualization

```
0 0 1 0
0 1 1 0
0 0 1 0
1 0 0 0
```

Steps

```
Cell (0,2) = 1
→ start DFS
```

DFS visits:

```
(0,2), (1,2), (1,1), (2,2)
```

Area returned:

```
4
```

Update:

```
maxArea = 4
```

Continue scanning:

```
Cell (3,0) = 1
→ DFS area = 1
```

Compare:

```
max(4,1) = 4
```

Final answer:

```
4
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

Worst case recursion stack when entire grid is land.

---

# Key Tricks

### 1️⃣ DFS returns area

Instead of just marking visited, return:

```
1 + neighbors' area
```

---

### 2️⃣ Mark visited in-place

```
grid[r][c] = 0
```

This avoids extra visited array.

---

### 3️⃣ Update max after each island

```
maxArea = Math.max(maxArea, currentArea)
```

---

# Pattern Recognition

This problem belongs to:

```
Grid DFS / BFS / Connected Components Pattern
```

Similar problems:

```
Number of Islands
Flood Fill
Surrounded Regions
Rotting Oranges
Island Perimeter
```

---

# Summary

Core idea:

```
Traverse the grid
When land is found:
    run DFS
    compute island area
    update maximum
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
connected land cells
largest region / component size
```

Think immediately:

```
DFS/BFS flood fill + count component size
```

Because:

```
Each island is just one connected component
```


https://neetcode.io/problems/max-area-of-island/question?list=neetcode150

https://leetcode.com/problems/max-area-of-island/description/